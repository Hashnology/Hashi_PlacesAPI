package com.example.hashi_placesapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hashi_placesapi.model.MyPlaces;
import com.example.hashi_placesapi.viewholder.PlacesViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<PlacesViewHolder> {
    private Context context;
    private PlacesViewHolder viewHolder;
    private LayoutInflater inflater;
    private MyPlaces myPlaces;
    private List<MyPlaces> data;

    public    TestAdapter(Context context , List<MyPlaces> data){
        this.context=context;
        this.inflater=LayoutInflater.from(context);
        this.data=data;
    }
    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.item_view, viewGroup,false);

   viewHolder=new PlacesViewHolder(view);
   return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder placesViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
