package com.example.project.Model;

public class Booking {
    private Integer id;
    private Integer UID;
    private String article;
    private String startDate;
    private String endDate;
    private Boolean isReserved;

    public Booking(Integer id, Integer UID, String article, String startDate, String endDate, Boolean isReserved) {
        this.id = id;
        this.UID = UID;
        this.article = article;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isReserved = isReserved;
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

    public Boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(Boolean isReserved) {
        this.isReserved = isReserved;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
