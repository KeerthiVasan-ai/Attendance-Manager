package com.example.attendanceregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminName extends AppCompatActivity {

    ImageButton insertdata;
    RecyclerView recyclerView;
    DatabaseReference Database;
    Myadapter myadapter;
    SharedPreferences sharedPreferences;
    ArrayList<user> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_name);
//        getSupportActionBar().setTitle("Name List");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        insertdata = findViewById(R.id.insertdata);

        sharedPreferences = getSharedPreferences("mypref",MODE_PRIVATE);
        String adminpath = sharedPreferences.getString("adminpath","");



        insertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminName.this,insertingdata.class);
                startActivity(intent);
                //finish();
            }
        });

        recyclerView = findViewById(R.id.recycle2);
        Database = FirebaseDatabase.getInstance().getReference(adminpath);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        list = new ArrayList<>();
        myadapter = new Myadapter(this, list);
        recyclerView.setAdapter(myadapter);

        Database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    user User = dataSnapshot.getValue(user.class);
                    list.add(User);
                }
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}