package com.example.project.Model;

public class Booking {
    private Integer id;
    private Integer UID;
    private String startDate;
    private String endDate;


    public Booking(Integer id, Integer UID, String startDate, String endDate) {
        this.id = id;
        this.UID = UID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer uID) {
        this.UID = uID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
