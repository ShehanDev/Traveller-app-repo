package com.example.traveller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveller.R;
import com.example.traveller.BookingData;

import java.util.List;

 public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder>{
     Context context;
     List<BookingData> bookingDataList;

     public BookingAdapter(MainActivity mainActivity, List<BookingData> bookingDataList) {
     }
     @NonNull
     @Override
     public BookingAdapter.BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.booking_row_items,parent,false);
         return new BookingViewHolder(view);
     }
     @Override
     public void onBindViewHolder(@NonNull BookingAdapter.BookingViewHolder holder, int position) {
         holder.packageId.setText(bookingDataList.get(position).getPackageId());
         holder.price.setText(bookingDataList.get(position).getPrice());
         holder.placeImage.setImageResource(bookingDataList.get(position).getImageUrl());
     }
     @Override
     public int getItemCount() {
         return bookingDataList.size();
     }

     public static final class BookingViewHolder extends RecyclerView.ViewHolder{
         ImageView placeImage;
         TextView packageId,price;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            packageId = itemView.findViewById(R.id.packageId);
            price = itemView.findViewById(R.id.price);
        }
    }
}
