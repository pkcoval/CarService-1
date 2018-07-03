package pl.coderslab.model;

import pl.coderslab.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAO extends Customers {

    public static Customers loadById(int id) throws SQLException {

        PreparedStatement sql = DbUtil.getConn().prepareStatement("SELECT * FROM customers WHERE id = ?");
        sql.setInt(1, id);
        ResultSet rs = sql.executeQuery();
        if (rs.next()) {
            Customers customer = new Customers();
            customer.setId(id);
            customer.setName(rs.getString("name"));
            customer.setSurname(rs.getString("surname"));
            customer.setBirthday(rs.getDate("birth_day"));
            return customer;
        } else {
            return null;
        }
    }

    public static List<Customers> loadAll() throws SQLException {

        List<Customers> customers = new ArrayList<>();
        String query = "SELECT * FROM customers;";
        PreparedStatement sql = DbUtil.getConn().prepareStatement(query);
        ResultSet rs = sql.executeQuery();

        while (rs.next()) {
            Customers customer = new Customers();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setSurname(rs.getString("surname"));
            customer.setBirthday(rs.getDate("birth_day"));
            customers.add(customer);
        }
        return customers;
    }

    public void saveToDB() throws SQLException {
        if (getId() == 0) {
            insert();
        } else {
            update();
        }
    }

    private void update() throws SQLException {
        String query = "UPDATE customers SET name=?, surname=?, birth_day=? WHERE id=?";
        PreparedStatement sql = DbUtil.getConn().prepareStatement(query, new String[]{"id"});
        sql.setString(1, getName());
        sql.setString(2, getSurname());
        sql.setDate(3, getBirthday());
        sql.setInt(4, getId());
        sql.executeUpdate();
    }

    private void insert() throws SQLException {
        String query = "INSERT INTO customers (name, surname, birth_day) VALUES (?,?,?);";
        PreparedStatement sql = DbUtil.getConn().prepareStatement(query, new String[]{"id"});
        sql.setString(1, getName());
        sql.setString(2, getSurname());
        sql.setDate(3, getBirthday());
        sql.executeUpdate();
        ResultSet rs = sql.getGeneratedKeys();
        if (rs.next()) {
            setId(rs.getInt(1));
        }
    }

    public static void deleteByID(int id) throws SQLException {

        String query = "DELETE FROM customers WHERE id=?;";
        PreparedStatement sql = DbUtil.getConn().prepareStatement(query);
        sql.setInt(1, id);
        sql.executeUpdate();
    }
}