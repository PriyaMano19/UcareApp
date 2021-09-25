package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ma_dash extends AppCompatActivity {
    private ImageButton ma_button1;
    private ImageButton ma_button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_dash);
        ma_button1=(ImageButton)findViewById(R.id.imageButton4_3);
        ma_button2=(ImageButton)findViewById(R.id.imageButton3_3);
        ma_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });
        ma_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openActivity3();

            }
        });

    }
    public void openActivity2(){
        Intent intent =new Intent(this,test_form.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent =new Intent(this,mathy_dash.class);
        startActivity(intent);
    }
}