package com.kitkat.traveller;

public class Packages {

    private String PackageName;
    private String Location;
    private String Price;
    public Packages(){}

    public Packages(String packageName, String location, String price) {
       this.PackageName = packageName;
       this.Location = location;
       this.Price = price;
    }

    public String getPackageName() {
        return PackageName;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
