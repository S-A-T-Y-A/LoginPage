package com.postservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.CRUD;
import com.empdetails.Employee;

/**
 * Servlet implementation class NewRegister
 */
@WebServlet("/NewRegister")
public class NewRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int empId=Integer.parseInt(request.getParameter("empId"));
		String userName=request.getParameter("userName");
		
		Employee emp=new Employee(empId,userName);
		
		CRUD crud=new CRUD();
		if(crud.newRegister(emp)) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		};
	}

}
