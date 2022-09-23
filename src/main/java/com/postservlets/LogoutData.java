package com.postservlets;

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
 * Servlet implementation class LogoutData
 */
@WebServlet("/LogoutData")
public class LogoutData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
			int empId=Integer.parseInt(request.getParameter("empId"));
			
			System.out.println(empId);
			
			CRUD crud=new CRUD();
			if(crud.logOutDetails(empId)) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("/");
				dispatcher.forward(request, response);
			}
	}

}
