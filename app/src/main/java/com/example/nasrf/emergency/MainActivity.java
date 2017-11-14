package com.example.nasrf.emergency;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private myHelper helper;
    private SQLiteDatabase db;
    private boolean familyAdded=false;
    private int icount;

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
        Intent in = new Intent(this,CallFamily.class);
        startActivity(in);
    }
}
