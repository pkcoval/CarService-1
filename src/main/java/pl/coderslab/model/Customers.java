package pl.coderslab.model;

import java.util.Date;

public class Customers {

    private int id;
    private String name;
    private String surname;
    private Date birtday;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirtday(Date birtday) {
        this.birtday = birtday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirtday() {
        return birtday;
    }

    public int getId() {
        return id;
    }

    public Customers(String name, String surname, Date birtday) {
        this.name = name;
        this.surname = surname;
        this.birtday = birtday;
    }
}
