package com.example.refillsystem.UI;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.refillsystem.Models.Container;
import com.example.refillsystem.Models.ContainerRepository;

import java.util.ArrayList;

public class SelectSizeViewModel extends AndroidViewModel {

    private ContainerRepository repository;

    public SelectSizeViewModel(Application application)
    {
        super(application);
        repository = ContainerRepository.getInstance(application.getApplicationContext());
    }

    public LiveData<ArrayList<Container>> getContainers(int code)
    {
        return repository.getContainerList(code);
    }

    public void selectContainer(Container container) {repository.selectContainer(container);}


}