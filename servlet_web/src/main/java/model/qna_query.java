package model;

import java.sql.*;
import java.util.ArrayList;

public class qna_query {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // DB 연결 메서드 (이미지의 dbinfo 구조 활용)
    
    public void db_connect() {
        try {
            // new dbinfo()를 하지 않고, 클래스명.메서드명()으로 직접 호출합니다.
            this.conn = dbinfo.info(); 
        } catch (Exception e) {
            System.out.println("DB 연결 실패: " + e.getMessage());
        }
    }
    
    // [중요] 1. 질문 등록하기 (선생님 가이드: 작성자는 hidden, 상태는 0)
    public int insert_qna(qna_dto dto) {
        int result = 0;
        db_connect();
        // status는 기본값 0으로 들어가므로 쿼리에서 생략하거나 명시해줍니다.
        String sql = "insert into qna_board (category, title, content, writer, status) values (?, ?, ?, ?, 0)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getCategory());
            pstmt.setString(2, dto.getTitle());
            pstmt.setString(3, dto.getContent());
            pstmt.setString(4, dto.getWriter()); // 세션에서 받아온 ID
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db_close();
        }
        return result;
    }

    // 2. 질문 목록 가져오기 (선생님 가이드: 10개씩 출력용)
    
 // 기존 select_all을 아래처럼 '시작번호'를 받도록 수정합니다.
    public ArrayList<qna_dto> select_all(int start_no) {
        ArrayList<qna_dto> list = new ArrayList<>();
        db_connect();
        // 시작번호(start_no)부터 10개만 가져오라는 명령어입니다.
        String sql = "select * from qna_board order by q_id desc limit ?, 10";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start_no); 
            rs = pstmt.executeQuery();
            while (rs.next()) {
                qna_dto dto = new qna_dto();
                dto.setQ_id(rs.getInt("q_id"));
                dto.setCategory(rs.getString("category"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setReg_date(rs.getTimestamp("reg_date"));
                dto.setHit(rs.getInt("hit"));
                dto.setStatus(rs.getInt("status"));
                list.add(dto);
            }
        } catch (Exception e) { e.printStackTrace(); }
        finally { db_close(); }
        return list;
    }
    

    // 자원 해제 메서드
    public void db_close() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}