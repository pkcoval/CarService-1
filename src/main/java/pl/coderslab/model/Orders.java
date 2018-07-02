package pl.coderslab.model;

import java.util.Date;

public class Orders {

    private int id;
    private Date takecar;
    private Date planstartrepair;
    private Date startrepair;
    private String descriptionfault;
    private String nextservicedate;
    private String descripionrepair;
    private int employee_id ;
    private int vehicles_id ;
    private int status_id ;
    private double costforcustomer ;
    private double costparts ;
    private double salaryforhour ;
    private int amountofhour ;

    public int getId() { return id; }

    public Date getTakecar() { return takecar; }

    public void setTakecar(Date takecar) { this.takecar = takecar; }

    public Date getPlanstartrepair() { return planstartrepair; }

    public void setPlanstartrepair(Date planstartrepair) { this.planstartrepair = planstartrepair; }

    public Date getStartrepair() { return startrepair; }

    public void setStartrepair(Date startrepair) { this.startrepair = startrepair; }

    public String getDescriptionfault() { return descriptionfault; }

    public void setDescriptionfault(String descriptionfault) { this.descriptionfault = descriptionfault; }

    public String getNextservicedate() { return nextservicedate; }

    public void setNextservicedate(String nextservicedate) { this.nextservicedate = nextservicedate; }

    public String getDescripionrepair() { return descripionrepair; }

    public void setDescripionrepair(String descripionrepair) { this.descripionrepair = descripionrepair; }

    public int getEmployee_id() { return employee_id; }

    public void setEmployee_id(int employee_id) { this.employee_id = employee_id; }

    public int getVehicles_id() { return vehicles_id; }

    public void setVehicles_id(int vehicles_id) { this.vehicles_id = vehicles_id; }

    public int getStatus_id() { return status_id; }

    public void setStatus_id(int status_id) { this.status_id = status_id; }

    public double getCostforcustomer() { return costforcustomer; }

    public void setCostforcustomer(double costforcustomer) { this.costforcustomer = costforcustomer; }

    public double getCostparts() { return costparts; }

    public void setCostparts(double costparts) { this.costparts = costparts; }

    public double getSalaryforhour() { return salaryforhour; }

    public void setSalaryforhour(double salaryforhour) { this.salaryforhour = salaryforhour; }

    public int getAmountofhour() { return amountofhour; }

    public void setAmountofhour(int amountofhour) { this.amountofhour = amountofhour; }

    public Orders(Date takecar, Date planstartrepair, Date startrepair, String descriptionfault, String nextservicedate, String descripionrepair, int employee_id, int vehicles_id, int status_id, double costforcustomer, double costparts, double salaryforhour, int amountofhour) {
        this.takecar = takecar;
        this.planstartrepair = planstartrepair;
        this.startrepair = startrepair;
        this.descriptionfault = descriptionfault;
        this.nextservicedate = nextservicedate;
        this.descripionrepair = descripionrepair;
        this.employee_id = employee_id;
        this.vehicles_id = vehicles_id;
        this.status_id = 1;
        this.costforcustomer = costforcustomer;
        this.costparts = costparts;
        this.salaryforhour = salaryforhour;
        this.amountofhour = amountofhour;
    }
}
