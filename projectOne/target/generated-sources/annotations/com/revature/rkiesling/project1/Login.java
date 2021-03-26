package com.revature.rkiesling.project1;

import com.revature.rkiesling.project1.util.JDBCConnection;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		try {
			JDBCConnection.registerPostGresqlDriver ();
		} catch (SQLException e) {
			System.out.println (e.getMessage ());
			throw new ServletException (e.getMessage());
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = JDBCConnection.getJDBCConnection ();
		response.setContentType ("text/html");
		PrintWriter out = response.getWriter ();
		JDBCConnection.closeAll(con);
		
		
	}

}
