package com.example.traveller.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.traveller.R;
import com.example.traveller.dataBases.Trip;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MyTrips extends AppCompatActivity {

    RecyclerView mrecyclerView;
    List<Trip> myTripList;

    DatabaseReference databaseReference;
    ValueEventListener eventListener;
    private ProgressDialog progressDialog;
    EditText txtScearch;
    TripAdapter tripAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_my_trips );

        txtScearch = findViewById ( R.id.txt_search );

        mrecyclerView = findViewById ( R.id.recyclerTrip );


        GridLayoutManager gridLayoutManager = new GridLayoutManager (  MyTrips.this,1);
        mrecyclerView.setLayoutManager ( gridLayoutManager );

        progressDialog = new ProgressDialog ( this );
        progressDialog.setMessage ( "Loading Items...." );

        myTripList = new ArrayList<> (  );

        TripAdapter tripAdapter = new TripAdapter ( MyTrips.this,myTripList );
        mrecyclerView.setAdapter ( tripAdapter );

        databaseReference = FirebaseDatabase.getInstance ().getReference ( "trip" );
        progressDialog.show ();
        eventListener = databaseReference.addValueEventListener ( new ValueEventListener ( ) {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myTripList.clear ( );

                for (DataSnapshot itemSanapshot : snapshot.getChildren ( )) {

                    Trip trip = itemSanapshot.getValue ( Trip.class );
                    myTripList.add (trip );

                }
                tripAdapter.notifyDataSetChanged ( );
                progressDialog.dismiss ( );

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressDialog.dismiss ( );
            }
        } );






    }



    public void btnADDmytrip(View view) {
        startActivity ( new Intent ( this,Addtrips.class ) );
    }
}