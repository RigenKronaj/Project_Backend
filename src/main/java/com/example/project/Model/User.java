package com.example.project.Model;

public class User {
    private Integer UID;
    private String name;
    private String surname;
    private String email;
    private Integer nrOfBookings;

    public User(Integer UID, String name, String surname, String email, Integer nrOfBookings) {
        this.UID = UID;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.nrOfBookings = nrOfBookings;
    }

    public Integer getNrOfBookings() {
        return nrOfBookings;
    }

    public void setNrOfBookings(Integer nrOfBookings) {
        this.nrOfBookings = nrOfBookings;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer uID) {
        this.UID = uID;
    }
}
