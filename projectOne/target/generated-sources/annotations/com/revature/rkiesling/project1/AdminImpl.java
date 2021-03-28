package com.revature.rkiesling.project1;

import com.revature.rkiesling.project1.util.WebPage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminImpl
 */
public class AdminImpl extends HttpServlet implements WebPage {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String makeWebPage (String title) {
        String s = WebPage.pageHeading (title);
        s += "<h2>Administration</h2>";
        s += WebPage.pageFooting ();
        return s;
    }
    private String makeWebPage (String title, String firstName, String lastName) {
        String s = WebPage.pageHeading (title);
        // For a more readable, similar version, see index.jsp
        s += "<h2>Administration</h2>";
        s += "<h5>Welcome, <b>" + firstName + " " + lastName + "</b></h5>";
        s += WebPage.addUserForm;
        s += WebPage.pageFooting ();
        return s;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        out.append(makeWebPage ("Expense System Adinistration"));
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        out.append(makeWebPage ("Expense System Adinistration",
                                (String)request.getAttribute ("firstName"),
                                (String)request.getAttribute ("lastName")));
    }
}
