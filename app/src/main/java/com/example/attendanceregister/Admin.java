package com.example.attendanceregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Admin extends AppCompatActivity {

    FirebaseAuth auth;
    EditText email;
    EditText pass;
    EditText insituition;
    Button adminlogin;
    //SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        //getSupportActionBar().setTitle("Admin Login");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.adminemail);
        pass = findViewById(R.id.adminpass);
        insituition = findViewById(R.id.insitution);
        adminlogin = findViewById(R.id.adminlogin);

        //sharedPreferences = getSharedPreferences("mypref",MODE_PRIVATE);


        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = email.getText().toString();
                String id_pass = pass.getText().toString();
                String name = insituition.getText().toString();

                if(!id.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(id).matches()) {
                    if(!id_pass.isEmpty()) {
                        if (!name.isEmpty()) {
                            auth.signInWithEmailAndPassword(id, id_pass)
                                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
//                                        SharedPreferences.Editor myEdit = sharedPreferences.edit();
//                                        myEdit.putString("insituition",insituition.getText().toString());
//                                        myEdit.commit();
                                            Toast.makeText(Admin.this, "Login Successed!", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(Admin.this, AdminClass.class));
                                            //finish();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(Admin.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                            } else {
                                insituition.setError("Insituition Cannot be Empty");
                            }
                        } else {
                            pass.setError("Password Cannot be empty");
                        }
                    } else if(id.isEmpty()) {
                        email.setError("Email Cannot be empty");
                } else {
                    email.setError("Enter proper mail  id");
                }
            }
        });

    }
}