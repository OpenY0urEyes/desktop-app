package ru.mail.megatable.models;

public class Doctor {
    private String firstname;
    private String lastname;
    private int specialId;
    private int naprId;
    private String password;
    private String roles;


    public Doctor() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSpecialId() {
        return specialId;
    }

    public void setSpecialId(int specialId) {
        this.specialId = specialId;
    }

    public int getNaprId() {
        return naprId;
    }

    public void setNaprId(int naprId) {
        this.naprId = naprId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
