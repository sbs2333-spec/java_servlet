package web_ajax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/notice_write_from_soonsoo_brother.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 10 * 1024 * 1024,
maxRequestSize = 20 * 1024 * 1024
)
public class notice_write_from_soonsoo_brother extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String content = req.getParameter("content");

        System.out.println(title);
        System.out.println(author);
        System.out.println(content);
        
        Part filePart = null;
        try {
            filePart = req.getPart("attach");
        } catch (Exception ignored) {}

        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String uploadPath = req.getServletContext().getRealPath("/upload");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists())
            	uploadDir.mkdirs();
            filePart.write(uploadPath + File.separator + fileName);

            pw.write("<script>"
					+"alert('해당 파일을 저장하였습니다.');"
					+"location.href='../ajax/notice_write_from_soonsoo_brother.html';"
					+"</script>"
					);
        }
        else
        {
            pw.write("<script>"
    				+"alert('공지사항이 정상으로 등록 되었습니다');"
					+"location.href='../ajax/notice_write_from_soonsoo_brother.html';"
    				+"</script>"
    				);
        }
		pw.close();

//        // 간단히 결과 페이지로 포워드 (실제 구현 시 DB 저장 등 필요)
//        req.setAttribute("title", title);
//        req.setAttribute("author", author);
//        req.setAttribute("content", content);
//        req.setAttribute("fileName", fileName);
//
//        req.getRequestDispatcher("/web_ajax/notice_write_result.jsp").forward(req, resp);
    }
}
//
//@WebServlet("/notice_write")
//public class notice_write extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public notice_write() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
