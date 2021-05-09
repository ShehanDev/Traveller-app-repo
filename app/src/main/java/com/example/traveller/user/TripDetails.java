package com.example.traveller.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traveller.R;

public class TripDetails extends AppCompatActivity {

    TextView txdname,txdlocation,txddes;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_trip_details );

        txdname = findViewById ( R.id.txname );
        txdlocation= findViewById ( R.id.txlocation );
        txddes= findViewById ( R.id.txDes );
        //image =findViewById ( R.id.txImage );




        Bundle bundle =getIntent ().getExtras ();



        if (bundle != null){
            txdname.setText ( bundle.getString ( "txdname" ) );
            txdlocation.setText ( bundle.getString ( "txdlocation" ) );
            txddes.setText ( bundle.getString ( "txddes" ) );


        }


    }

    public void backTripto(View view) {
        Intent intent =new Intent ( getApplicationContext (),MyTrips.class );
        startActivity ( intent );
    }

    public void deleteTrip(View view) {
        Toast.makeText(this, "Trip Deleted successfully", Toast.LENGTH_SHORT).show();

    }
}