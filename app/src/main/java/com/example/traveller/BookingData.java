package com.example.traveller;

public class BookingData {

    String packageId;
    String price;
    Integer imageUrl;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BookingData(String packageId , String price , Integer imageUrl) {
        this.packageId = packageId;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

