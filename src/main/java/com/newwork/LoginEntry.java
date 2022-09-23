package com.newwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.CRUD;
import com.empdetails.UserSheet;

/**
 * Servlet implementation class LoginEntry
 */
@WebServlet("/LoginEntry")
public class LoginEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UniqueCode code=new UniqueCode();
		String uniqueCode=code.getUniqueCode();
		response.setContentType("text/html");
		String userName=request.getParameter("userName");
		int empId=Integer.parseInt(request.getParameter("empId"));
		Logindetails newLogIn=new Logindetails(uniqueCode,Integer.parseInt(request.getParameter("empId")));
		
		CRUD crud=new CRUD();
		boolean status=crud.newLogin(newLogIn);
		if(status && crud.isUser(Integer.parseInt(request.getParameter("empId")))) {
		PrintWriter pen=response.getWriter();
//		pen.println(newLogIn.getUniqueCode());
//		pen.println(status);
		
		
//		pen.println("<a href='LogoutEntry?uniqueCode="+uniqueCode+"'>Logout</a>");
		
		
		pen.println(
				
				 "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>"+userName+" Worksheet</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"css/userdetails.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<div class=\"content\" >\r\n"
				+ "<nav>\r\n"
				+ "<h4>Hello "+userName+" "+empId+"</h4>\r\n"
				+ "<div class=\"btns\">\r\n"
				+"<a href='index.jsp' class=\"btn\">Home</a>"
				+ "<a href='LogoutEntry?uniqueCode="+uniqueCode+"' class=\"btn\">Log out</a>\r\n"
				+ "\r\n"
				+ "</div>\r\n"
				+ "</nav>\r\n");
		pen.println("<div class=\"container\">\r\n"
				+ "        <div class=\"row headline\">\r\n"
				+ "            <h3>Log In Date</h3>\r\n"
				+ "            <h3>Log In Time</h3>\r\n"
				+ "            <h3>Log out Date</h3>\r\n"
				+ "            <h3>Log out Time</h3>\r\n"
				+ "        </div>\r\n");
				
		CRUD crud1=new CRUD();
		List<UserSheet> workSheet=crud1.newgetWorkSheet(empId);
		for(UserSheet sheet:workSheet) {
			
			String inDate=sheet.getInDate();
			String inTime=sheet.getInTime();
			String outDate=sheet.getOutDate();
			String outTime=sheet.getOutTime();
			
			if(outDate==null) {
				outDate="Not logged out";
				outTime="";
			}
			pen.println(
					"<div class=\"row\">"
					+"<h4>"+inDate+"</h4>"
					+"<h4>"+inTime+"</h4>"
					+"<h4>"+outDate+"</h4>"
					+"<h4>"+outTime+"</h4>"
					+ "</div>"
					);
		}
		
		pen.println("</div>");
		pen.println("</div>");
//		pen.println("<script src=\"js/worksheet.js\"></script>");
		pen.println("</body>");
		pen.println("</html>");
		
		

	}else {
		RequestDispatcher dispatcher=request.getRequestDispatcher("SignUp");
		dispatcher.forward(request, response);
	}
		
		}
		
}
