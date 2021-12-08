package com.example.refillsystem.Models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import com.example.refillsystem.R;

public class ContainerDAO {

    private MutableLiveData<ArrayList<Container>> containers;
    private static ContainerDAO instance;

    private ArrayList<Container> multieOlie;
    private ArrayList<Container> handlotion;
    private ArrayList<Container> bodylotion;
    private ArrayList<Container> showergel;
    private ArrayList<Container> dagcream;
    private ArrayList<Container> natcream;
    private ArrayList<Container> multishampoo;
    private ArrayList<Container> plejendebalsam;

    //TODO add the rest of the products here

    private ArrayList<Container> items;
    private MutableLiveData<ArrayList<Container>> data;

    Context context;

    public static ContainerDAO getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new ContainerDAO(context);
        }
        return instance;
    }

    private ContainerDAO(Context context)
    {
        this.context = context;
        items = new ArrayList<>();
        containers = new MutableLiveData<>();
        data = new MutableLiveData<>();

        multieOlie = new ArrayList<>();
        multieOlie.add(new Container(100, 179, 102938, context.getString(R.string.multi_olie_ingredients), context.getString(R.string.multi_olie_application),1293));
        multieOlie.add(new Container(250, 220, 102938, context.getString(R.string.multi_olie_ingredients), context.getString(R.string.multi_olie_application),1293));
        multieOlie.add(new Container(500, 350, 102938, context.getString(R.string.multi_olie_ingredients), context.getString(R.string.multi_olie_application),1293));
        multieOlie.add(new Container(750, 470, 102938, context.getString(R.string.multi_olie_ingredients), context.getString(R.string.multi_olie_application),1293));
        multieOlie.add(new Container(1000, 600, 102938, context.getString(R.string.multi_olie_ingredients), context.getString(R.string.multi_olie_application),1293));

        handlotion = new ArrayList<>();
        handlotion.add(new Container(100, 179, 102938, context.getString(R.string.handlotion_parfumefri_ingredients), context.getString(R.string.handlotion_parfumefri_application),1293));
        handlotion.add(new Container(250, 220, 102938, context.getString(R.string.handlotion_parfumefri_ingredients), context.getString(R.string.handlotion_parfumefri_application),1293));
        handlotion.add(new Container(500, 350, 102938, context.getString(R.string.handlotion_parfumefri_ingredients), context.getString(R.string.handlotion_parfumefri_application),1293));
        handlotion.add(new Container(750, 470, 102938, context.getString(R.string.handlotion_parfumefri_ingredients), context.getString(R.string.handlotion_parfumefri_application),1293));
        handlotion.add(new Container(1000, 600, 102938, context.getString(R.string.handlotion_parfumefri_ingredients), context.getString(R.string.handlotion_parfumefri_application),1293));



    }

    public LiveData<ArrayList<Container>> getContainers(int code)
    {
        if(code == 0)
        {
            containers.setValue(multieOlie);
        }
        return containers;
    }

    public void selectContainer( Container container)
    {
        Boolean exists = false;
        Container newContainer = new Container(container.getSize(), container.getPrice(), container.getBatchnumber(), container.getIngredients(), container.getApplication(), container.getIconId());
        ArrayList<Container> current = data.getValue();
        items.add(newContainer);
        data.setValue(current);

    }

    public LiveData<ArrayList<Container>> showSelectedProduct()
    {
        data.setValue(items);
        return data;
    }




    // TODO the rest of the if cases for each product

}