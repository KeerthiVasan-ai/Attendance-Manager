package com.example.attendanceregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insertingdata extends AppCompatActivity {

    EditText insertname;
    EditText insertroll;
    EditText insertphone;
    Button done;
    SharedPreferences sharedPreferences;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertingdata);
//        getSupportActionBar().setTitle("InfoRegistration");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        insertname = findViewById(R.id.insertname);
        insertroll = findViewById(R.id.insertroll);
        insertphone = findViewById(R.id.insertphone);
        done = findViewById(R.id.done);
        sharedPreferences = getSharedPreferences("mypref",MODE_PRIVATE);
        String insertpath = sharedPreferences.getString("adminpath","");


        reference = FirebaseDatabase.getInstance().getReference().child(insertpath);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertdata();
            }
        });
    }

    private void insertdata() {

        String name = insertname.getText().toString();
        String rollno = insertroll.getText().toString();
        String phone = insertphone.getText().toString();


        if(!name.isEmpty() && !phone.isEmpty() && !phone.isEmpty()  ){
            user1 User1 = new user1(name,phone,rollno);
            reference.push().setValue(User1);
            Toast.makeText(this,"Inserted SucessFully",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(insertingdata.this,AdminName.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,"All field are required",Toast.LENGTH_SHORT).show();
        }

    }
}