package com.postservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.CRUD;
import com.empdetails.Employee;
import com.empdetails.UserSheet;

/**
 * Servlet implementation class LoginData
 */
@WebServlet("/LoginData")
public class LoginData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int empId=Integer.parseInt(request.getParameter("empId"));
		String userName=request.getParameter("userName");
		
		Employee emp=new Employee(empId,userName);
		CRUD crud=new CRUD();
		if(crud.isUser(empId)) {
			boolean s=crud.logInDetails(emp);
			if(s) {
				HttpSession session = request.getSession();
				session.setAttribute("empId",empId);
//				RequestDispatcher dispatcher=request.getRequestDispatcher("user.jsp");
//				dispatcher.forward(request, response);
				response.setContentType("text/html");
				PrintWriter pen=response.getWriter();
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
						
						+ "<a href='LogoutData?empId="+empId+"' class=\"btn\">Log out</a>\r\n"
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
				List<UserSheet> workSheet=crud1.getWorkSheet(empId);
				for(UserSheet sheet:workSheet) {
					pen.println(
							"<div class=\"row\">"
							+"<h4>"+sheet.getInDate()+"</h4>"
							+"<h4>"+sheet.getInTime()+"</h4>"
							+"<h4>"+sheet.getOutDate()+"</h4>"
							+"<h4>"+sheet.getOutTime()+"</h4>"
							+ "</div>"
							);
				}
				
				pen.println("</div>");
				pen.println("</div>");
//				pen.println("<script src=\"js/worksheet.js\"></script>");
				pen.println("</body>");
				pen.println("</html>");
				
				

			}
			
		}else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("SignUp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
