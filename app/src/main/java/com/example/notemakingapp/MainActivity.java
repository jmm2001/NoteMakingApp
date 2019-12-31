package com.example.notemakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button add1;
    ListView lv1;
    int n1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add1 = findViewById(R.id.add);
        lv1 = findViewById(R.id.lv);


        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,edit.class);
                startActivity(intent);

            }
        });
        String input1 = getIntent().getStringExtra("title");
       final  String ta [] = {input1};
        String input2 = getIntent().getStringExtra("note");
        final String na [] = {input2};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, ta);
        lv1.setAdapter(arrayAdapter);

        lv1.setOnItemClickListener(listClick);





        Intent i3 = new Intent(getApplicationContext(),MainActivity.class);
        i3.putExtra("title1", ta[n1]);
        i3.putExtra("note1", na[n1]);
        startActivity(i3);




    }
    AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener () {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            String itemValue = (String) lv1.getItemAtPosition( position );
            n1= Integer.parseInt(itemValue);



        }

    };
}
