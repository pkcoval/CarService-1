package pl.coderslab.controller;

import pl.coderslab.model.CustomersDAO;
import pl.coderslab.model.Employees;
import pl.coderslab.model.EmployeesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployesController", urlPatterns = "/employees")
public class EmployesController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String del = request.getParameter("del");
        String edit = request.getParameter("edit");
        String save = request.getParameter("save");
        String add = request.getParameter("add");

//        if (del != null && !del.isEmpty()) {
//            try {
//                EmployeesDAO.deleteByID(Integer.parseInt(del));
//                request.getRequestDispatcher("/index.jsp").forward(request, response);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

//        if (edit != null && !edit.isEmpty()) {
//            try {
//                Employees employee = EmployeesDAO.loadById(Integer.parseInt(edit));
//                request.setAttribute("employee", employee);
//                request.getRequestDispatcher("/index.jsp").forward(request, response);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

//        if (save != null && !save.isEmpty()) {
//
//            Employees employee = new EmployeesDAO();
//            if (Integer.parseInt(request.getParameter("save"))== 0) {
//                employee.setId(0);
//            } else {
//                employee.setId(Integer.parseInt(request.getParameter("save")));
//            }
//            employee.setName(request.getParameter("name"));
//            employee.setSurname(request.getParameter("surname"));
//            employee.setEmail(request.getParameter("email"));
//            employee.setPerrmision(Integer.parseInt(request.getParameter("perrmision")));
//            employee.setAddress(request.getParameter("address"));
//            employee.setPhone(Integer.parseInt(request.getParameter("phone")));
//            employee.setNotice(request.getParameter("notice"));
//            employee.setSalaryForHour(Integer.parseInt(request.getParameter("salary")));
//
//            try {
//                ((EmployeesDAO) employee).saveToDB();
//                response.sendRedirect("/employees");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        if (add != null && !add.isEmpty()) {

            request.setAttribute("addinfo", add);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Employees> employees = EmployeesDAO.loadAll();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("/employees").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
