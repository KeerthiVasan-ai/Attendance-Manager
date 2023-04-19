package com.example.attendanceregister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText email;
    private EditText pass;

    public void login(View view){
            String id = email.getText().toString();
            String id_pass = pass.getText().toString();

            if(!id.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(id).matches()) {
                if(!id_pass.isEmpty()){
                    auth.signInWithEmailAndPassword(id,id_pass)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(MainActivity.this, "Login Succesed!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this,class_list.class));
                                    //finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity.this, "Login Falied!", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    pass.setError("Password Cannot be empty");
                }
            } else if(id.isEmpty()){
                email.setError("Email Cannot be empty");
            } else {
                email.setError("Enter proper mail  id");
            }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().setTitle("Staff Login");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        auth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);


    }
}