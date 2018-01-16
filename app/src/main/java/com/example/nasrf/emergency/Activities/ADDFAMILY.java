package com.example.nasrf.emergency.Activities;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nasrf.emergency.R;
import com.example.nasrf.emergency.DataBase.myHelper;

public class ADDFAMILY extends AppCompatActivity {
    private EditText etName , etPhone;
    private myHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfamily);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        helper = new myHelper(this);
        db = helper.getWritableDatabase();
    }

    public void addCont(View view) {
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        ContentValues row = new ContentValues();
        row.put("name",name);
        row.put("number",phone);
        
        long id = db.insert("family_members",null,row);
        
        if(id>0){
            Toast.makeText(this, "Contact Added Succesfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Cant be saved", Toast.LENGTH_SHORT).show(); 
        }
        
        finish();
    }
}
