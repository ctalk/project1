package com.revature.rkiesling.project1;

import com.revature.rkiesling.project1.Invoice;
import com.revature.rkiesling.project1.InvoiceDAO;
import com.revature.rkiesling.project1.User;
import com.revature.rkiesling.project1.util.InvoiceTable;
import com.revature.rkiesling.project1.util.WebPage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagementImpl
 */
public class ManagementImpl extends HttpServlet implements InvoiceTable, WebPage {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagementImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost (request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        User u = new User();
        Invoice i = new Invoice();
	InvoiceDAO dao = new InvoiceDAO ();
        out.append (WebPage.reviewHeading ());
	out.append (dao.reviewInvoices ("awilson", 0));
    }

}
