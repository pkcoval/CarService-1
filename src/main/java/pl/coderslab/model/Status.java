package pl.coderslab.model;

public class Status {
    private int id;
    private String typ;

    public Status(int id, String typ) {
        this.id = id;
        this.typ = typ;
    }

    public Status() {
    }

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
