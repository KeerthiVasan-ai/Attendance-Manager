package com.example.attendanceregister;

import android.content.SharedPreferences;
import android.os.Bundle;

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

public class name_list extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference Database;
    Myadapter1 myadapter1;
    SharedPreferences sharedPreferences;
    ArrayList<user> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_list);




        sharedPreferences = getSharedPreferences("mypref",MODE_PRIVATE);
        String path = sharedPreferences.getString("path","");

        recyclerView = findViewById(R.id.recycle);
        Database = FirebaseDatabase.getInstance().getReference(path);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        list = new ArrayList<>();
        myadapter1 = new Myadapter1(this, list);
        recyclerView.setAdapter(myadapter1);


        Database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    user User = dataSnapshot.getValue(user.class);
                    list.add(User);
                }
                myadapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}