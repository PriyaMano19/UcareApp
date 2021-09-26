package com.example.ucareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Bookvaccin extends AppCompatActivity {
    EditText name,vacname,phone,age,address,date,time;
    Button getapp;
    private Button button;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookvaccin);
        name=(EditText)findViewById(R.id.ma_vac_apname_2);
        vacname=(EditText)findViewById(R.id.ma_vac_name_2);
        phone=(EditText)findViewById(R.id.ma_vac_phonenum_2);
        age=(EditText)findViewById(R.id.ma_vac_age_2);
        address=(EditText)findViewById(R.id.ma_vac_address_2);
        date=(EditText)findViewById(R.id.ma_vac_date_2);
        time=(EditText)findViewById(R.id.ma_vac_time_2);

        button=(Button)findViewById(R.id.button);
        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.ma_vac_apname_2, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.ma_vac_name_2, RegexTemplate.NOT_EMPTY,R.string.invalid_name_1);
        awesomeValidation.addValidation(this,R.id.ma_vac_age_2, RegexTemplate.NOT_EMPTY,R.string.invalid_name_2);
        awesomeValidation.addValidation(this,R.id.ma_vac_address_2, RegexTemplate.NOT_EMPTY,R.string.invalid_name_2);
        awesomeValidation.addValidation(this,R.id.ma_vac_date_2, RegexTemplate.NOT_EMPTY,R.string.invalid_name_2);
        awesomeValidation.addValidation(this,R.id.ma_vac_time_2, RegexTemplate.NOT_EMPTY,R.string.invalid_name_2);
        awesomeValidation.addValidation(this,R.id.ma_vac_phonenum_2,"[5-9]{1}[0-9]{9}$",R.string.invalid_name_3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Vac_bookinglist.class));
                finish();
            }
        });

        getapp=(Button)findViewById(R.id.ma_next2_2);
        getapp.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processinsert();
            }

        }));
    }
    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("vacname",vacname.getText().toString());
        map.put("phone",phone.getText().toString());
        map.put("age",age.getText().toString());
        map.put("address",address.getText().toString());
        map.put("date",date.getText().toString());
        map.put("time",time.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("VaccinBooking").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        name.setText("");
                        vacname.setText("");
                        phone.setText("");
                        age.setText("");
                        address.setText("");
                        date.setText("");
                        time.setText("");
                        Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Could not insert", Toast.LENGTH_LONG).show();
                    }
                });





    }
}