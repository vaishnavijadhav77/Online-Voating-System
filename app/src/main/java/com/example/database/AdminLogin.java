package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    EditText t1, t2;
    Button b1;
    int counter =3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        t1=(EditText)findViewById(R.id.editText5);
        t2=(EditText)findViewById(R.id.editText7);
        b1=(Button)findViewById(R.id.button7);


    }


    //method for go main page of add candidate and report
    public void admain(View view) {
        if (t1.getText().toString().equals("admin") && t2.getText().toString().equals("admin") ) {
            Toast.makeText(getApplicationContext(), "Login SuccessFully", Toast.LENGTH_LONG).show();

            Intent i10 = new Intent(AdminLogin.this, AdminMain.class);
            startActivity(i10);
            t1.setText("");
            t2.setText("");
        } else {
            counter--;
            String s=counter  +"  Chance remaining";
            if(counter==0)
            {
                b1.setEnabled(false);
            }
            if(t1.getText().toString().equals(""))
            {
                Toast.makeText(getApplicationContext(), "Enter Username "+s, Toast.LENGTH_LONG).show();
            }else if(t2.getText().toString().equals(""))
            {
                Toast.makeText(getApplicationContext(), "Enter Password "+s, Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(getApplicationContext(), "Incorrect username or password  "+s , Toast.LENGTH_LONG).show();
            }

           // Toast.makeText(getApplicationContext(), "Incorrect username or password " +s, Toast.LENGTH_LONG).show();
            t1.setText("");
            t2.setText("");
        }
    }
}