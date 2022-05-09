package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class register_candidate_data extends SQLiteOpenHelper {
    private static final String dbname = "student1.db";

    public register_candidate_data(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db1) {

        String qry1 = "create table add_candidate(name text, symbol text not null primary key,motive text,branch text)";
        db1.execSQL(qry1);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {


        db1.execSQL("DROP TABLE IF EXISTS add_candidate");
        onCreate(db1);


    }


    public String register(String s1, String s2, String s3, String s4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", s1);
        cv.put("symbol", s2);
        cv.put("motive", s3);
        cv.put("branch", s4);

        long res = db.insert("add_candidate", null, cv);
        if (res == -1) {
            return "failed";
        } else {
            return "successfully data inserted";
        }
    }
}
