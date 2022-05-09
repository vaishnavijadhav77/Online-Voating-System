package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void vote123(View view)
    {
        Intent i5 =new Intent(MainActivity.this,Voating.class);
        startActivity(i5);
    }

    //method for admin login button on main page
    public void adlog(View view)
    {
        Intent i5 =new Intent(MainActivity.this,AdminLogin.class);
        startActivity(i5);
    }
    public void go(View v)
    {
        Intent i5 =new Intent(MainActivity.this,result.class);
        startActivity(i5);
    }
}
