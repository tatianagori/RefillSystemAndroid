package com.example.refillsystem.UI;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.refillsystem.Models.Product;
import com.example.refillsystem.R;

import java.util.ArrayList;

public class ProductFragment extends Fragment implements ProductAdapter.OnListItemClickListener {

    private ProductViewModel viewModel;
    ProductAdapter adapter;
    RecyclerView productRecyclerList;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        ArrayList<Product> products = viewModel.getProducts().getValue();
        adapter = new ProductAdapter(products,this);
    }

    //public static ProductFragment newInstance() {
       // return new ProductFragment();
    //}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        View view = inflater.inflate(R.layout.product_fragment,container,false);

        ArrayList<Product> products = viewModel.getProducts().getValue();
        adapter = new ProductAdapter(products,this);

        productRecyclerList = view.findViewById(R.id.productsRecycler);
        productRecyclerList.hasFixedSize();
        productRecyclerList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        productRecyclerList.setAdapter(adapter);

        return view;

    }

@Override
    public void onListItemClick(int clickedItemIndex){
        Bundle bundle = new Bundle();
        if(clickedItemIndex == 0)
        {
            bundle.putInt("productCode",0);
        }
        else if(clickedItemIndex == 1)
        {
            bundle.putInt("productCode",1);
        }
        else if(clickedItemIndex == 2)
        {
            bundle.putInt("productCode",2);
        }
        else if(clickedItemIndex == 3)
        {
            bundle.putInt("productCode",3);
        }
        else if(clickedItemIndex == 4)
        {
            bundle.putInt("productCode",4);
        }
        else if(clickedItemIndex == 5)
        {
            bundle.putInt("productCode",5);
        }
        else if(clickedItemIndex == 6)
        {
            bundle.putInt("productCode",6);
        }
        else if(clickedItemIndex == 7)
        {
            bundle.putInt("productCode",7);
        }else if(clickedItemIndex == 8)
        {
            bundle.putInt("productCode",8);
        }


    Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.nav_sizes,bundle);

}

}