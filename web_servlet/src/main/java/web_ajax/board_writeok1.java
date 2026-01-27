package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
public class board_writeok1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		String content = request.getParameter("content");		
		System.out.println(content);
		Part file1 = request.getPart("file1");
		Part file2 = request.getPart("file2");
		Part file3 = request.getPart("file3");
		
		PrintWriter pw = response.getWriter();
		String filetype[] = {"bmp", "jpg", "jpeg", "png", "svg", "webp"};
		String url = request.getServletContext().getRealPath("/upload/");
		System.out.println(url);
		
		if(file1.getSize() > 2097152 || file2.getSize() > 2097152 || file3.getSize() > 2097152 ) {
			pw.write("<script>"
					+ "alert('파일은 최대 2메가 이하로만 첨부됨');"
					+"history.go(-1);"
					+"</script>");
		} 
		else {
			ArrayList<String> savecheck = new ArrayList<String>();
			
			int w = 0;
			while(w < filetype.length) {
				if(file1.getContentType().contains(filetype[w])) {
					file1.write(url + file1.getSubmittedFileName());
					savecheck.add("ok");
				}
				if(file2.getContentType().contains(filetype[w])) {
					file2.write(url + file2.getSubmittedFileName());					
					savecheck.add("ok");
				}
				if(file3.getContentType().contains(filetype[w])) {
					file3.write(url + file3.getSubmittedFileName());					
					savecheck.add("ok");
				}
				w++;
			}
			pw.write("<script>"					
					+ "alert('파일 총 " + savecheck.size() + "개가 등록되었습니다.');"
					+ "alert('정상적으로 게시판이 등록되었습니다.');"
					+"location.href='http://naver.com';"
					+"</script>");
			
			}
			pw.close();

	}
		/*
		System.out.println(file1.getSize());
		System.out.println(file2.getContentType());
		System.out.println(file3.getSubmittedFileName());
		*/
		
}
