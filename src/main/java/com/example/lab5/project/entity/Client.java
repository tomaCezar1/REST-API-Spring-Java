package com.example.lab5.project.entity;

public class Client {

    private int id;
    private String name;
    private int creditRating;
    private float salary;

    public Client(int id, String name, int creditRating, float salary) {
        this.id = id;
        this.name = name;
        this.creditRating = creditRating;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
