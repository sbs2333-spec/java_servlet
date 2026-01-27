package cdn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class api_cdn extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//database에 있는 값을 가져오는 형태 (db가 없는 관계로 원시 배열을 활용함)
		String data[][]= {
				{"a1", "a2", "a3", "a4"},
				{"a1.jpg", "a2.jpg", "a3.jpg", "a4.jpg"},
		};
		//request.getPathInfo() → /cdn/api_cdn/* → *에 있는 값을 가져오는 형태
		String filenm = request.getPathInfo().substring(1); //substring(1) → 0번을 제외한다. ※ 배열이므로 0번이 1
		String url = getServletContext().getRealPath("/img/");  //web 경로
//		System.out.println(filenm);
		
		String view_img = "";  //파일 위치에 경로를 가져오는 변수
		int w = 0;
		while(w < data[0].length) {
			if(data[0][w].equals(filenm)) {
				view_img = url + data[1][w];	//해당 배열에 데이터가 있을 경우 이관
				break;	
				}
				w++;
			}
			/* Java I/O */
//			System.out.println(view_img);
			File f = new File(view_img);
			FileInputStream fs = new FileInputStream(f);
			OutputStream os = response.getOutputStream();  //cdn 서버에 출력
			byte by[] = new byte[fs.available()];
					 
			int b;
			while((b = fs.read(by)) != -1) {
				os.write(by, 0, b);
			}
			os.flush();
			os.close();
			fs.close();
	}
}

