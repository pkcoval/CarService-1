package pl.coderslab.model;

import pl.coderslab.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiclesDAO extends Vehicles {

    public static Vehicles loadById(int id) throws SQLException {

        PreparedStatement sql = DbUtil.getConn().prepareStatement("SELECT * FROM vehicles WHERE id = ?");
        sql.setInt(1, id);
        ResultSet rs = sql.executeQuery();
        if (rs.next()) {
            Vehicles vehicle = new Vehicles();
            vehicle.setId(id);
            vehicle.setModel(rs.getString("model"));
            vehicle.setBrand(rs.getString("brand"));
            vehicle.setProductionYear(rs.getInt("productionyear"));
            vehicle.setRegNumber(rs.getString("regnumber"));
            vehicle.setNextServiceDate(rs.getDate("nextservicedate"));
            vehicle.setCustomer_id(rs.getInt("customer_id"));
            return vehicle;
        } else {
            return null;
        }
    }

    public static List<Vehicles> loadAll() throws SQLException {

        List<Vehicles> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles;";
        PreparedStatement sql = DbUtil.getConn().prepareStatement(query);
        ResultSet rs = sql.executeQuery();

        while (rs.next()) {
            Vehicles vehicle = new Vehicles();
            vehicle.setId(rs.getInt("id"));
            vehicle.setModel(rs.getString("model"));
            vehicle.setBrand(rs.getString("brand"));
            vehicle.setProductionYear(rs.getInt("productionyear"));
            vehicle.setRegNumber(rs.getString("regnumber"));
            vehicle.setNextServiceDate(rs.getDate("nextservicedate"));
            vehicle.setCustomer_id(rs.getInt("customer_id"));
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    public void saveToDB() throws SQLException {
        if (getId() == 0) {
            insert();
        } else {
            update();
        }
    }

    private void update() throws SQLException {
        String query = "UPDATE vehicles SET " +
                "model=?, brand=?, productionyear=?, regnumber=?, nextservicedate=?, customer_id=? " +
                "WHERE id=?";
        PreparedStatement sql = DbUtil.getConn().prepareStatement(query, new String[]{"id"});
        sql.setString(1, getModel());
        sql.setString(2, getBrand());
        sql.setInt(3, getProductionYear());
        sql.setString(4, getRegNumber());
        sql.setDate(5, getNextServiceDate());
        sql.setInt(6, getCustomer_id());
        sql.setInt(7, getId());
        sql.executeUpdate();
    }

    private void insert() throws SQLException {
        String query = "INSERT INTO vehicles (model, brand, productionyear, regnumber, nextservicedate, customer_id) VALUES (?,?,?,?,?,?);";
        PreparedStatement sql = DbUtil.getConn().prepareStatement(query, new String[]{"id"});
        sql.setString(1, getModel());
        sql.setString(2, getBrand());
        sql.setInt(3, getProductionYear());
        sql.setString(4, getRegNumber());
        sql.setDate(5, getNextServiceDate());
        sql.setInt(6, getCustomer_id());
        sql.executeUpdate();
        ResultSet rs = sql.getGeneratedKeys();
        if (rs.next()) {
            setId(rs.getInt(1));
        }
    }

    public static void deleteByID(int id) throws SQLException {

        String query = "DELETE FROM vehicles WHERE id=?;";
        PreparedStatement sql = DbUtil.getConn().prepareStatement(query);
        sql.setInt(1, id);
        sql.executeUpdate();
    }
}
