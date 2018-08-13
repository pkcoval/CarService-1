package pl.coderslab.model;

import pl.coderslab.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO extends Employees {


    public static List<Employees> loadAll() throws SQLException {
        List<Employees> employees = new ArrayList<>();
        String query = "SELECT * FROM employees;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Employees employee = new Employees();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setSurname(rs.getString("surname"));
            employee.setEmail(rs.getString("email"));
            employee.setPerrmision(rs.getInt("perrmision"));
            employee.setAddress(rs.getString("address"));
            employee.setNotice(rs.getString("notice"));
            employee.setSalaryForHour(rs.getInt("salary_for_hour"));
            employees.add(employee);
        }
        return employees;
    }

    public static Employees loadPassByEmail(String email) throws SQLException {

        String sql = "SELECT * FROM employees where email=?;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(sql);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Employees employee = new Employees();
            employee.setName(rs.getString("name"));
            employee.setSurname(rs.getString("surname"));
            employee.setHashPassword(rs.getString("password"));
            employee.setPerrmision(rs.getInt("perrmision"));
            return employee;
        }
        return null;
    }

    public static Employees loadById(int id) throws SQLException {

        String query = "SELECT * FROM employees where id=?;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Employees employee = new Employees();
        while (resultSet.next()) {
            employee.setId(id);
            employee.setName(resultSet.getString("name"));
            employee.setSurname(resultSet.getString("surname"));
            employee.setEmail(resultSet.getString("email"));
            employee.setPerrmision(resultSet.getInt("perrmision"));
            employee.setAddress(resultSet.getString("address"));
            employee.setNotice(resultSet.getString("notice"));
            employee.setSalaryForHour(resultSet.getInt("salary_for_hour"));
        }
        return employee;
    }

    public void insert() throws SQLException {
        String query = "INSERT INTO employees(name, surname, email, password, address, notice, salary_for_hour) VALUES (?,?,?,?,?,?,?);";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query, new String[]{"id"});
        statement.setString(1, getName());
        statement.setString(2, getSurname());
        statement.setString(3, getEmail());
        statement.setString(4, getPassword());
        statement.setString(5, getAddress());
        statement.setString(6, getNotice());
        statement.setInt(7, getSalaryForHour());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            setId(rs.getInt(1));
        }
    }

    public void update() throws SQLException {
        String query = "UPDATE employees SET name=?, surname=?, email=?, address=?, notice=?, salary_for_hour=? WHERE id=?;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
        statement.setString(1, getName());
        statement.setString(2, getSurname());
        statement.setString(3, getEmail());
        //statement.setInt(1, getPerrmision());
        statement.setString(4, getAddress());
        statement.setString(5, getNotice());
        statement.setInt(6, getSalaryForHour());
        statement.setInt(7, getId());
        statement.executeUpdate();
    }

    public void saveToDb() throws SQLException {
        if (getId() == 0) {
            insert();
        } else {
            update();
        }

    }
    public static void deleteById (int id) throws SQLException {
        String query = "DELETE FROM employees WHERE id=?;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
        statement.setInt(1,id);
        statement.executeUpdate();
    }
}



