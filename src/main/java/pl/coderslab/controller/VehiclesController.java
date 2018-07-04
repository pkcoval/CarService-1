package pl.coderslab.controller;

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

@WebServlet(name = "VehiclesController", urlPatterns = "/vehicles")
public class VehiclesController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String del = request.getParameter("del");
        String edit = request.getParameter("edit");
        String save = request.getParameter("save");
        String add = request.getParameter("add");

        if (del != null && !del.isEmpty()) {
            try {
                VehiclesDAO.deleteByID(Integer.parseInt(del));
                request.getRequestDispatcher("/vehicles.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (edit != null && !edit.isEmpty()) {
            try {
                Vehicles vehicle = VehiclesDAO.loadById(Integer.parseInt(edit));
                request.setAttribute("vehicle", vehicle);
                request.getRequestDispatcher("/vehicles.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (save != null && !save.isEmpty()) {

            Vehicles vehicle = new VehiclesDAO();
            if (Integer.parseInt(request.getParameter("save")) == 0) {
                vehicle.setId(0);
            } else {
                vehicle.setId(Integer.parseInt(request.getParameter("save")));
            }
            vehicle.setModel(request.getParameter("model"));
            vehicle.setBrand(request.getParameter("brand"));
            vehicle.setProductionYear(Integer.parseInt(request.getParameter("productionYear")));
            vehicle.setRegNumber(request.getParameter("regNumber"));
            vehicle.setNextServiceDate(Date.valueOf(request.getParameter("nextServiceDate")));
            vehicle.setCustomer_id(Integer.parseInt(request.getParameter("customer_id")));
            try {
                ((VehiclesDAO) vehicle).saveToDB();
                response.sendRedirect("/vehicles");
            } catch (SQLException e) {
                response.getWriter().append("Nie udało się zapisać");
                request.getRequestDispatcher("/vehicles.jsp");
            }
        }

        if (add != null && !add.isEmpty()) {
            request.setAttribute("addinfo", add);
            request.getRequestDispatcher("/vehicles.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Vehicles> vehicles = VehiclesDAO.loadAll();
            request.setAttribute("vehicles", vehicles);
            request.getRequestDispatcher("/vehicles.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
