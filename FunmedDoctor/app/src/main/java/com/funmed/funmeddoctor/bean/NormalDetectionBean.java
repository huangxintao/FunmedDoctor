package com.funmed.funmeddoctor.bean;

/**
 * Created by tony on 2017/8/2.
 */

public class NormalDetectionBean {
    private String id;
    private String name;
    private int number;
    private double price;
    private String image;

    public NormalDetectionBean(String id, String name, double price,int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public NormalDetectionBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
