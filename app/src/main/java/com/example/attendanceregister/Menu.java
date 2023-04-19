package com.example.attendanceregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {


    ImageButton admin;
    ImageButton staff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //getSupportActionBar().setTitle("Attendance Register");

        admin = findViewById(R.id.admin);
        staff = findViewById(R.id.Staff);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,Admin.class);
                startActivity(i);
                //finish();
            }
        });

        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,MainActivity.class);
                startActivity(i);
                //finish();
            }
        });

    }
}