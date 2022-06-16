package com.memuar.myapplicationfour;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;



public class OtherPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String subject = sp.getString("subject","");
        String prof = sp.getString("prof","");
        String cab = sp.getString("cab","");
        String timer = sp.getString("timer","");


    }
}
