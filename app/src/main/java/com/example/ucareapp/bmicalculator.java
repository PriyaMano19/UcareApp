package com.example.ucareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class bmicalculator extends AppCompatActivity {
    EditText weight, height;
    TextView resulttext;
    String calculation, BMIresult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        weight = findViewById(R.id.weighttxt);
        height = findViewById(R.id.heighttxt);
        resulttext = findViewById(R.id.view1);


    }

    public void calculateBMI(View view) {
        String s1 = weight.getText().toString();
        String s2 = height.getText().toString();

        float weightvalue = Float.parseFloat(s1);
        float heightvalue = Float.parseFloat(s2) / 100;

        float bmi = weightvalue / (heightvalue * weightvalue);

        if(bmi < 16) {
            BMIresult = "Severely Under Weight";
        }else if(bmi < 18.5){
            BMIresult = "Under Weight";
        }else if(bmi < 18.5 && bmi <= 24.9){
            BMIresult = "Normal Weight";
        }else if(bmi < 25 && bmi <= 29.9){
            BMIresult = "Over Weight";
        }else{
            BMIresult = "Obese";
        }

        calculation = "Result:\n" + bmi +  "\n" + BMIresult;
        resulttext.setText(calculation);



    }
}