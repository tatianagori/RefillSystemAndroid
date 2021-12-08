package com.example.refillsystem.Models;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;

public class ProductRepository {

    private ProductDAO productDAO;
    private static ProductRepository instance;

    public static ProductRepository getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new ProductRepository(context);
        }
        return instance;
    }

    private ProductRepository(Context context)
    {
        productDAO = ProductDAO.getInstance(context);
    }

    public LiveData<ArrayList<Product>> getProductList()
    {
        return productDAO.getProducts();
    }

}