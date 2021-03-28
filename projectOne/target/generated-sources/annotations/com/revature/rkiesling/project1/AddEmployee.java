package com.revature.rkiesling.project1;

import com.revature.rkiesling.project1.User;
import com.revature.rkiesling.project1.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet implements Role {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    //	    response.setContentType ("text/html");
	    //PrintWriter out = response.getWriter ();
	    doPost (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType ("text/html");
	    PrintWriter out = response.getWriter ();
	    out.println (request.getParameter ("firstname") + "<br>");
	    out.println (request.getParameter ("lastname") + "<br>");
	    out.println (request.getParameter ("ssn") + "<br>");
	    out.println (request.getParameter ("userid") + "<br>");
	    out.println (request.getParameter ("password") + "<br>");
	    out.println (request.getParameter ("role") + "<br>");
	    String rolStr = request.getParameter ("role");
	    Integer role = 0;
	    if (rolStr == "employee") {
		role = Role.ROLE_EMPLOYEE;
	    } else if (rolStr == "manager") {
		role = Role.ROLE_MANAGER;
	    } else if (rolStr == "admin") {
		role = Role.ROLE_ADMIN;
	    }
	    User user = new User (request.getParameter ("firstname"),
				  request.getParameter ("lastname"),
				  request.getParameter ("userid"),
				  request.getParameter ("password"),
				  request.getParameter ("ssn"),
				  role);
	    UserDAO.addUser (user);
	}

}
