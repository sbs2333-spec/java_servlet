package event;

import java.security.MessageDigest;

//md5로 변환하는 패스워드 정책 모델
public class repass_word {
	
	//사용자가 입력한 패스워드를 필드에 적용함
	public String repass(String pw) throws Exception {
		MessageDigest md = MessageDigest.getInstance("md5");
		md.update(pw.getBytes());
		byte md5pw[] = md.digest();
		String data = "";
		for(byte aa : md5pw) {
			data += String.format("%x", aa);
		}
		
		return data;
	}
	
	
}
