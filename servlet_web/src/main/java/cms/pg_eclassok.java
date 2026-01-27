package cms;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import model.edu_dto;

public class pg_eclassok extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		edu_dto dto = new edu_dto();
		try {
			/*
			Map<String, String[]> pm = request.getParameterMap();
			System.out.println(request.getParameterMap());
			for(String k : pm.keySet()) {
				String ck[] = pm.get(k);
				System.out.println(Arrays.toString(ck));
			}
			*/
			BeanUtils.populate(dto, request.getParameterMap());
			int result = new mysql_querys().esubject(dto);
			String message = "";
			if(result > 0) {
				message = "alert('올바르게 온라인 신청이 완료 되었습니다.'); location.href='../index.jsp'";
			}
			else {
				message = "alert('서비스 점검으로 인하여 신청이 되지 않았습니다.'); history.go(-1);";
			}
			request.setAttribute("result", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("./message.jsp");
		rd.forward(request, response);
	}
}
//class명 중복 부분 주의사항
//class insert_eclass extends query{};


