package pl.coderslab.model;

import pl.coderslab.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO extends Employees {

    private static List<Employees> loadAll() throws SQLException {
        List<Employees> employees = new ArrayList<>();
        String query = "SELECT * FROM employees;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
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

    private static Employees loadPassByEmail(String email) throws SQLException {

        String sql = "SELECT * FROM employees where email=?;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(sql);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Employees employees = new Employees();
            employees.setName(rs.getString("name"));
            employees.setSurname(rs.getString("surname"));
            employees.setHashPassword(rs.getString("password"));
            employees.setPerrmision(rs.getInt("perrmision"));
            return employees;
        }
        return null;
    }

    private static Employees loadById(int id) throws SQLException {

        String query = "SELECT * FROM employees where id=?;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Employees loadedEmployee = new Employees();
        while (resultSet.next()) {
            loadedEmployee.setId(id);
            loadedEmployee.setName(resultSet.getString("name"));
            loadedEmployee.setSurname(resultSet.getString("surname"));
            loadedEmployee.setEmail(resultSet.getString("email"));
            loadedEmployee.setPerrmision(resultSet.getInt("perrmision"));
            loadedEmployee.setAddress(resultSet.getString("address"));
            loadedEmployee.setNotice(resultSet.getString("notice"));
            loadedEmployee.setSalaryforhour(resultSet.getInt("salary_for_hour"));
        }
        return loadedEmployee;
    }

    private void insert() throws SQLException {
        String query = "INSERT INTO employees(name, surname, email, perrmision, address, notice, salary_for_hour) VALUES (?,?,?,?,?,?,?);";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query, new String[]{"id"});
        statement.setString(1, getName());
        statement.setString(2, getSurname());
        statement.setString(3, getEmail());
        statement.setInt(4, getPerrmision());
        statement.setString(5, getAddress());
        statement.setString(6, getNotice());
        statement.setInt(7, getSalaryforhour());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            setId(rs.getInt(1));
        }

    }

    private void update() throws SQLException {
        String query = "UPDATE employees SET name=?, surname=?, email=?, perrmision=?, address=?, notice=?, salary_for_hour=? WHERE id=?;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
        statement.setString(1, getName());
        statement.setString(1, getSurname());
        statement.setString(1, getEmail());
        statement.setInt(1, getPerrmision());
        statement.setString(1, getAddress());
        statement.setString(1, getNotice());
        statement.setInt(1, getSalaryforhour());
        statement.executeUpdate();
    }

    public void saveToDb() throws SQLException {
        if (getId() == 0) {
            insert();
        } else {
            update();
        }

    }


}



