package web_servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//doget 으로는 2가지 방식
	/*
	  1. 프런트에서 form으로 get 통신을 하는 경우
	  2. 해당 .do 가상의 주소를 직접 입력하여 결과를 출력해야 하는 경우
	*/
	
	ArrayList<String> data = null;
	public servlet8() {	//즉시 실행
		this.data = new ArrayList<String>();
		this.data.add("권하민");
		this.data.add("허대회");
		this.data.add("박순수");
		this.data.add("신범석");
		this.data.add("김동완");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer user = this.data.size();
		
		request.setAttribute("person", user);
		request.setAttribute("userdata", this.data);		
		
		RequestDispatcher rd = request.getRequestDispatcher("./servlet8.jsp");
		rd.forward(request, response);
	}

}











