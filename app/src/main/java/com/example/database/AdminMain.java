package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
    }

    public void add_candidate(View view)
    {
        Intent i =new Intent(AdminMain.this,add_candidate.class);
        startActivity(i);
    }
    public void add(View view)
    {
        Intent i =new Intent(AdminMain.this,result.class);
       startActivity(i);
    }
    public void Goto(View v)
    {
        Intent i10=new Intent(AdminMain.this,MainActivity.class);
        startActivity(i10);
    }
}