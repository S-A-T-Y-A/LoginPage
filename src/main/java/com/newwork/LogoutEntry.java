package com.newwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.CRUD;

/**
 * Servlet implementation class LogoutEntry
 */
@WebServlet("/LogoutEntry")
public class LogoutEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String uniqueCode=request.getParameter("uniqueCode");
		System.out.println(uniqueCode);
		CRUD crud=new CRUD();
		boolean status=crud.logoutentry(uniqueCode);
		if(status) {
//			PrintWriter pen=response.getWriter();
//			pen.println(request.getParameter("uniqueCode"));
//			pen.println(status);
//			pen.println("<a href=\"index.jsp\">Home</a>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(null,null);
//			dispatcher.include(request, response);
		}
	}

}
