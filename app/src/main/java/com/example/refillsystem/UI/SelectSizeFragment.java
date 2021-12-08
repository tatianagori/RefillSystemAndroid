package com.example.refillsystem.UI;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.refillsystem.Models.Container;
import com.example.refillsystem.R;

import java.util.ArrayList;

public class SelectSizeFragment extends Fragment implements SizeAdapter.OnListItemClickListener {

    private SelectSizeViewModel viewModel;
    SizeAdapter adapter;
    RecyclerView containersRecyclerList;
    private int productCode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        productCode = getArguments().getInt("productCode");

        viewModel = new ViewModelProvider(this).get(SelectSizeViewModel.class);
        ArrayList<Container> containers = viewModel.getContainers(productCode).getValue();

        adapter = new SizeAdapter(containers, this);

        View view = inflater.inflate(R.layout.select_size_fragment,container, false);
        viewModel.getContainers(productCode).observe(getViewLifecycleOwner(), adapter::updateData);
        containersRecyclerList= view.findViewById(R.id.containersRecycler);
        containersRecyclerList.hasFixedSize();
        containersRecyclerList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        containersRecyclerList.setAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex)
    {
        Container newContainer = adapter.containers.get(clickedItemIndex);
        viewModel.selectContainer(newContainer);

    }

}