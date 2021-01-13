package com.example.lab5.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@AllArgsConstructor
@ToString
public class Manufacturer {
    
    private int id;
    private String location;
    private float sales;
    private float marketCap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getSales() {
        return sales;
    }

    public void setSales(float sales) {
        this.sales = sales;
    }

    public float getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(float marketCap) {
        this.marketCap = marketCap;
    }

    public Manufacturer(int id, String location, float sales, float marketCap) {
        this.id = id;
        this.location = location;
        this.sales = sales;
        this.marketCap = marketCap;
    }
}
