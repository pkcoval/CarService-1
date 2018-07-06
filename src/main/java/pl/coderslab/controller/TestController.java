package pl.coderslab.controller;

import pl.coderslab.model.VehCust;
import pl.coderslab.model.VehCustDAO;
import pl.coderslab.model.Vehicles;
import pl.coderslab.model.VehiclesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TestController", urlPatterns = "/test")
public class TestController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<VehCust> vehCusts = VehCustDAO.loadAll();
            request.setAttribute("vehCusts", vehCusts);
            request.getRequestDispatcher("/veh.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
