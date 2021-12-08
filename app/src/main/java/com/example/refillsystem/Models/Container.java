package com.example.refillsystem.Models;


public class Container {

    int size;
    int price;
    int batchnumber;
    String ingredients;
    String application;
    int iconId;

    public Container(int size, int price, int batchnumber, String ingredients, String applicationn, int iconId)
    {
        this.size = size;
        this.price = price;
        this.batchnumber = batchnumber;
        this.ingredients = ingredients;
        this.application = application;
        this.iconId = iconId;
    }

    public int getSize() {return size;}

    public int getPrice() {return price;}

    public int getBatchnumber() {return batchnumber;}

    public String getIngredients() {return ingredients;}

    public String getApplication() {return application;}

    public int getIconId() {return iconId;}



}
