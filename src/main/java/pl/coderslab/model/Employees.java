package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;

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
    private int salaryForHour;


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

    public void setHashPassword(String password) {
        this.password = password;
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

    public int getSalaryForHour() {
        return salaryForHour;
    }

    public void setSalaryForHour(int salaryForHour) {
        this.salaryForHour = salaryForHour;
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
        this.salaryForHour = salaryforhour;
    }

    public Employees() {
    }


}