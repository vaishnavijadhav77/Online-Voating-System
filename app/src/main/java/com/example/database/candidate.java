package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class candidate extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6;
    Button b1,b2,b3;

    SQLiteDatabase SQLITEDATABASE,SQLITEDATABASE1,SQLITEDATABASE2 ;

    String GetSQliteQuery, GetSQliteQuery1,GetSQliteQuery2 ;
    Cursor cursor,cursor1,cursor2 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
        t1=(TextView)findViewById(R.id.textView8);
        t2=(TextView)findViewById(R.id.textView9);
        t3=(TextView)findViewById(R.id.textView10);
        t4=(TextView)findViewById(R.id.textView11);
        t5=(TextView)findViewById(R.id.textView12);

        b1=(Button)findViewById(R.id.button11);
        b2=(Button)findViewById(R.id.button10);
        b3=(Button)findViewById(R.id.button12);

        GetSQliteQuery = "SELECT * FROM add_candidate" ;
        SQLITEDATABASE = openOrCreateDatabase("student1.db", Context.MODE_PRIVATE, null);
        cursor = SQLITEDATABASE.rawQuery(GetSQliteQuery, null);
        cursor.moveToFirst();

        GetSQliteQuery1 = "SELECT * FROM result" ;
        SQLITEDATABASE1 = openOrCreateDatabase("student2.db", Context.MODE_PRIVATE, null);
        cursor1 = SQLITEDATABASE1.rawQuery(GetSQliteQuery1, null);
        cursor1.moveToFirst();
        //SQLITEDATABASE2 = openOrCreateDatabase("student1.db", Context.MODE_PRIVATE, null);

        GetSQLiteDatabaseRecords();
    }
    public void previous(View view)
    { if (!cursor.isFirst()){
        count1();
        cursor.moveToPrevious();
    }
        GetSQLiteDatabaseRecords();


    }
    public void next(View view)
    {
        if (!cursor.isLast()){
            count();
            cursor.moveToNext();
        }

        GetSQLiteDatabaseRecords();

    }

    public void GetSQLiteDatabaseRecords(){

        t2.setText(cursor.getString(0).toString());

        t3.setText(cursor.getString(1).toString());

        t4.setText(cursor.getString(2).toString());

        t5.setText(cursor.getString(3).toString());

    }
    public void count()
    {
        String i1=t1.getText().toString();
        int i2=Integer.parseInt(i1);
        int i3=i2+1;
        String i4= Integer.toString(i3);
        t1.setText(i4);

    }
    public void count1()
    {
        String i1=t1.getText().toString();
        int i2=Integer.parseInt(i1);
        int i3=i2-1;
        String i4= Integer.toString(i3);
        t1.setText(i4);

    }
    public void result(View view)
    { String  symbol=t3.getText().toString();
        String  name=t3.getText().toString();
        String i1=t1.getText().toString();
        int i2=Integer.parseInt(i1);
        int i=1;

        do
        {String sym=cursor1.getString(0).toString();
            i=i+1;
            if(symbol.equals(sym))
            {String s=cursor1.getString(1).toString();
                String name1=cursor1.getString(2).toString();
                int i4=Integer.parseInt(s);
                int i5=i4+1;
                String i6= Integer.toString(i5);
                vote_database db=new vote_database(this);
                db.alldata();
                db.update(sym,i6,name1);

                Toast.makeText(getApplicationContext(),"vote is done successfully",Toast.LENGTH_SHORT).show();
                break;}
            else{

                cursor1.moveToNext();}
        }while(i<=i2);

        cursor1.moveToFirst();

    }
    public void Goto(View v)
    {
        Intent i10=new Intent(candidate.this,MainActivity.class);
        startActivity(i10);
    }
}