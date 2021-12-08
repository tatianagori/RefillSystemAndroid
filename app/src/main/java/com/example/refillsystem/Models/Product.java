package com.example.refillsystem.Models;



public class Product {

    String name;
    private int iconId;
    String company;


    //TODO add image as an attribute and store the images in the drawable res file


    public Product(String name, int iconId , String company)
    {

        this.name = name;
        this.iconId = iconId;
        this.company = company;

    }


    public String getName(){return name;}
    //public void setName(){this.name = name;}
    public String getCompany(){return company;}
    //public void setCompany(){this.company = company;}
    public int getIconId(){return iconId;}



}