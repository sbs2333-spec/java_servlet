package cms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.edu_dto;

public class pg_elist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//검색, 페이징 번호, 최초 로그인 사용자가 보는 페이지
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");	//사용자가 검색어를 입력할 경우
		
		HttpSession hs = request.getSession();	//로그인 정보
		String message = "";
		ArrayList<edu_dto> alldata = null;
		
		//사용자가 페이지 번호를 클릭 및 최초 해당 페이지 접근시(페이지번호가 없을 경우)
		Integer pno = 0;
		String ck = request.getParameter("pno");
		if(ck != null) {
			pno = Integer.valueOf(ck);
		}
		else {
			pno = 1;
		}
		//끝
		
		Integer total = 0;	//해당 변수는 페이지 네이션에서 데이터 총 갯수에 맞는 정보를 확인하기 위한 변수값
		
		if(hs.getAttribute("mid") == null || hs.getAttribute("mname") == null) {
			message = "alert('로그인을 하셔야만 접근이 가능합니다.'); location.href='../member_login.jsp';";
		}
		else {
			String mid = (String)hs.getAttribute("mid");
			try {
				
				if(search == null) {	//검색어가 없을 경우 해당 아이디로 신청한 모든 과목 리스트를 가져옴
					alldata = new mysql_querys().edu_lists(mid,pno);
					//수강데이터가 있을 경우만 total 변수에 해당 아이디에 맞는 데이터 총 갯수를 이관함
					if(alldata.size() > 0) {
						total = Integer.valueOf(alldata.get(0).getCtn());
					}
					search = "";	//html에 value값에 null 단어를 출력하지 않도록 하기위함
				}
				else {	//검색어가 있을 경우 해당 데이터를 검토하여 리스트를 가져옴
					alldata = new mysql_querys().edu_search(mid,search);
				}
				
			}catch (Exception e) {
				System.out.println(e);
				message = "alert('시스템 점검으로 인하여 서비스 불편 드렸습니다.'); history.go(-1);";
			}
		}
		
		request.setAttribute("total", total);   //아이디에 맞는 데이터 총 갯수
		request.setAttribute("search", search);		//검색어를 jsp에서 출력하기 위함
		request.setAttribute("alldata", alldata);
		request.setAttribute("result", message);
		RequestDispatcher rd = request.getRequestDispatcher("../pg_elist.jsp");
		rd.forward(request, response);
	}
	
	//강의시작, 수강취소
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Front-end에서 form으로 post 전송을 적용한 사항
		String security = request.getParameter("security");
		String mid = request.getParameter("mid");
		String eidx = request.getParameter("eidx");
		
		String result = "";
		if(security.equals("educode") && !mid.equals("")) {
			try {
				//해당 정보를 삭제하는 model을 이용하여 데이터를 삭제처리함 (결과를 return 받음)
				Integer sign = new mysql_querys().edu_delete(eidx, mid);
				
				if(sign > 0) {
					result = "alert('해당 과목에 대한 수강취소가 정상적으로 적용 되었습니다.'); location.href='./pg_elist.do';";
				}
				else {	//삭제처리 결과가 0 일 경우 해당 메세지를 출력
					result = "alert('접속 서버 점검으로 서비스가 올바르지 않습니다.'); location.href='/index.jsp';";
				}
			}catch (Exception e) {	//쿼리문 오류 발생시
				result = "alert('접속 서버 점검으로 서비스가 올바르지 않습니다.'); location.href='/index.jsp';";
				System.out.println(e);
			}
		}
		else {
			result = "alert('올바른 접근이 아닙니다.'); history.go(-1);";
		}
		request.setAttribute("result", result);	//결과값을 해당 jsp에 전달
		RequestDispatcher rd = request.getRequestDispatcher("./message.jsp"); //javascript 메세지 출력
		rd.forward(request, response);
	}

}
