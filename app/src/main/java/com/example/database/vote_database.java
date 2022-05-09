package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class vote_database extends SQLiteOpenHelper
{  private static final String dbname = "student2.db";

    public vote_database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table result( symbol text primary key ,vote text,name text)";


        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS result");

        onCreate(db);

    }

    public String result(String i1,String i2,String i3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("symbol", i1);
        cv.put("vote", i2);
        cv.put("name", i3);

        long res = db.insert("result", null, cv);

        if (res == -1) {
            return "failed";
        } else {
            return "successfully voat count inserted";
        }

    }
    public Cursor alldata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from result",null);
        return cursor;
    }
    public  Boolean update(String s1,String s2,String s3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("symbol", s1);
        cv.put("vote", s2);
        cv.put("name", s3);
        db.update("result",cv,"symbol=?",new String[]{s1});
        return  true;
    }




}

