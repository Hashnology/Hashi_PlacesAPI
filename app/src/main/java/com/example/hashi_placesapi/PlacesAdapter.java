package com.example.hashi_placesapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.hashi_placesapi.model.MyPlaces;
import com.example.hashi_placesapi.viewholder.PlacesViewHolder;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesViewHolder> {

    //    private String[] data;
    private Context context;
    private LayoutInflater inflater;
    private MyPlaces current;
    private List<MyPlaces> data;
    private PlacesViewHolder viewHolder;

    public PlacesAdapter(Context context, List<MyPlaces> data) {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view, parent, false);

        viewHolder = new PlacesViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PlacesViewHolder holder, int position) {
//        String title = data[position];
//        holder.categoryName.setText(title);

        current = data.get(position);

        final String name = current.getMyplace();


        viewHolder.categoryName.setText(name);

        viewHolder.categoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Place Name "+data.get(viewHolder.getAdapterPosition()).getMyplace(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
