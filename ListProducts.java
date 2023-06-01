package com.ecommerce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet("/list")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListProducts() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		List<EProduct> list = session.createQuery("from EProduct").list();

		// using HQL

		session.close();

		PrintWriter out = response.getWriter(); 
		out.println("<b>Product Listing</b><br>");
		out.println("<html><body>");
		for(EProduct p: list) { 
			out.println("ID: "+String.valueOf(p.getID())+", Name: " +p.getName()
			+",Price: " + String.valueOf(p.getPrice())+", Date Added:" +

				p.getDateAdded().toString() + "<br>");
		}

		out.println("</body></html>");

		} catch (Exception ex) {

		throw ex;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
