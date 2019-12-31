package com.example.notemakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class edit extends AppCompatActivity {
    EditText title1  , note1 ;
    Button save1 , delete1;
    String t4 , n4 , def="add new notes";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        title1 = findViewById(R.id.title);
        note1 = findViewById(R.id.note);
        save1 = findViewById(R.id.save);
        delete1 = findViewById(R.id.delete);

        if((title1.getText().toString()).length()==0)
            title1.setText(def);

        if((note1.getText().toString()).length()==0)
            note1.setText(def);






        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"saved successfully",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("title", title1.getText().toString());
                i.putExtra("note", note1.getText().toString());
                startActivity(i);



            }
        });
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });

        t4 = getIntent().getStringExtra("title1");
        n4 = getIntent().getStringExtra("note1");

        title1.setText(t4);
        note1.setText(n4);

    }
}
