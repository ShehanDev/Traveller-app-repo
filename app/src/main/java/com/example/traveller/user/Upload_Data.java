package com.kitkat.traveller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.gson.internal.$Gson$Preconditions;

import java.text.DateFormat;
import java.util.Calendar;

public class Upload_Data extends AppCompatActivity {

    EditText add_package, add_lcation, add_price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_data);


        add_package = (EditText)findViewById(R.id.add_package);
        add_lcation = (EditText)findViewById(R.id.add_location);
        add_price = (EditText)findViewById(R.id.add_price);


    }
    public void Uplaod_Data(){

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Package Uploading...");
        progressDialog.show();

        PackageData packageData=new PackageData(
                add_package.getText().toString(),
                add_lcation.getText().toString(),
                add_price.getText().toString()
        );
        String myCurrentDateTime = DateFormat.getDateTimeInstance()
                .format(Calendar.getInstance().getTime());

        FirebaseDatabase.getInstance().getReference("Package")
                .child(myCurrentDateTime).setValue(packageData).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(Upload_Data.this,"Upload Successfull",Toast.LENGTH_SHORT);
                    progressDialog.dismiss();
                    finish();

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Upload_Data.this, e.getMessage().toString(), Toast.LENGTH_SHORT);
                progressDialog.dismiss();
            }
        });

    }
}