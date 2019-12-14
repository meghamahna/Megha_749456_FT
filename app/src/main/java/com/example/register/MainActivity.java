package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btn;
    ArrayList<String> names;
    ArrayList<String> emails;
    ArrayList<String> phones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.listView);
        btn = findViewById(R.id.btn);

//
//        DisplayAdapter displayAdapter = new DisplayAdapter(this, names, emails, phones);
//        listView.setAdapter(displayAdapter);
//


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,RegisterUser.class);
                startActivity(intent);



            }
        });



    }
}
