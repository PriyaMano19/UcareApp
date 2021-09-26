package com.example.ucareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class test_form extends AppCompatActivity {
    EditText co_name,co_phone,co_address,co_date,co_time;
    Button co_getapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_form);
        co_name = (EditText) findViewById(R.id.ma_co_firstName2_3);
        co_phone = (EditText) findViewById(R.id.ma_co_firstName3_3);
        co_address = (EditText) findViewById(R.id.ma_co_firstName5_3);
        co_date = (EditText) findViewById(R.id.ma_co_firstName6_3);
        co_time = (EditText) findViewById(R.id.ma_co_firstName7_3);

        co_getapp = (Button) findViewById(R.id.ma_next2_2);
        co_getapp.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processinsert();
            }
        }));
    }
    private void processinsert(){
        Map<String,Object> map=new HashMap<>();
        map.put("co_name",co_name.getText().toString());
        map.put("co_phone",co_phone.getText().toString());
        map.put("co_address",co_address.getText().toString());
        map.put("co_date",co_date.getText().toString());
        map.put("co_time",co_time.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("CovidTestBooking").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        co_name.setText("");
                        co_phone.setText("");
                        co_address.setText("");
                        co_date.setText("");
                        co_time.setText("");
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