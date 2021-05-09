package com.example.traveller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView bookingRecycler;
    BookingAdapter bookingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<BookingData> bookingDataList = new ArrayList<>();
        bookingDataList.add(new BookingData(packageId:"S01", price "Rs.12000", R.drawable.sigiriya1));
        bookingDataList.add(new BookingData(packageId:"Y01", price "Rs.9000", R.drawable.th));
        setBookingRecycler(bookingDataList);
    }
    private void setBookingRecycler(List<BookingData> bookingDataList){

        bookingRecycler = findViewById(R.id.booking_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);

        bookingRecycler.setLayoutManager(layoutManager);
        bookingAdapter= new BookingAdapter(this,bookingDataList);
        bookingRecycler.setAdapter(bookingAdapter);
    }
}
