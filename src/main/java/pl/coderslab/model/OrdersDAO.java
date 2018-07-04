package pl.coderslab.model;

import pl.coderslab.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends Orders {

    
public static List<Orders> loadAll() throws SQLException {

    List<Orders> newOrders = new ArrayList<>();

    String query = "SELECT * FROM orders;";

    PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
        Orders order = new Orders();
        order.setId(resultSet.getInt("id"));
        order.setTakecar(resultSet.getDate("takecar"));
        order.setPlanstartrepair(resultSet.getDate("planstartrepair"));
        order.setStartrepair(resultSet.getDate("startrepair"));
        order.setDescriptionfault(resultSet.getString("descriptionfault"));
        order.setNextservicedate(resultSet.getString("nextservicedate"));
        order.setDescripionrepair(resultSet.getString("descriptionrepair"));
        order.setEmployee_id(resultSet.getInt("employee_id"));
        order.setVehicles_id(resultSet.getInt("vehicles_id"));
        order.setStatus_id(resultSet.getInt("status_id"));
        order.setCostforcustomer(resultSet.getDouble("costforcustomer"));
        order.setCostparts(resultSet.getDouble("costparts"));
        order.setSalaryforhour(resultSet.getDouble("salaryforhour"));
        order.setAmountofhour(resultSet.getInt("amountofhour"));
        newOrders.add(order);
    }
    return newOrders;
}
public static Orders loadById (int id) throws SQLException {
    String query = "SELECT * FROM orders where id=?;";
    PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
    Orders order = new Orders();
    statement.setInt(1,id);
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
        order.setId(id);
        order.setTakecar(resultSet.getDate("takecar"));
        order.setPlanstartrepair(resultSet.getDate("planstartrepair"));
        order.setStartrepair(resultSet.getDate("startrepair"));
        order.setDescriptionfault(resultSet.getString("descriptionfault"));
        order.setNextservicedate(resultSet.getString("nextservicedate"));
        order.setDescripionrepair(resultSet.getString("descriptionrepair"));
        order.setEmployee_id(resultSet.getInt("employee_id"));
        order.setVehicles_id(resultSet.getInt("vehicles_id"));
        order.setStatus_id(resultSet.getInt("status_id"));
        order.setCostforcustomer(resultSet.getDouble("costforcustomer"));
        order.setCostparts(resultSet.getDouble("costparts"));
        order.setSalaryforhour(resultSet.getDouble("salaryforhour"));
        order.setAmountofhour(resultSet.getInt("amountofhour"));
    }
    return order;
}
private void update() throws SQLException {
    String query = "UPDATE orders SET takecar=?, planstartrepair=?, startrepair=?, " +
            "descriptionfault=?, employee_id=?, " +
            "vehicles_id=?, status_id=?, costforcustomer=?, costparts=?, salaryforhour=?, amountofhour=? WHERE id=?;";

    PreparedStatement statement = DbUtil.getConn().prepareStatement(query);
    statement.setDate(1,getTakecar());
    statement.setDate(2,getPlanstartrepair());
    statement.setDate(3,getStartrepair());
    statement.setString(4,getDescriptionfault());
    statement.setInt(5,getEmployee_id());
    statement.setInt(6,getVehicles_id());
    statement.setInt(7,getStatus_id());
    statement.setDouble(8,getCostforcustomer());
    statement.setDouble(9,getCostparts());
    statement.setDouble(10,getSalaryforhour());
    statement.setInt(11,getAmountofhour());
    statement.setInt(12,getId());
    statement.executeUpdate();
}
private void insert() throws SQLException {
    String query = "INSERT INTO orders (takecar, planstartrepair, startrepair, descriptionfault, employee_id, vehicles_id, status_id, costforcustomer, costparts, salaryforhour, amountofhour)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    PreparedStatement statement = DbUtil.getConn().prepareStatement(query , new String[]{"id"});
    statement.setDate(1,getTakecar());
    statement.setDate(2,getPlanstartrepair());
    statement.setDate(3,getStartrepair());
    statement.setString(4,getDescriptionfault());
    statement.setInt(5,getEmployee_id());
    statement.setInt(6,getVehicles_id());
    statement.setInt(7,getStatus_id());
    statement.setDouble(8,getCostforcustomer());
    statement.setDouble(9,getCostparts());
    statement.setDouble(10,getSalaryforhour());
    statement.setInt(11,getAmountofhour());
    statement.executeUpdate();
    ResultSet rs = statement.getGeneratedKeys();
    if (rs.next()) {
        setId(rs.getInt(1));
    }
}
public void saveToDb() throws SQLException {
    if (getId()==0)  {
        insert();
    } else {
        update();
    }
}
public static void deleteById (int id) throws SQLException {
    String query = "DELETE FROM orders where id=?;";
    PreparedStatement statement= DbUtil.getConn().prepareStatement(query);
    statement.setInt(1,id);
    statement.executeUpdate();
}


}
