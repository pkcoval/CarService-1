package pl.coderslab.model;

import java.util.List;

public class VehCust {

    private Vehicles vehicles;
    private Customers customers;
    private List<Vehicles> vehiclesList;
    private List<Customers> customersList;

    public VehCust() {
    }

    public List<Vehicles> getVehiclesList() {
        return vehiclesList;
    }

    public void setVehiclesList(List<Vehicles> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }

    public List<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customers> customersList) {
        this.customersList = customersList;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "VehCust{" +
                "vehicles=" + vehicles +
                ", customers=" + customers +
                '}';
    }
}
