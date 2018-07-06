package pl.coderslab.controller;

import pl.coderslab.model.Customers;
import pl.coderslab.model.CustomersDAO;
import pl.coderslab.model.VehiclesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddCustomerToVehicle", urlPatterns = "/addCustomerToVehicle")
public class AddCustomerToVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
        int customerId = 0;

        if (customerId != 0) {

            VehiclesDAO vehicle = new VehiclesDAO();
            customerId = Integer.parseInt(request.getParameter("customerId"));
            vehicle.setId(vehicleId);
            try {
                vehicle.assignCustomer(customerId);
                response.sendRedirect("/vehicles");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Problem addCustomerToVehicle");
            }
        } else {
            try {
                List<Customers> customers = CustomersDAO.loadAll();
                request.setAttribute("customers", customers);
                request.setAttribute("vehicleId", vehicleId);
                request.getRequestDispatcher("/addCustToVeh.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
