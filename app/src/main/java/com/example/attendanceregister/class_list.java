package com.example.attendanceregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class class_list extends AppCompatActivity {

    LinearLayout layout1;
    SharedPreferences sharedPreferences;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);

        sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);
        layout1 = findViewById(R.id.recycle3);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Department");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                layout1.removeAllViews();

                for (DataSnapshot branch : snapshot.getChildren()){
                    String b = branch.getKey();
                    String bname = branch.getValue(String.class);

                    LinearLayout horLayout = new LinearLayout(class_list.this);
                    horLayout.setOrientation(LinearLayout.HORIZONTAL);

                    Button button = new Button(class_list.this);
                    button.setText("select");
                    button.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));

                    TextView textView = new TextView(class_list.this);
                    textView.setText(bname);
                    textView.setTextSize(25);
                    textView.setTextColor(getResources().getColor(R.color.black));
                    textView.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT,1
                    ));

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences.Editor myEdit = sharedPreferences.edit();
                            myEdit.putString("path",bname);
                            myEdit.commit();

                            Intent intent = new Intent(class_list.this,name_list.class);
                            startActivity(intent);
                            //finish();
                        }
                    });

                    horLayout.addView(textView);
                    horLayout.addView(button);

                    layout1.addView(horLayout);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
