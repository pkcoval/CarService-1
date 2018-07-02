package pl.coderslab.model;

public class Status {
    private int id;
    private String typ;

    public Status(String typ) {
        this.typ = typ;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getId() {
        return id;
    }
}
