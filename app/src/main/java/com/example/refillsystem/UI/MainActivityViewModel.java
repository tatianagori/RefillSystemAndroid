package com.example.refillsystem.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.refillsystem.Models.Product;
import com.example.refillsystem.Models.ProductRepository;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {

    private final ProductRepository productRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        productRepository = ProductRepository.getInstance(application.getApplicationContext());
    }


    public LiveData<ArrayList<Product>> getProduct(){
        return productRepository.getProductList();
    }
}
