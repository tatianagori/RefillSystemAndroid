package com.example.refillsystem.Models;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;

public class ContainerRepository {
    private ContainerDAO containerDAO;
    private static ContainerRepository instance;

    public static ContainerRepository getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new ContainerRepository(context);
        }
        return instance;
    }

    private ContainerRepository(Context context)
    {
        containerDAO = ContainerDAO.getInstance(context);
    }

    public LiveData<ArrayList<Container>> getContainerList(int code)
    {
        return containerDAO.getContainers(code);
    }

    public void selectContainer(Container container){containerDAO.selectContainer(container);}

    public LiveData<ArrayList<Container>> showSelectedProduct() {return containerDAO.showSelectedProduct();}
}