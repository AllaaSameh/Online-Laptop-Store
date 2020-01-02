package com.example.laptopshope;

public class laptop {

    private int id;
    private String brand;
    private String img;
    private double price;
    private float rate;

    public laptop(int id, String brand, String img, double price, float rate) {
        this.id = id;
        this.brand = brand;
        this.img = img;
        this.price = price;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
