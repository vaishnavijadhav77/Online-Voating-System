package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class add_candidate extends AppCompatActivity {
    ImageView imageView;
    private static int RESULT_LOAD_IMAGE = 1;
    Spinner spin2;
    EditText e1,e2,e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_candidate);
        e1 = (EditText) findViewById(R.id.editText3);
        e2 = (EditText) findViewById(R.id.editText8);
        e3 = (EditText) findViewById(R.id.editText9);
        spin2 = (Spinner) findViewById(R.id.spinner);
        b1=(Button)findViewById(R.id.button9);

    }

    public void register(View view )
    {
        register_candidate_data db= new register_candidate_data(this);
        vote_database db1=new vote_database(this);
        String res=db.register(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),spin2.getSelectedItem().toString());
        String s="0";
        String res1=db1.result(e2.getText().toString(),s,e1.getText().toString());
        Toast.makeText(this,res+res1,Toast.LENGTH_LONG).show();
        e1.setText("");
        e2.setText("");
        e3.setText("");
        Intent i5 =new Intent(add_candidate.this,AdminMain.class);
        startActivity(i5);
    }
    public void Goto(View v)
    {
        Intent i10=new Intent(add_candidate.this,MainActivity.class);
        startActivity(i10);
    }
}