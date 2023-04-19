package com.example.attendanceregister;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminClass extends AppCompatActivity {


    ImageButton insert;
    AlertDialog dialog;
    LinearLayout layout;
    DatabaseReference reference;
    FirebaseDatabase database;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_class);

        insert = findViewById(R.id.insert);
        layout = findViewById(R.id.recycle1);
        sharedPreferences = getSharedPreferences("mypref",MODE_PRIVATE);

        buildDialog();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();
            }
        });
    }

    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialogue,null);


        EditText class_name = view.findViewById(R.id.admineditclass);
        builder.setView(view);
        builder.setTitle("Enter the Class Name")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String key = class_name.getText().toString();
                        String value = class_name.getText().toString();
                        if(!value.isEmpty()) {
                            reference = FirebaseDatabase.getInstance().getReference();
                            DatabaseReference bref = reference.child("Department").child(key);
                            bref.setValue(value);
                        } else {
                            class_name.setError("Class Name Cannot be Empty");
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        dialog = builder.create();


        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Department");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                layout.removeAllViews();

                for (DataSnapshot branch : snapshot.getChildren()){
                    String b = branch.getKey();
                    String bname = branch.getValue(String.class);

                    LinearLayout horLayout = new LinearLayout(AdminClass.this);
                    horLayout.setOrientation(LinearLayout.HORIZONTAL);

                    Button button = new Button(AdminClass.this);
                    button.setText("select");
                    button.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));

                    TextView textView = new TextView(AdminClass.this);
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
                            myEdit.putString("adminpath",bname);
                            myEdit.commit();

                            Intent intent = new Intent(AdminClass.this,AdminName.class);
                            startActivity(intent);
                            //finish();
                        }
                    });
                    
                    horLayout.addView(textView);
                    horLayout.addView(button);

                    layout.addView(horLayout);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}