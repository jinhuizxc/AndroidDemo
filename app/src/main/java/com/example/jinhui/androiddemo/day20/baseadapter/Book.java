package com.example.jinhui.androiddemo.day20.baseadapter;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class Book {

    private String name;
    private int imageId;
    private double price;
    private int number;

    public Book(String name, int imageId, double price, int number) {
        super();
        this.name = name;
        this.imageId = imageId;
        this.price = price;
        this.number = number;
    }

    public Book(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void subNumber(){
        if(number > 1){
            number--;
        }
    }

    public void addNumber(){
        number++;
    }
}
