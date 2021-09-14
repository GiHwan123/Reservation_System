package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CustomerDAO;
import model.dao.ReservationDAO;
import model.dto.Customer;
import model.dto.Reservation;


@WebServlet("/reservation")
public class Controller extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		if(command.equals("customerinsert")) {
			customerAdd(request,response);
		}else if(command.equals("login")){
			check(request,response);
		}else if(command.equals("reservationadd")){
			reservationAdd(request, response);
		}else if(command.equals("reservationdelete")) {
			reservationDelete(request, response);
		}else if(command.equals("selectallreservation")) {
			reservationSelect(request, response);
		}
	}
	
	protected void customerAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		if(id != null && id.length() !=0) {
		
			Customer customer = new Customer(id,pw);
			try{
				boolean result = CustomerDAO.addCustomer(customer);
				if(result){
					request.setAttribute("customer", customer);
					request.setAttribute("successMsg", "가입 완료");
					url = "customer/registersuccess.jsp";
				}else{
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			}catch(Exception s){
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	
	protected void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String c_id = CustomerDAO.isMember(id, pw);
		
		if(id.equals(c_id)) {
			HttpSession session = request.getSession();
			session.setAttribute("successMsg", "로그인 성공");
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			request.getRequestDispatcher("customer/loginsuccess.jsp").forward(request, response);
		}else if(c_id==null){
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			session.setAttribute("pw",pw);
			request.getRequestDispatcher("customer/loginfail.jsp").forward(request, response);
			
		}
	}
	
	protected void reservationAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("CheckIn");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		long number= CustomerDAO.select(id);
		boolean result = ReservationDAO.addReservation(number, date);
		if(result==true) {
			request.getRequestDispatcher("reservation/makesuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("reservation/makefail.jsp").forward(request, response);
		}
		
	}
	
	protected void reservationDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("CheckIn");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		long number= CustomerDAO.select(id);
		boolean result = ReservationDAO.deleteReservation(number, date);
		System.out.println(result);
		if(result==true) {
			request.getRequestDispatcher("reservation/deletesuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("reservation/deletefail.jsp").forward(request, response);
		}
		
	}
	
	protected void reservationSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		long number= CustomerDAO.select(id);
		ArrayList<Reservation> all = ReservationDAO.selectAllReservation(number);
		request.setAttribute("All", ReservationDAO.selectAllReservation(number));
		request.getRequestDispatcher("mypage/select.jsp").forward(request, response);
		
	}
}
