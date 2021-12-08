package com.example.refillsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.refillsystem.UI.MainActivityViewModel;
import com.example.refillsystem.UI.ProductFragment;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        }

    }

