package pl.coderslab.model;

import java.sql.Date;

public class Orders {

    private int id;
    private Date takeCar;
    private Date planStartRepair;
    private Date startRepair;
    private String descriptionFault;
    private String descriptionRepair;
    private int employee_id;
    private int vehicles_id;
    private int status_id;
    private double costForCustomer;
    private double costParts;
    private double salaryForHour;
    private int amountOfHour;

    public Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTakeCar() {
        return takeCar;
    }

    public void setTakeCar(Date takeCar) {
        this.takeCar = takeCar;
    }

    public Date getPlanStartRepair() {
        return planStartRepair;
    }

    public void setPlanStartRepair(Date planStartRepair) {
        this.planStartRepair = planStartRepair;
    }

    public Date getStartRepair() {
        return startRepair;
    }

    public void setStartRepair(Date startRepair) {
        this.startRepair = startRepair;
    }

    public String getDescriptionFault() {
        return descriptionFault;
    }

    public void setDescriptionFault(String descriptionFault) {
        this.descriptionFault = descriptionFault;
    }

    public String getDescriptionRepair() {
        return descriptionRepair;
    }

    public void setDescriptionRepair(String descriptionRepair) {
        this.descriptionRepair = descriptionRepair;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getVehicles_id() {
        return vehicles_id;
    }

    public void setVehicles_id(int vehicles_id) {
        this.vehicles_id = vehicles_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public double getCostForCustomer() {
        return costForCustomer;
    }

    public void setCostForCustomer(double costForCustomer) {
        this.costForCustomer = costForCustomer;
    }

    public double getCostParts() {
        return costParts;
    }

    public void setCostParts(double costParts) {
        this.costParts = costParts;
    }

    public double getSalaryForHour() {
        return salaryForHour;
    }

    public void setSalaryForHour(double salaryForHour) {
        this.salaryForHour = salaryForHour;
    }

    public int getAmountOfHour() {
        return amountOfHour;
    }

    public void setAmountOfHour(int amountOfHour) {
        this.amountOfHour = amountOfHour;
    }
}
