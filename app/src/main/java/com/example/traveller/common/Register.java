package com.example.traveller.common;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traveller.R;
import com.example.traveller.dataBases.User;
import com.example.traveller.user.uerDashBoard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private Button reg;
    private EditText fname;
    private EditText uname;
    private EditText email;
    private EditText pass;
    private EditText pNum;
    private FirebaseDatabase database;
    TextView tv;
    DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_register );








        reg = findViewById(R.id.btnSignIn);
        uname = findViewById(R.id.eUserName);
        fname = findViewById(R.id.efullname);
        email = findViewById(R.id.eEmail);
        pass = findViewById(R.id.ePassword);
        tv = findViewById(R.id.textView3);
        pNum = findViewById ( R.id.ePhone );
        tv.setOnClickListener( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplication(),Login.class));
            }
        } );

        reg.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance ();
                reference =  FirebaseDatabase.getInstance().getReference("user");


                 String   unameTv =        uname.getText ().toString ();
                String   fnameTv =         fname.getText ().toString ();
                String   emailTv =       email.getText ().toString ();
                String   passTv =         pass.getText ().toString ();
                String   pNumTV =         pNum.getText ().toString ();

                User user =new User ( unameTv,fnameTv,emailTv,passTv,pNumTV);

                reference.child ( unameTv ).setValue ( user );

            }
        } );

    }




}