package web_ajax;


import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1, 		//한개의 파일 전송 크기 : 2메가 (temp이다. 임시 저장이다.)
		maxFileSize = 1024 * 1024 * 10, 			//파일 한개당 최대크기 : 6메가
		maxRequestSize = 1024 * 1024 * 30
)
		
public class board_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String content = request.getParameter("content");		
		System.out.println(content);

		//파일 속성을 체크하기 위한 배열값
		String filetype[] = {"bmp", "jpg", "jpeg", "png", "svg", "webp"};
		
		//저장되는 웹 경로
		String url = request.getServletContext().getRealPath("/upload/");
		
		//프런트에서 넘어온 name에 대한 파일 첨부사항을 체크하는 클래스 배열을 이용하여 Part 자료형으로 저장시킴
		Collection<Part> pt = request.getParts();
		
		for(Part p : pt) {	//foreach를 이용하여 파일에 대한 각각 분리 작업
			if(p.getName().equals("file") && p.getSize() > 0) {
			String filename = p.getSubmittedFileName();
			if(!filename.equals("")) {
				p.write(url + filename);
			}
			System.out.println(filename);
		}
	}
}

}





