package com.example.lab5.project.entity;

public class Automobile {

    private long id;
    private String brand;
    private String country;
    private Integer price;
    private String power;

    public Automobile(long id, String brand, String country, Integer price, String power) {
        this.id = id;
        this.brand = brand;
        this.country = country;
        this.price = price;
        this.power = power;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
