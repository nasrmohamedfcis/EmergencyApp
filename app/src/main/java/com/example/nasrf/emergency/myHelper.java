package com.example.nasrf.emergency;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nasrf on 1/10/2017.
 */

public class myHelper extends SQLiteOpenHelper {


    public myHelper(Context context) {
        super(context,"family_members", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table family_members(id integer primary key autoincrement, name text, number text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table family_members");
        onCreate(db);
    }
}
