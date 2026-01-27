package model;

public class edu_dto {
	 public Integer getEidx() {
		return eidx;
	}
	public void setEidx(Integer eidx) {
		this.eidx = eidx;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	Integer eidx;
	String mid,mname,subject,indate;
	String ctn;		//데이터 총 갯수
	public String getCtn() {
		return ctn;
	}
	public void setCtn(String ctn) {
		this.ctn = ctn;
	}
}
