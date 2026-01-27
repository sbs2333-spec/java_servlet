package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2, 		//한개의 파일 전송 크기 : 2메가 (temp이다. 임시 저장이다.)
		maxFileSize = 1024 * 1024 * 3, 			//파일 한개당 최대크기 : 3메가
		maxRequestSize = 1024 * 1024 * 100
		
	)

public class notice_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		
		PrintWriter pw = response.getWriter();
		try {
			Part mfile = request.getPart("mfile");	
			String filename = mfile.getSubmittedFileName();
			long filesize = mfile.getSize();	//integer으로 하면 에러남. ctrl 누른채 클릭하면 long이라고 나옴
			String file = mfile.getName();
			System.out.println(file);
			System.out.println(filename);
			System.out.println(filesize);
			
			if (filesize > 0) {
				//request.getServletContext()→ WAS의 전체 경로를 설정하는 클래스이다. 
				//getRealPath(디렉토리명) : web 디렉토리를 말한다.
				String url = request.getServletContext().getRealPath("/upload/");
				mfile.write(url + filename);

				pw.write("<script>"
						+ "alert('해당 파일을 올바르게 저장했음');"
						+ "location.href='../ajax/notice_write_ChatGPT.html';"
						+"</script>");
				
			} else {
				pw.write("<script>"
						+ "alert('공지 사항을 등록하였습니다.');"
						+ "location.href='../ajax/notice_write_ChatGPT.html';"
						+"</script>");
				
			}			
					
			pw.close();
			
		} catch (Exception e) {
			
		}
		
	}

}