package pl.coderslab.model;

import pl.coderslab.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {

//    List<Employees> findById();
//    List<Employees> findByName();
//    boolean insertEmployee(Employees employee);
//    boolean updateEmployee(Employees employee);
//    boolean deleteEmployee(Employees employee);
public static List<Employees> loadAll() throws SQLException {

    List<Employees> employees = new ArrayList<>();
    String sql = "SELECT * FROM employees;";
    PreparedStatement statement = DbUtil.getConn().prepareStatement(sql);
    ResultSet rs = statement.executeQuery();

    while (rs.next()) {
        Employees loadedEmployee = new Employees();
        loadedEmployee.setId(rs.getInt("id"));
        loadedEmployee.setName(rs.getString("name"));
        loadedEmployee.setSurname(rs.getString("surname"));
        loadedEmployee.setEmail(rs.getString("email"));
        loadedEmployee.setPerrmision(rs.getInt("perrmision"));
        loadedEmployee.setAddress(rs.getString("address"));
        loadedEmployee.setNotice(rs.getString("notice"));
        loadedEmployee.setSalaryforhour(rs.getInt("salary_for_hour"));
        employees.add(loadedEmployee);
    }
    return employees;
}
    public static List<String> loadPassByEmail(String email) throws SQLException {

        List<String> loginInfo = new ArrayList<>();
        String sql = "SELECT * FROM employees where email=?;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(sql);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            loginInfo.add(rs.getString("password"));
            loginInfo.add(rs.getString("name"));
            loginInfo.add(rs.getString("surname"));
            loginInfo.add(rs.getString("perrmision"));
        }
        return loginInfo;
    }

}



