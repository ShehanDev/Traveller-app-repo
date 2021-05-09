package com.example.traveller.user;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.traveller.R;
import com.example.traveller.dataBases.Trip;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;

import javax.xml.validation.Validator;


public class Addtrips extends AppCompatActivity   {




    private String pname,plocation,pdiscription;
    FirebaseDatabase database;
    // Creating EditText.

    EditText tname, location,discription;
    // Image request code for onActivityResult() .
    int Image_Request_Code = 7;
    ProgressDialog progressDialog ;
    // Creating ImageView.
    ImageView imgview;
    Uri uri;
    // Creating StorageReference and DatabaseReference object.
    private String imageUrl;
    DatabaseReference ref;
    // Creating button.
    Button addPic,btnSave;
    ProgressDialog loadingBar;
    private Throwable e;
    private static final int GalleryPick = 1;



   


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_addtrips );

        imgview = findViewById ( R.id.imgview );
        tname = findViewById ( R.id.tripName );
        location = findViewById ( R.id.editLocation );
        discription = findViewById ( R.id.editDescrip );

    }


    public void imagePicker(View view) {
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, GalleryPick);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult ( requestCode, resultCode, data );
        if (requestCode==GalleryPick  &&  resultCode==RESULT_OK  &&  data!=null){
            uri = data.getData();
            imgview.setImageURI( uri);
        }
        else Toast.makeText(this, "You havent Image ..", Toast.LENGTH_SHORT).show();
    }

    public void uploadImage() {
        StorageReference storageReference = FirebaseStorage.getInstance ( )
                .getReference ( ).child ( "tripImage" ).child ( uri.getLastPathSegment ( ) );

        loadingBar = new ProgressDialog ( this );
        loadingBar.setMessage ( "Your Trip Uploading...." );
        loadingBar.show ();





        storageReference.putFile ( uri ).addOnSuccessListener ( new OnSuccessListener<UploadTask.TaskSnapshot> ( ) {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage ( ).getDownloadUrl ( );
                while (!uriTask.isComplete ( )) ;
                Uri uriImage = uriTask.getResult ( );
                imageUrl = uriImage.toString ( );
                uploadTrip();
                loadingBar.dismiss ();
                Toast.makeText ( Addtrips.this, "Image Uploaded", Toast.LENGTH_SHORT ).show ( );

            }
        } ).addOnFailureListener ( new OnFailureListener ( ) {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingBar.dismiss ();
            }
        } );


    }




    public void btnUploadTrip(View view) {

            if (!validatdeTripName () | !validatdeTripLocation () | !validatdeTripDiscip () ){

                return;
            }
            else
            uploadImage();

    }

    public  void uploadTrip(){
        loadingBar = new ProgressDialog ( this );
        loadingBar.setMessage ( "Your Trip Uploading...." );
        loadingBar.show ();

        Trip trip = new Trip (
                tname.getText ().toString (),
                location.getText ().toString (),
                discription.getText ().toString (),
                imageUrl
        );

        String myCurrentDtateTime = DateFormat.getDateTimeInstance ().format ( Calendar.getInstance ( ).getTime () );
        FirebaseDatabase.getInstance ().getReference ("trip")
                .child ( myCurrentDtateTime ).setValue (trip  ).addOnCompleteListener ( new OnCompleteListener<Void> ( ) {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful ()){
                    Toast.makeText ( Addtrips.this, "Trip Addedd", Toast.LENGTH_SHORT ).show ( );

                    finish ();
                }

            }
        } ).addOnFailureListener ( new OnFailureListener ( ) {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText ( Addtrips.this, e.getMessage (), Toast.LENGTH_SHORT ).show ( );

            }

        } );

    }


    private Boolean validatdeTripName(){
        String val = tname.getText ().toString ();
        if(val.isEmpty ()){
            tname.setError ( "Feild is Empty" );
            return false;

        }
        else {
            tname.setError ( null );
            return true;
        }
    }
    private Boolean validatdeTripLocation(){
        String val = location.getText ().toString ();
        if(val.isEmpty ()){
            location.setError ( "Feild is Empty" );
            return false;

        }
        else {
            location.setError ( null );
            return true;
        }
    }
    private Boolean validatdeTripDiscip(){
        String val = discription.getText ().toString ();
        if(val.isEmpty ()){
            discription.setError ( "Feild is Empty" );
            return false;

        }
        else {
            discription.setError ( null );
            return true;
        }
    }




}





