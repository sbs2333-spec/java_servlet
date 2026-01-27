package model;

import java.security.MessageDigest;

public class md5_pw {
	
	MessageDigest md = null;
	StringBuffer sb = null;
	byte by[] = null;
	
	//md5
	public String md5_encode(String pw) throws Exception {
		String repw = "";
		this.md = MessageDigest.getInstance("md5");
		this.md.update(pw.getBytes());
		this.by = this.md.digest();
		this.sb = new StringBuffer();
		for(byte a : this.by) {
			this.sb.append(String.format("%x", a));
		}
		return String.valueOf(this.sb);
	}
		
}
