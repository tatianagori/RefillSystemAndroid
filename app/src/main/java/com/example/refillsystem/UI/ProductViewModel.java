package com.example.refillsystem.UI;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.refillsystem.Models.Product;
import com.example.refillsystem.Models.ProductRepository;

import java.util.ArrayList;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository repository;

    public ProductViewModel(Application app){
        super(app);
        repository = ProductRepository.getInstance(app.getApplicationContext());
    }

    public LiveData<ArrayList<Product>> getProducts() { return repository.getProductList();}
}