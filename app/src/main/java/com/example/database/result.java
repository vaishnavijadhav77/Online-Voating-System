package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView t1,t2,t3;
    Button b1,b2;

    SQLiteDatabase SQLITEDATABASE1 ;

    String GetSQliteQuery1 ;
    Cursor cursor1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1=(TextView)findViewById(R.id.textView25);
        t2=(TextView)findViewById(R.id.textView26);
        t3=(TextView)findViewById(R.id.textView29);
        GetSQliteQuery1 = "SELECT * FROM result" ;
        SQLITEDATABASE1 = openOrCreateDatabase("student2.db", Context.MODE_PRIVATE, null);
        cursor1 = SQLITEDATABASE1.rawQuery(GetSQliteQuery1, null);
        cursor1.moveToFirst();
        GetSQLiteDatabaseRecords();
    }
    public void previous(View view)
    { if (!cursor1.isFirst()){

        cursor1.moveToPrevious();
    }
        GetSQLiteDatabaseRecords();


    }
    public void next(View view)
    {
        if (!cursor1.isLast()){

            cursor1.moveToNext();
        }

        GetSQLiteDatabaseRecords();

    }

    public void GetSQLiteDatabaseRecords(){

        t2.setText(cursor1.getString(0).toString());

        t3.setText(cursor1.getString(1).toString());

        t1.setText(cursor1.getString(2).toString());



    }

    public void Goto(View v)
    {
        Intent i10=new Intent(result.this,MainActivity.class);
        startActivity(i10);
    }
}