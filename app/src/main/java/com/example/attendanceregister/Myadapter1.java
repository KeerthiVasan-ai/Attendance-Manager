package com.example.attendanceregister;

import android.content.Context;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter1 extends RecyclerView.Adapter<Myadapter1.MyViewHolder> {

    Context context;
    ArrayList<user> list;

    public Myadapter1(Context context, ArrayList<user> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(context).inflate(R.layout.view,parent,false);
        return new MyViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        user User = list.get(position);
        holder.roll.setText(User.getRoll());
        holder.name.setText(User.getName());
        holder.phone.setText(User.getPhone());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        
        TextView roll,name,phone;
        ArrayList<String> s;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            roll = itemView.findViewById(R.id.roll);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);

            itemView.findViewById(R.id.absent).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String to = phone.getText().toString();
                    String message = "Your son/daughter "+name.getText().toString()+" didn't attend the class properly..!!";

                    SmsManager manager = SmsManager.getDefault();
                    manager.sendTextMessage(to,null,message,null,null);
                }
            });

        }
    }
}
