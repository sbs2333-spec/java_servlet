package model;

public class subject_dto {
	Integer sidx,class_time,class_level,max_no;
	public Integer getSidx() {
		return sidx;
	}
	public void setSidx(Integer sidx) {
		this.sidx = sidx;
	}
	public Integer getClass_time() {
		return class_time;
	}
	public void setClass_time(Integer class_time) {
		this.class_time = class_time;
	}
	public Integer getClass_level() {
		return class_level;
	}
	public void setClass_level(Integer class_level) {
		this.class_level = class_level;
	}
	public Integer getMax_no() {
		return max_no;
	}
	public void setMax_no(Integer max_no) {
		this.max_no = max_no;
	}
	public String getCate_code() {
		return cate_code;
	}
	public void setCate_code(String cate_code) {
		this.cate_code = cate_code;
	}
	public String getSubject_nm() {
		return subject_nm;
	}
	public void setSubject_nm(String subject_nm) {
		this.subject_nm = subject_nm;
	}
	public String getTeacher_nm() {
		return teacher_nm;
	}
	public void setTeacher_nm(String teacher_nm) {
		this.teacher_nm = teacher_nm;
	}
	public String getClass_text() {
		return class_text;
	}
	public void setClass_text(String class_text) {
		this.class_text = class_text;
	}
	public String getSubject_text() {
		return subject_text;
	}
	public void setSubject_text(String subject_text) {
		this.subject_text = subject_text;
	}
	public String getStart_day() {
		return start_day;
	}
	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}
	public String getEnd_day() {
		return end_day;
	}
	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}
	public String getClass_use() {
		return class_use;
	}
	public void setClass_use(String class_use) {
		this.class_use = class_use;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	String cate_code, subject_nm, teacher_nm,class_text,subject_text,start_day;
	String end_day,class_use,indate;
}
