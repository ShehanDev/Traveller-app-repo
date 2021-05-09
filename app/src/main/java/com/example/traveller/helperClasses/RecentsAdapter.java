package com.kitkat.traveller.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kitkat.traveller.DetailsActivity;
import com.kitkat.traveller.R;
import com.kitkat.traveller.model.RecentData;

import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder> {

    Context context;

    public RecentsAdapter(Context context, List<RecentData> recentDataList) {
        this.context = context;
        this.recentDataList = recentDataList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<RecentData> getRecentDataList() {
        return recentDataList;
    }

    public void setRecentDataList(List<RecentData> recentDataList) {
        this.recentDataList = recentDataList;
    }

    List<RecentData> recentDataList;

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.recents_raw_item,parent,false);
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {

        holder.placename.setText(recentDataList.get(position).getPlacename());
        holder.duration.setText(recentDataList.get(position).getDuration());
        holder.price.setText(recentDataList.get(position).getPrice());
        holder.placeImage.setImageResource(recentDataList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, DetailsActivity.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recentDataList.size();
    }

    public static final class RecentsViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placename, duration, price;
        public RecentsViewHolder(@NonNull View itemView){

            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            placename = itemView.findViewById(R.id.placename);
            duration = itemView.findViewById(R.id.duration);
            price = itemView.findViewById(R.id.price);
        }
    }
}
