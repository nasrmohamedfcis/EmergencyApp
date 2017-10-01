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
import android.widget.TextView;

public class CallFamily extends AppCompatActivity {

    private myHelper helper;
    private SQLiteDatabase db;
    private TextView tvFamilyMember;
    public String name="", phone="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_family);
        tvFamilyMember = (TextView) findViewById(R.id.tvFamilyMember);
        helper = new myHelper(this);
        db = helper.getWritableDatabase();
    }

    public void callFamily(View view) {
        Cursor pointer = db.query("members",null,null,null,null,null,"id");
        int id=0;
        if(pointer.getCount()==0){
            tvFamilyMember.setText("no family members please add them first");
        }
        else if(pointer.moveToNext()){
            id = pointer.getInt(0);
            name=pointer.getString(1);
            phone = pointer.getString(2);
        }

        Intent out = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phone));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(out);
    }
}
