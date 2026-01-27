package web_servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class servlet9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 {
  {"안녕이라 그랬어","정현우","35000"},
  {"노 피플 존","이석영","25000"},
  {"머니 트렌드","정현우","15000"},
  {"부자의 조건","소준섭","20000"},
  {"영혼의 편지","김상욱","28000"},
  {"최소한의 삼국지","정재승","31000"},
  {"이상비행","이금희","29000"}
}
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String data[][]= {
				{"안녕이라 그랬어","정현우","35000"},
				{"노 피플 존","이석영","25000"},
				{"머니 트렌드","정현우","15000"},
				{"부자의 조건","소준섭","20000"},
				{"영혼의 편지","김상욱","28000"},
				{"최소한의 삼국지","정재승","31000"},
				{"이상비행","이금희","29000"}
		};
		
		String sctype = request.getParameter("sctype");
		String scword = request.getParameter("scword");
		ArrayList<ArrayList<String>> result_arr2 = new ArrayList<ArrayList<String>>();  
		
		
		PrintWriter pw = response.getWriter();
		
		if (sctype == null || sctype.equals("") ||
		    scword == null || scword.trim().equals("")) {
			pw.write("<script>"
					+ "alert('해당 접근 방식은 올바르지 않습니다.'); "
					+ "history.go(-1);</script>");
			pw.close();
			return;
		}
		else {
			
			if("bookname".equals(sctype)) {
				for(int a=0; a<data.length; a++) {
					if(data[a][0].contains(scword)) {
						ArrayList<String> result_arr1 = new ArrayList<String>();
						result_arr1.add(data[a][0]);
						result_arr1.add(data[a][1]);
						result_arr1.add(data[a][2]);
						
						result_arr2.add(result_arr1);
					}
				}
			}
			else if("author".equals(sctype)) {
				for(int a=0; a<data.length; a++) {
					if(data[a][1].contains(scword)) {
						ArrayList<String> result_arr1 = new ArrayList<String>();
						result_arr1.add(data[a][0]);
						result_arr1.add(data[a][1]);
						result_arr1.add(data[a][2]);
						
						result_arr2.add(result_arr1);
					}
				}
			}
			
		}
		// System.out.println(result_arr2);
		// System.out.println(result_arr2.size());
		
		Integer count = result_arr2.size();
		request.setAttribute("count", count);
		request.setAttribute("result", result_arr2);
		
		RequestDispatcher rd = request.getRequestDispatcher("./servlet9.jsp");
		rd.forward(request, response);
	}

}