package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ecommerce.*;
import java.math.*;
import java.text.ParseException;

@WebServlet("/query-demo")
public class HibernateQueryDemo extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        // Get the input parameters from the request
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        // Assuming dateAdded is in the format of "yyyy-MM-dd"
        String dateAddedString = request.getParameter("dateAdded");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateAdded;
        try {
            dateAdded = dateFormat.parse(dateAddedString);
        } catch (ParseException e) {
            // Handle the exception if the date format is invalid
            // You can send an error response or take appropriate action
            e.printStackTrace();
            return;
        }

        // STEP 1: Get a Session (connection) from the Session Factory class
        SessionFactory factory = HibernateUtil.getSessionFactory();

        // STEP 2: Create the session object
        Session session = factory.openSession();

        out.println("Hibernate Session opened.<br>");

        EProduct details = new EProduct();
        details.setID(id);
        details.setName(name);
        details.setPrice(price);
        details.setDateAdded(dateAdded);

        // Save the EProduct object to the database
        session.beginTransaction();
        session.save(details);
        session.getTransaction().commit();

        // Query the DB and get the data
        List<EProduct> eproducts = session.createQuery("from EProduct").list();
        out.println("<table border=1>");
        for (EProduct prod : eproducts) {
            out.println("<tr><td>" + prod.getID() + "<td>" + prod.getName() + "<td>" + prod.getPrice() + "<td>"
                    + prod.getDateAdded());
        }
        out.println("</table>");

        session.close();

        out.println("Hibernate Session closed.<br>");

        out.println("</body></html>");
    }
}
