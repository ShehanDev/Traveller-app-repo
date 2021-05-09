package com.kitkat.traveller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kitkat.traveller.adapter.RecentsAdapter;
import com.kitkat.traveller.model.RecentData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    Context context;

    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;

    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =(Button) findViewById(R.id.settingbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openManagePackages();
            }
        });
        

        int images[] = {R.drawable.sri_lanka1,R.drawable.sri_lanka,R.drawable.srilanka6,R.drawable.sri_lanka5,R.drawable.sri_lanka3,R.drawable.sri_lanka2};

        viewFlipper = findViewById(R.id.viewflipper);

        for (int image: images){
            flipperImages(image);
        }


        //list data
        List<RecentData> recentDataList = new ArrayList<>();
        recentDataList.add(new RecentData("Pasikuda Beach", "4 Days 3 Nights", "Rs.9000.00", R.drawable.pasikuda02));
        recentDataList.add(new RecentData("Sigiriya", "5 Days 4 Nights", "Rs.12000.00", R.drawable.sigiriya));
        recentDataList.add(new RecentData("Yala", "3 Days 2 Nights", "Rs.9000.00", R.drawable.yaala));
        recentDataList.add(new RecentData("Ella", "4 Days 3 Nights", "Rs.10000.00", R.drawable.ella));

        setRecentRecycler(recentDataList);

    }

    public void openManagePackages()
    {
        Intent intent = new Intent(this, ManagePackages.class);
        startActivity(intent);

    }

    private void setRecentRecycler(List<RecentData> recentDataList) {

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);//4 sec
        viewFlipper.setAutoStart(true);

        //Animations
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

}

