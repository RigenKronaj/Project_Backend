package com.example.project.Model;

public class Booking {
    private Integer id;
    private Integer UID;
    private Article article;
    private Integer nrOfDays;
    private Integer nrOfBookings;

    public Booking() {
        
    }

    public Booking(Integer id, Integer UID, Article article, Integer nrOfDays, Integer nrOfBookings) {
        this.id = id;
        this.UID = UID;
        this.article = article;
        this.nrOfDays = nrOfDays;
        this.nrOfBookings = nrOfBookings;
    }

    public Integer getNrOfBookings() {
        return nrOfBookings;
    }

    public void setNrOfBookings(Integer nrOfBookings) {
        this.nrOfBookings = nrOfBookings;
    }

    public Integer getNrOfDays() {
        return nrOfDays;
    }

    public void setNrOfDays(Integer nrOfDays) {
        this.nrOfDays = nrOfDays;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
