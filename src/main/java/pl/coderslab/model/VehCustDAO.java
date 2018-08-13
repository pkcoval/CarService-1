package pl.coderslab.model;

import pl.coderslab.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehCustDAO extends VehCust {

    public static List<VehCust> loadAll() throws SQLException {

        List<VehCust> vehCusts = new ArrayList<>();
        String query = "SELECT * FROM vehicles AS veh LEFT JOIN customers AS cust on veh.customer_id = cust.id;";
        PreparedStatement sql = DbUtil.getConn().prepareStatement(query);
        ResultSet rs = sql.executeQuery();

        while (rs.next()) {


            VehCust vehCust = new VehCust();

            Vehicles vehicle = new Vehicles();
            vehicle.setId(rs.getInt("veh.id"));
            vehicle.setModel(rs.getString("veh.model"));
            vehicle.setBrand(rs.getString("veh.brand"));
            vehicle.setProductionYear(rs.getInt("veh.productionyear"));
            vehicle.setRegNumber(rs.getString("veh.regnumber"));
            vehicle.setNextServiceDate(rs.getDate("veh.nextservicedate"));
            vehCust.setVehicles(vehicle);

            Customers customer = new Customers();
            customer.setName(rs.getString("cust.name"));
            customer.setSurname(rs.getString("cust.surname"));
            vehCust.setCustomers(customer);
            vehCusts.add(vehCust);

        }
        return vehCusts;
    }


}
