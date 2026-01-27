package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.admin_query;
import model.cate_dto;

public class cate_modifyok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter pw = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String cate_code = request.getParameter("cate_code");
		String cate_name = request.getParameter("cate_name");
		String cate_use = request.getParameter("cate_use");
		this.pw = response.getWriter();
		try{
			if(cate_code == null || cate_name == null || cate_use == null) {
				this.pw.print("<script>"
						+ "alert('올바른 접근이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			else {
				//수정 및 최초 입력시 매개변수가 너무 많을 경우 DTO를 이용하여 매개변수로 전달 할 수 있다.
				cate_dto dto = new cate_dto();
				//DTO (setter) 값을 적용하여 Model 전달함
				dto.setCate_code(cate_code);
				dto.setCate_name(cate_name);
				dto.setCate_use(cate_use);
				Integer result = new admin_query().cate_update(dto);
				if(result > 0) {
					this.pw.print("<script>"
							+ "alert('해당 카테고리가 정상적으로 수정되었습니다.');"
							+ "location.href='./cate_list.do';"
							+ "</script>");
				}
				else {
					this.pw.print("<script>"
							+ "alert('개발자의 실수임.');"
							+ "history.go(-1);"
							+ "</script>");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			this.pw.print("<script>"
					+ "alert('올바른 접근이 아닙니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		finally {
			this.pw.close();
		}
	}

}
