package com.example.hashi_placesapi.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hashi_placesapi.R;


public class PlacesViewHolder extends RecyclerView.ViewHolder {

    public TextView categoryName;

    public PlacesViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryName = itemView.findViewById(R.id.tvMajorCat);
    }
}
