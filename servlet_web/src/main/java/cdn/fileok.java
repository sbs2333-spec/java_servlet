package cdn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.query3;

//첨부 파일이 있으면 무조건 아래 코드가 있어야 함. 그리고, 무조건 post만 됨
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 100
)

public class fileok extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//파일 저장 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	//한글을 위해서 넣어야 함
		Part f_img = request.getPart("f_img");
		String filename = f_img.getSubmittedFileName();
		try{
			String url = request.getServletContext().getRealPath("/upload/");
			System.out.println(url);
			//파일을 저장 후에 db에 insert 한다.
			f_img.write(url + filename);
			
			String saveurl = "./upload/" + filename;  //db에 상대경로 위치를 적용해야 한다.
			Integer result = new query3().file_save(filename, saveurl);
			
			System.out.println();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {

		}
	}

}
