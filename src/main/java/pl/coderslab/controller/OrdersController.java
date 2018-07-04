package pl.coderslab.controller;

import pl.coderslab.model.Orders;
import pl.coderslab.model.OrdersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "OrdersController", urlPatterns = "/orders")
public class OrdersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String del = request.getParameter("del");
        String edit = request.getParameter("edit");
        String save = request.getParameter("save");
        String add = request.getParameter("add");

//        if (del != null && !del.isEmpty()) {
//            try {
//                OrdersDAO.deleteByID(Integer.parseInt(del));
//                request.getRequestDispatcher("/orders.jsp").forward(request, response);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (edit != null && !edit.isEmpty()) {
//            try {
//                Orders order = OrdersDAO.loadById(Integer.parseInt(edit));
//                request.setAttribute("order", order);
//                request.getRequestDispatcher("/orders.jsp").forward(request, response);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (save != null && !save.isEmpty()) {
//
//            Orders order = new OrdersDAO();
//            if (Integer.parseInt(request.getParameter("save")) == 0) {
//                order.setId(0);
//            } else {
//                order.setId(Integer.parseInt(request.getParameter("save")));
//            }
//            order.setTakeCar(Date.valueOf(request.getParameter("takeCar")));
//            order.setPlanStartRepair(Date.valueOf(request.getParameter("planStartRepair")));
//            order.setStartRepair(Date.valueOf(request.getParameter("startRepair")));
//            order.setDescriptionFault(request.getParameter("descriptionFault"));
//            order.setDescriptionRepair(request.getParameter("descriptionRepair"));
//            order.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
//            order.setVehicles_id(Integer.parseInt(request.getParameter("vehicle_id")));
//            order.setStatus_id(Integer.parseInt(request.getParameter("status_id")));
//            order.setCostForCustomer(Double.parseDouble(request.getParameter("costForCustomer")));
//            order.setCostParts(Double.parseDouble(request.getParameter("costParts")));
//            order.setSalaryForHour(Double.parseDouble(request.getParameter("salaryForHour")));
//            order.setAmountOfHour(Integer.parseInt(request.getParameter("amountOfHour")));
//            try {
//                ((OrdersDAO) order).saveToDB();
//                response.sendRedirect("/orders");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (add != null && !add.isEmpty()) {
//
//            request.setAttribute("addinfo", add);
//            request.getRequestDispatcher("/orders.jsp").forward(request, response);
//        }
//
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        try {
//            List<Orders> orders = OrdersDAO.loadAll();
//            request.setAttribute("orders", orders);
//            request.getRequestDispatcher("/orders").forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}
