package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Employees {

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    private String surname;
    private String email;
    private String password;
    private int perrmision;
    private String address;
    private int phone;
    private String notice;
    private int salaryforhour;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());

    }

    public int getPerrmision() {
        return perrmision;
    }

    public void setPerrmision(int perrmision) {
        this.perrmision = perrmision;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public int getSalaryforhour() {
        return salaryforhour;
    }

    public void setSalaryforhour(int salaryforhour) {
        this.salaryforhour = salaryforhour;
    }

    public Employees(int id, String name, String surname, String email, String password, int perrmision, String address, int phone, String notice, int salaryforhour) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        setPassword(password);
        this.perrmision = perrmision;
        this.address = address;
        this.phone = phone;
        this.notice = notice;
        this.salaryforhour = salaryforhour;
    }

    public Employees() {
    }


}