package web_servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("search");
		try {
			//프런트에서 base64 인코딩으로 보낼 경우 → byte로 변환해서 사용해야 한다.
			byte[] decode = Base64.getDecoder().decode(search);
			String product = new String(decode, StandardCharsets.UTF_8);
			
			//encodeURIComponent : URLDecoder를 decode 할 때 필수로 적용해야만 한다. 반드시!!
			String result = URLDecoder.decode(product);
			
			System.out.println(result);
			
			
		} catch (Exception e) {
			System.out.println("디코딩 에러");
		}
		
		
//		System.out.println(search);
	}
	

}
