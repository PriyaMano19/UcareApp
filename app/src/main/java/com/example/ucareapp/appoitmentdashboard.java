package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class appoitmentdashboard extends AppCompatActivity {

    private appoitmentdashboard context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoitmentdashboard);

        context = this;

        Button btn = findViewById(R.id.th_butt1);
        Button btn2 = findViewById(R.id.th_butt2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, commoninterface.class);
                startActivity(intent);

            }


        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Cardview.class);
                startActivity(intent);
            }
        });
    }


}