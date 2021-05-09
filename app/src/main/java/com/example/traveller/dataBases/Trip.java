package com.example.traveller.dataBases;

public class Trip {
    private String tname;
    private String location;
    private String discription;
    public String imageURL;
    public Trip() { }

    public Trip(String tname, String location, String discription, String imageURL) {
        this.tname = tname;
        this.location = location;
        this.discription = discription;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
