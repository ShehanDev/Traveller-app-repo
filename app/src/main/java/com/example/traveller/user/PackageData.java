package com.kitkat.traveller;

public class PackageData {

    private String add_package;
    private String add_location;
    private String add_price;
    private int place_image;

    public PackageData(String add_package, String add_location, String add_price, int place_image) {
        this.add_package = add_package;
        this.add_location = add_location;
        this.add_price = add_price;
    }

    public PackageData(){

    }


    public String getAdd_package() {
        return add_package;
    }

    public void setAdd_package(String add_package) {
        this.add_package = add_package;
    }

    public String getAdd_location() {
        return add_location;
    }

    public void setAdd_location(String add_location) {
        this.add_location = add_location;
    }

    public String getAdd_price() {
        return add_price;
    }

    public void setAdd_price(String add_price) {
        this.add_price = add_price;
    }


}
