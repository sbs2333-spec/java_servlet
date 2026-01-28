package model;

import java.sql.Timestamp;

public class qna_dto {
    private int q_id;
    private String category;
    private String title;
    private String content;
    private String writer;
    private Timestamp reg_date;
    private String indate;     // JSP에서 사용하는 작성일 변수 추가
    private int hit;
    private int status;        // 0:대기, 1:완료
    
    private String answer_title;
    private String answer_content;
    private Timestamp answer_date;

    public qna_dto() {}

    // q_id
    public int getQ_id() { return q_id; }
    public void setQ_id(int q_id) { this.q_id = q_id; }

    // category
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    // title
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    // content
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    // writer
    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    // reg_date
    public Timestamp getReg_date() { return reg_date; }
    public void setReg_date(Timestamp reg_date) { this.reg_date = reg_date; }

    // indate (JSP의 빨간 줄을 없애주는 핵심 메서드)
    public String getIndate() { return indate; }
    public void setIndate(String indate) { this.indate = indate; }

    // hit
    public int getHit() { return hit; }
    public void setHit(int hit) { this.hit = hit; }

    // status
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    // answer_title
    public String getAnswer_title() { return answer_title; }
    public void setAnswer_title(String answer_title) { this.answer_title = answer_title; }

    // answer_content
    public String getAnswer_content() { return answer_content; }
    public void setAnswer_content(String answer_content) { this.answer_content = answer_content; }

    // answer_date
    public Timestamp getAnswer_date() { return answer_date; }
    public void setAnswer_date(Timestamp answer_date) { this.answer_date = answer_date; }
}