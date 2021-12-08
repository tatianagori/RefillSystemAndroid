package com.example.refillsystem.Models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.refillsystem.R;

import java.util.ArrayList;

public class ProductDAO {
    private MutableLiveData<ArrayList<Product>> products;
    private static ProductDAO instance;

    Context context;

    //private ArrayList<Product> ecookingProducts;

    public static ProductDAO getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new ProductDAO(context);
        }
        return instance;
    }

    private ProductDAO(Context context)
    {
        this.context = context;
        products = new MutableLiveData<>();
        ArrayList<Product> newList = new ArrayList<>();
        newList.add(new Product ( "Multi Olie", R.drawable.multiolie , "Ecooking"));
        newList.add(new Product("Handlotion parfumefri", 9382, "Ecooking"));
        newList.add(new Product("Bodylotion", 9312, "Ecooking"));
        newList.add(new Product("Showegel", 1382, "Ecooking"));
        newList.add(new Product("Dagcreme parfumefri", 9315, "Ecooking"));
        newList.add(new Product("natcreme parfumefri", 1922, "Ecooking"));
        newList.add(new Product("MultiShampoo", 9232, "Ecooking"));
        newList.add(new Product("Plejende Balsam", 3510, "Ecooking"));

        // TODO add the rest of the products
        // TODO change this to being formated as strings and save all info in the values res folder

        products.setValue(newList);
    }

    public LiveData<ArrayList<Product>> getProducts()
    {
        return products;
    }

}