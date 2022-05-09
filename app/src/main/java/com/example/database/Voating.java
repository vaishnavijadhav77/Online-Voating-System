package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Voating extends AppCompatActivity {
    EditText e1,e2;
    int counter=3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voating);
        e1=(EditText)findViewById(R.id.editText5);
        e2=(EditText)findViewById(R.id.editText7);
        b1=(Button)findViewById(R.id.button7);
    }
    public void reg(View view)
    {
        Intent i8=new Intent(Voating.this,register.class);
        startActivity(i8);
    }
    public void log(View view)
    {  registerData db= new registerData(this);
        String uname=e1.getText().toString();
        String password=e2.getText().toString();
        Boolean check=db.log(uname,password);

        if(check==true)
        {e1.setText("");
            e2.setText("");

            Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_LONG).show();
            Intent i10=new Intent(Voating.this,candidate.class);
            startActivity(i10);
        }
        else
        {
            counter--;
            if(counter==0)
            {
                b1.setEnabled(false);
            }
            String s=counter+"  Chance remaining";
            if(e1.getText().toString().equals(""))
            {
                Toast.makeText(getApplicationContext(), "Enter Username "+s, Toast.LENGTH_LONG).show();
            }else if(e2.getText().toString().equals(""))
            {
                Toast.makeText(getApplicationContext(), "Enter Password "+s, Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(getApplicationContext(), "Incorrect username or password  "+s , Toast.LENGTH_LONG).show();
            }
           // Toast.makeText(getApplicationContext(),"Wrong  Or Password"+ s,Toast.LENGTH_LONG).show();
        }

    }

}
