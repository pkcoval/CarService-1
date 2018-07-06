package pl.coderslab.model;

public class VehCust {

    private Vehicles vehicles;
    private Customers customers;

    public VehCust() {
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
