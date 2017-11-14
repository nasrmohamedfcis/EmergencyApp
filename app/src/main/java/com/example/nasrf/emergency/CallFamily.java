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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CallFamily extends AppCompatActivity {

    private myHelper helper;
    private SQLiteDatabase db;
    private TextView tvFamilyMember;
    private Button btnCall;
    private List<Family> membersToCall;
    private ListView lv_family;
    public FamilyList familyList;
    public String name="", phone="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_family);
        tvFamilyMember = (TextView) findViewById(R.id.tvFamilyMember);
        btnCall = (Button) findViewById(R.id.btn_call_family);
        helper = new myHelper(this);
        db = helper.getWritableDatabase();

        lv_family = (ListView) findViewById(R.id.lv_family);
        membersToCall = new ArrayList<>();
        show();
    }

    private void show() {
        helper = new myHelper(getApplicationContext());
        db = helper.getWritableDatabase();
        Cursor pointer = db.query("family_members",null,null,null,null,null,"id");
        String name="";

        while(pointer.moveToNext()){
            name = pointer.getString(1);
            //tvFamilyMember.setText(name);
            membersToCall.add(new Family(name));
        }
        familyList = new FamilyList(membersToCall,getApplicationContext());
        lv_family.setAdapter(familyList);


    }


    public void callFamily(View view) {
        Cursor pointer = db.query("family_members",null,null,null,null,null,"id");
        int id=lv_family.getId();
        if(pointer.getCount()==0){
            tvFamilyMember.setText("no family members please add them first");
        }
        else if(pointer.moveToPosition(id)){
            name = pointer.getString(0);
            phone = pointer.getString(1);
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
