package com.kitkat.traveller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kitkat.traveller.adapter.PackageAdapter;
import com.kitkat.traveller.adapter.RecentsAdapter;
import com.kitkat.traveller.model.RecentData;

import java.util.ArrayList;
import java.util.List;

public class ManagePackages extends AppCompatActivity {

    Button button;

    RecyclerView packageRecycler;
    RecentsAdapter PackageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_packages);


        button = (Button) findViewById(R.id.addbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUpload_Data();
            }
        });

        //list data
        List<PackageData> packageDataList = new ArrayList<>();
        packageDataList.add(new PackageData("Pasikuda Beach", "Pasikuda", "Rs.9000.00", R.drawable.pasikuda02));
        packageDataList.add(new PackageData("Sigiriya", "Sigiriya", "Rs.12000.00",R.drawable.sigiriya));
        packageDataList.add(new PackageData("Yala", "Yala", "Rs.9000.00",R.drawable.yaala));
        packageDataList.add(new PackageData("Ella", "Ella", "Rs.10000.00",R.drawable.ella));

        setPackageRecycler(packageDataList);


    }

    public void openUpload_Data() {
        Intent intent = new Intent(this, Upload_Data.class);
        startActivity(intent);
    }

    private void setPackageRecycler(List<PackageData> packageDataList) {

        packageRecycler = findViewById(R.id.packagereceive);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        packageRecycler.setLayoutManager(layoutManager);
        packageRecycler = new PackageAdapter(this,packageDataList);
        packageRecycler.setAdapter(PackageAdapter);

    };
}