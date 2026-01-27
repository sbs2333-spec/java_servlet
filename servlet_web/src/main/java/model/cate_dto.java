package model;

public class cate_dto {
	String cate_code,cate_name,cate_use;
	String ctn;
	Integer subject_ea;
	
	public Integer getSubject_ea() {
		return subject_ea;
	}

	public void setSubject_ea(Integer subject_ea) {
		this.subject_ea = subject_ea;
	}

	public String getCtn() {
		return ctn;
	}

	public void setCtn(String ctn) {
		this.ctn = ctn;
	}

	public String getCate_code() {
		return cate_code;
	}

	public void setCate_code(String cate_code) {
		this.cate_code = cate_code;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public String getCate_use() {
		return cate_use;
	}

	public void setCate_use(String cate_use) {
		this.cate_use = cate_use;
	}
}
