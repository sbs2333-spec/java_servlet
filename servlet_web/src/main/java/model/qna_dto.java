package model; // 패키지명을 이미지와 동일하게 model로 수정합니다.

import java.sql.Timestamp;

public class qna_dto {
    private int q_id;
    private String category;
    private String title;
    private String content;
    private String writer;     // 선생님이 강조하신 hidden으로 넘길 작성자 ID
    private Timestamp reg_date;
    private int hit;           // 조회수 카운팅 필요하다고 하셨죠?
    private int status;        // 0:대기, 1:완료
    
    // 답변 관련 필드
    private String answer_title;
    private String answer_content;
    private Timestamp answer_date;

    public qna_dto() {}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAnswer_title() {
		return answer_title;
	}

	public void setAnswer_title(String answer_title) {
		this.answer_title = answer_title;
	}

	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}

	public Timestamp getAnswer_date() {
		return answer_date;
	}

	public void setAnswer_date(Timestamp answer_date) {
		this.answer_date = answer_date;
	}

    // Getter / Setter는 이클립스 기능을 사용해 model 패키지의 다른 파일들처럼 만드세요.
}