package com.example.traveller.common;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveller.R;
import com.example.traveller.user.MyTrips;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    EditText ckname,ckpassword;
    CheckBox loged;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        ckname = findViewById ( R.id.uName );
        ckpassword =findViewById ( R.id.tPassword );


    }

    public void goTosignUp(View view) {

        Intent intent = new Intent ( getApplicationContext (), Register.class );
        startActivity ( intent );
    }

    public void userLogedin(View view) {

        String tname = ckname.getText().toString ().trim ();
        String tckpassword = ckpassword.getText().toString ().trim ();

               Query checkUser = FirebaseDatabase.getInstance ().getReference ("user").orderByChild ( "uname" ).equalTo ( tname  );
                checkUser.addListenerForSingleValueEvent ( new ValueEventListener ( ) {
                    DatabaseError databaseError;
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists ()){

                            ckname.setError ( null );
                            ckname.setEnabled ( false );

                            String systemPassWord =  snapshot.child (  tname).child ( "pass" ).getValue (String.class );
                            if (systemPassWord.equals ( tckpassword  )){
                                ckpassword.setError ( null );
                                ckpassword.setEnabled ( false );



                            }
                        }
                        
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText ( Login.this, databaseError.getMessage (), Toast.LENGTH_SHORT ).show ( );
                    }
                });
    }


}