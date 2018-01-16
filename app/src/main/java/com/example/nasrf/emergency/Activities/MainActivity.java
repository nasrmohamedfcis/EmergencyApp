package com.example.nasrf.emergency.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nasrf.emergency.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addFamily(View view) {
        Intent in = new Intent(MainActivity.this, ADDFAMILY.class);
        startActivity(in);
    }

    public void callEmergency(View view) {
        Intent in = new Intent(MainActivity.this, CallEmergency.class);
        startActivity(in);
    }

    public void callFamily(View view) {
        Intent in = new Intent(MainActivity.this,CallFamilyMember.class);
        startActivity(in);
    }
}
