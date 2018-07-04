package pl.coderslab.model;

import pl.coderslab.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends Orders {

    public static List<Orders> loadAll() throws SQLException {

        List<Orders> orders = new ArrayList<>();
        String query = "SELECT * FROM orders;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Orders order = new Orders();
            order.setId(resultSet.getInt("id"));
            order.setTakeCar(resultSet.getDate("takecar"));
            order.setPlanStartRepair(resultSet.getDate("planstartrepair"));
            order.setStartRepair(resultSet.getDate("startrepair"));
            order.setDescriptionFault(resultSet.getString("descriptionfault"));
            order.setNextServiceDate(resultSet.getString("nextservicedate"));
            order.setDescriptionRepair(resultSet.getString("descriptionrepair"));
            order.setEmployee_id(resultSet.getInt("employee_id"));
            order.setVehicles_id(resultSet.getInt("vehicles_id"));
            order.setStatus_id(resultSet.getInt("status_id"));
            order.setCostForCustomer(resultSet.getDouble("costforcustomer"));
            order.setCostParts(resultSet.getDouble("costparts"));
            order.setSalaryForHour(resultSet.getDouble("salaryforhour"));
            order.setAmountOfHour(resultSet.getInt("amountofhour"));
            orders.add(order);
        }
        return orders;
    }

    public static Orders loadById(int id) throws SQLException {

        String query = "SELECT * FROM orders where id=?;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Orders order = new Orders();
            order.setId(resultSet.getInt("id"));
            order.setTakeCar(resultSet.getDate("takecar"));
            order.setPlanStartRepair(resultSet.getDate("planstartrepair"));
            order.setStartRepair(resultSet.getDate("startrepair"));
            order.setDescriptionFault(resultSet.getString("descriptionfault"));
            order.setNextServiceDate(resultSet.getString("nextservicedate"));
            order.setDescriptionRepair(resultSet.getString("descriptionrepair"));
            order.setEmployee_id(resultSet.getInt("employee_id"));
            order.setVehicles_id(resultSet.getInt("vehicles_id"));
            order.setStatus_id(resultSet.getInt("status_id"));
            order.setCostForCustomer(resultSet.getDouble("costforcustomer"));
            order.setCostParts(resultSet.getDouble("costparts"));
            order.setSalaryForHour(resultSet.getDouble("salaryforhour"));
            order.setAmountOfHour(resultSet.getInt("amountofhour"));
            return order;
        }
        return null;
    }

    private void update() throws SQLException {

        String query = "UPDATE orders SET takecar=?, planstartrepair=?, startrepair=?, " +
                "descriptionfault=?, employee_id=?, " +
                "vehicles_id=?, status_id=?, costforcustomer=?, costparts=?, salaryforhour=?, amountofhour=? WHERE id=?;";

        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
        statement.setDate(1, getTakeCar());
        statement.setDate(2, getPlanStartRepair());
        statement.setDate(3, getStartRepair());
        statement.setString(4, getDescriptionFault());
        statement.setInt(5, getEmployee_id());
        statement.setInt(6, getVehicles_id());
        statement.setInt(7, getStatus_id());
        statement.setDouble(8, getCostForCustomer());
        statement.setDouble(9, getCostParts());
        statement.setDouble(10, getSalaryForHour());
        statement.setInt(11, getAmountOfHour());
        statement.setInt(12, getId());
        statement.executeUpdate();
    }

    private void insert() throws SQLException {
        String query = "INSERT INTO orders (takecar, planstartrepair, startrepair, descriptionfault, employee_id, vehicles_id, status_id, costforcustomer, costparts, salaryforhour, amountofhour)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query, new String[]{"id"});
        statement.setDate(1, getTakeCar());
        statement.setDate(2, getPlanStartRepair());
        statement.setDate(3, getStartRepair());
        statement.setString(4, getDescriptionFault());
        statement.setInt(5, getEmployee_id());
        statement.setInt(6, getVehicles_id());
        statement.setInt(7, getStatus_id());
        statement.setDouble(8, getCostForCustomer());
        statement.setDouble(9, getCostParts());
        statement.setDouble(10, getSalaryForHour());
        statement.setInt(11, getAmountOfHour());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            setId(rs.getInt(1));
        }
    }

    public void saveToDb() throws SQLException {
        if (getId() == 0) {
            insert();
        } else {
            update();
        }
    }

    public static void deleteById(int id) throws SQLException {
        String query = "DELETE FROM orders where id=?;";
        PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}