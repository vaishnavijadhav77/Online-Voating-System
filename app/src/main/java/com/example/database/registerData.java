package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class registerData extends SQLiteOpenHelper {
    private static final String dbname = "student.db";

    public registerData(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table register(name text, password text,enroll text primary key not null  ,branch text,mobile text)";


        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS register");

        onCreate(db);

    }

    public String candidate(String p1, String p2, String p3, String p4, String p5) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", p1);
        cv.put("password", p2);
        cv.put("enroll", p3);
        cv.put("branch", p4);
        cv.put("mobile", p5);
        long res = db.insert("register", null, cv);
        if (res == -1) {
            return "failed";
        } else {
            return "successfully data inserted";
        }

    }



    public Boolean log(String uname, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select  * from register where name=? and password=?", new String[]{uname, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;


    }



}
