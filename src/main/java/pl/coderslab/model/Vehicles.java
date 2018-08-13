package pl.coderslab.model;


import java.sql.Date;

public class Vehicles {

    private int id;
    private String model;
    private String brand;
    private int productionYear;
    private String regNumber;
    private Date nextServiceDate;
    private int customer_id;

    public Vehicles() {

    }


    public Vehicles(String model, String brand, int productionYear, String regnumber, Date nextservicedate, int customer_id) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.regNumber = regnumber;
        this.nextServiceDate = nextservicedate;
        this.customer_id = customer_id;


    }

    public void setId(int id) { this.id = id; }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Date getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(Date nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_id() {

    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", productionYear=" + productionYear +
                ", regNumber='" + regNumber + '\'' +
                ", nextServiceDate=" + nextServiceDate +
                ", customer_id=" + customer_id +
                '}';
    }
}
