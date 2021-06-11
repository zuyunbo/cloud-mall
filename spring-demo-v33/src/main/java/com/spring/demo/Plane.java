package com.spring.demo;

/**
 * @Author zuyunbo
 * @Date 2021/6/11  10:46 上午
 **/
public class Plane {

    private String brand;
    private String color;
    private int maxSpeed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void introduce(){
        System.out.println("Plane brand:" + brand + " ,Color:" + color + ",maxSpeed:" + maxSpeed);
    }



}
