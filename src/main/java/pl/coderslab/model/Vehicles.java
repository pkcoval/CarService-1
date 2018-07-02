package pl.coderslab.model;

import java.util.Date;

public class Vehicles {

    private int id;
    private String model;
    private String brand;
    private int productionyear;
    private int regnumber;
    private Date nextservicedate;
    private int customer_id ;

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

    public int getProductionyear() {
        return productionyear;
    }

    public void setProductionyear(int productionyear) {
        this.productionyear = productionyear;
    }

    public int getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(int regnumber) {
        this.regnumber = regnumber;
    }

    public Date getNextservicedate() {
        return nextservicedate;
    }

    public void setNextservicedate(Date nextservicedate) {
        this.nextservicedate = nextservicedate;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getId() {
        return id;
    }

    public Vehicles(String model, String brand, int productionyear, int regnumber, Date nextservicedate, int customer_id) {
        this.model = model;
        this.brand = brand;
        this.productionyear = productionyear;
        this.regnumber = regnumber;
        this.nextservicedate = nextservicedate;
        this.customer_id = customer_id;


    }
}
