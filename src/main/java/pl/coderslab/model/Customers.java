package pl.coderslab.model;


import java.sql.Date;

public class Customers {

    private int id;
    private String name;
    private String surname;
    private Date birthday;

    public Customers() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public Customers(String name, String surname, Date birtday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birtday;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}