package pl.coderslab;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.model.Employees;
import pl.coderslab.model.EmployeesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String passwordFromUser = request.getParameter("pass");
        Map<String, String> messages = new HashMap<String, String>();
        if (email == null || email.isEmpty()) {
            messages.put("email", "Please enter email");
        }

        if (passwordFromUser == null || passwordFromUser.isEmpty()) {
            messages.put("password", "Please enter password");
        }

        if (messages.isEmpty()) {
            try {
                Employees employees = EmployeesDAO.loadPassByEmail(email);
                if (employees == null) {
                    messages.put("login", "Unknown login, please try again");
                    request.setAttribute("messages", messages);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }

                String passwordFromDb = employees.getPassword();
                String salt = passwordFromDb.substring(0, 29);
                String hashpw = BCrypt.hashpw(passwordFromUser, salt);

                if (hashpw.equals(passwordFromDb)) {
                    request.getSession().setAttribute("employees", employees);
                    request.getSession().setAttribute("name", employees.getName());
                    request.getSession().setAttribute("surname", employees.getSurname());
                    response.sendRedirect(request.getContextPath() + "/employees");
                    return;
                } else {
                    messages.put("login", "Wrong password, please try again");
                    request.setAttribute("messages", messages);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("messages", messages);
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
