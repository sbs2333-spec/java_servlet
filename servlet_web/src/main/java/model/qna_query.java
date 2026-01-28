package model;

import java.sql.*;
import java.util.ArrayList;

public class qna_query {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public void db_connect() {
        try {
            this.conn = dbinfo.info(); 
        } catch (Exception e) {
            System.out.println("DB 연결 실패: " + e.getMessage());
        }
    }

    // 1. 질문 등록하기
    public int insert_qna(qna_dto dto) {
        int result = 0;
        db_connect();
        // 날짜 컬럼은 DB 설정에 따라 reg_date 혹은 indate일 수 있으므로 
        // 쿼리에서 생략(default)하거나 DB 상황에 맞춰 처리해야 합니다.
        String sql = "insert into qna_board (category, title, content, writer, status) values (?, ?, ?, ?, 0)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getCategory());
            pstmt.setString(2, dto.getTitle());
            pstmt.setString(3, dto.getContent());
            pstmt.setString(4, dto.getWriter());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db_close();
        }
        return result;
    }

    // 2. 목록 가져오기 (검색어 유무에 따른 분기 처리 - 가장 확실한 방법)
    public ArrayList<qna_dto> select_all(int start_no, String search) {
        ArrayList<qna_dto> list = new ArrayList<>();
        db_connect();
        
        String sql = "";
        try {
            if (search == null || search.trim().equals("")) {
                // 검색어가 없을 때: 전체 목록
                sql = "select * from qna_board order by q_id desc limit ?, 10";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, start_no);
            } else {
                // 검색어가 있을 때: 조건 검색
                sql = "select * from qna_board where title like ? or writer like ? order by q_id desc limit ?, 10";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + search + "%");
                pstmt.setString(2, "%" + search + "%");
                pstmt.setInt(3, start_no);
            }
            
            rs = pstmt.executeQuery();
            while (rs.next()) {
                qna_dto dto = new qna_dto();
                dto.setQ_id(rs.getInt("q_id"));
                dto.setCategory(rs.getString("category"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setHit(rs.getInt("hit"));
                dto.setStatus(rs.getInt("status"));
                
                // [주의] 만약 에러가 난다면 DB 컬럼명이 indate인지 reg_date인지 꼭 확인하세요!
                // 일단 안전하게 indate를 가져오되, 없으면 reg_date를 시도합니다.
                try {
                    dto.setIndate(rs.getString("indate"));
                } catch (Exception e) {
                    dto.setIndate(rs.getString("reg_date")); // indate가 없으면 reg_date 사용
                }
                
                list.add(dto);
            }
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            db_close(); 
        }
        return list;
    }

    // 3. 전체 개수 가져오기 (분기 처리)
    public int get_total_count(String search) {
        int count = 0;
        db_connect();
        String sql = "";
        try {
            if (search == null || search.trim().equals("")) {
                sql = "select count(*) from qna_board";
                pstmt = conn.prepareStatement(sql);
            } else {
                sql = "select count(*) from qna_board where title like ? or writer like ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + search + "%");
                pstmt.setString(2, "%" + search + "%");
            }
            rs = pstmt.executeQuery();
            if(rs.next()) count = rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        finally { db_close(); }
        return count;
    }

    // ... (상세보기, 답변 등록 등 기존 메서드는 동일) ...
    public qna_dto select_one(String q_id) {
        qna_dto dto = new qna_dto();
        db_connect();
        String sql = "select * from qna_board where q_id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, q_id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                dto.setQ_id(rs.getInt("q_id"));
                dto.setCategory(rs.getString("category"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriter(rs.getString("writer"));
                dto.setHit(rs.getInt("hit"));
                dto.setStatus(rs.getInt("status"));
                try { dto.setIndate(rs.getString("indate")); } catch(Exception e) {}
                dto.setAnswer_title(rs.getString("answer_title"));
                dto.setAnswer_content(rs.getString("answer_content"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        finally { db_close(); }
        return dto;
    }

    public void db_close() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    
 // qna_query.java에 추가
    public void update_hit(String q_id) {
        db_connect();
        // 해당 글 번호(q_id)의 hit를 1 증가시키는 쿼리
        String sql = "update qna_board set hit = hit + 1 where q_id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, q_id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db_close();
        }
    }
    
 // qna_query.java 파일에 추가하세요.
    public java.util.Map<String, Integer> get_admin_stats() {
        java.util.Map<String, Integer> stats = new java.util.HashMap<>();
        db_connect();
        try {
            // 1. 회원 수 (member 테이블)
            pstmt = conn.prepareStatement("select count(*) from member");
            rs = pstmt.executeQuery();
            if(rs.next()) stats.put("member_count", rs.getInt(1));

            // 2. 과목 수 (subject 테이블 - 실제 테이블명에 맞춰 수정하세요)
            pstmt = conn.prepareStatement("select count(*) from subject");
            rs = pstmt.executeQuery();
            if(rs.next()) stats.put("subject_count", rs.getInt(1));

            // 3. 공지사항 수 (notice 테이블)
            pstmt = conn.prepareStatement("select count(*) from notice");
            rs = pstmt.executeQuery();
            if(rs.next()) stats.put("notice_count", rs.getInt(1));

            // 4. Q&A 수 (qna_board 테이블)
            pstmt = conn.prepareStatement("select count(*) from qna_board");
            rs = pstmt.executeQuery();
            if(rs.next()) stats.put("qna_count", rs.getInt(1));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db_close();
        }
        return stats;
    }
    
    
 // qna_query.java에 이 메서드가 있는지 꼭 확인하세요!
    public int get_total_count_general(String tableName) {
        int count = 0;
        db_connect();
        String sql = "select count(*) from " + tableName;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()) count = rs.getInt(1);
        } catch (Exception e) { 
            // 테이블이 없거나 에러가 나면 0을 반환하도록 방어
            System.out.println(tableName + " 테이블 카운트 에러: " + e.getMessage());
        } finally { 
            db_close(); 
        }
        return count;
    }
    
 // qna_query.java 파일 하단에 추가하세요.
    public int update_answer(qna_dto dto) {
        int result = 0;
        db_connect();
        // 답변 제목, 내용, 날짜를 업데이트하고 답변 상태(status)를 1(완료)로 변경하는 쿼리입니다.
        String sql = "update qna_board set answer_title=?, answer_content=?, answer_date=now(), status=1 where q_id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getAnswer_title());
            pstmt.setString(2, dto.getAnswer_content());
            pstmt.setInt(3, dto.getQ_id());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("답변 등록 에러: " + e.getMessage());
        } finally {
            db_close();
        }
        return result;
    }
    
}