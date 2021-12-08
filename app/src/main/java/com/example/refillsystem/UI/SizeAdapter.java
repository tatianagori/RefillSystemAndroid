package com.example.refillsystem.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.refillsystem.R;
import com.example.refillsystem.Models.Container;

import java.util.ArrayList;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.ViewHolder> {

ArrayList<Container> containers;
final private OnListItemClickListener onListItemClickListener;


    SizeAdapter(ArrayList<Container> containers , OnListItemClickListener onListItemClickListener)
    {
        this.containers = containers;
        this.onListItemClickListener = onListItemClickListener;
    }

    public void updateData(ArrayList<Container> containers)
    {
        this.containers = containers;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.size_list_item,parent,false);
        return new ViewHolder(view);
    }

    //@Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    holder.size.setText(containers.get(position).getSize() + "");
    // holder.Icon.setImageResource(items.get(position).getIconId()); DONT FORGET TO UNCOMMENT WHEN WE HAVE IMAGES

    }

    @Override
    public int getItemCount() {
        return containers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView size;

        public ViewHolder(View itemView)
        {
            super(itemView);
            size= itemView.findViewById(R.id.ProductSize);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            onListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener
    {
        void onListItemClick(int clickedItemIndex);
    }
}
