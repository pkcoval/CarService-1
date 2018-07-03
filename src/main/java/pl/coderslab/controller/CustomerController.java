package pl.coderslab.controller;

import pl.coderslab.model.Customers;
import pl.coderslab.model.CustomersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String del = request.getParameter("del");
        if (del !=null && !del.isEmpty()) {
            try {
                CustomersDAO.deleteByID(Integer.parseInt(del));
                request.getRequestDispatcher("/customers.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Customers> customers = CustomersDAO.loadAll();
            System.out.println(customers.toString());
            request.setAttribute("customers", customers);
            request.getRequestDispatcher("/customers.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
