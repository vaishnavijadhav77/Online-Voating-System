package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText t1,t2,t3 ,t4;

    Spinner t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        t1=(EditText)findViewById(R.id.editText4);
        t2=(EditText)findViewById(R.id.editText);
        t3=(EditText)findViewById(R.id.editText2);
        t4=(EditText)findViewById(R.id.editText6);
        t5=(Spinner)findViewById(R.id.spinner);


    }
    public void candidate(View view)
    {String enroll= t3.getText().toString();
        String  mobile= t4.getText().toString();
        registerData db= new registerData(this);
        String res=db.candidate(t1.getText().toString(),t2.getText().toString(),enroll,t5.getSelectedItem().toString(),mobile);
        Toast.makeText(this,res,Toast.LENGTH_LONG).show();
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        Intent i2 =new Intent(register.this,Voating.class);
         startActivity(i2);
    }

}
