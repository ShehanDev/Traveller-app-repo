package com.example.traveller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toast.makeText(DetailsActivity.this, "Firebase connnection Success.", Toast.LENGTH_SHORT).show();
        Toast.makeText(DetailsActivity.this, "Booking Success.", Toast.LENGTH_SHORT).show();
    }
}