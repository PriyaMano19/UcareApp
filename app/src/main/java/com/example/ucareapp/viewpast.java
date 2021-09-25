package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class viewpast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpast);

        Button btn_view = findViewById(R.id.viewbtn);
        btn_view.setOnClickListener(v ->
        {
            Intent intent = new Intent(viewpast.this,rvactivity.class);
            startActivity(intent);
        });
    }
}