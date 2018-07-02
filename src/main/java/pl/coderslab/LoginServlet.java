package pl.coderslab;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.model.EmployeesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String passFromUser = request.getParameter("pass");
        try {
            List<String> loginInfo = EmployeesDAO.loadPassByEmail(email);
            String salt = loginInfo.get(0).substring(0, 29);
            String hashpw = BCrypt.hashpw(passFromUser, salt);
            if (hashpw.equals(loginInfo.get(0))) {
                System.out.println("Użytkownik zalogowany!");
                HttpSession session = request.getSession();
                session.setAttribute("login", true);
                session.setAttribute("name", loginInfo.get(1));
                session.setAttribute("surname", loginInfo.get(2));
                session.setAttribute("permission" , loginInfo.get(3));

                response.sendRedirect("/employees");

            } else {
                System.out.println("Hasło nieprawidłowe.");
                request.getRequestDispatcher("/loginfailed.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
/////////////cd