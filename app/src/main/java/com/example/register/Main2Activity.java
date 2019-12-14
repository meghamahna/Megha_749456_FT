package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    Button btn;
    ArrayList<String> names;
    ArrayList<String> emails;
    ArrayList<String> phones;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView =findViewById(R.id.listView);
        btn = findViewById(R.id.btn);

        Intent intent1 = getIntent();
        names = (ArrayList<String>)intent1.getExtras().getSerializable("names");
        emails = (ArrayList<String>)intent1.getExtras().getSerializable("emails");
        phones = (ArrayList<String>)intent1.getExtras().getSerializable("phones");
        image = intent1.getExtras().getInt("image");

        final DisplayAdapter displayAdapter = new DisplayAdapter(this, names, emails, phones, image);
        listView.setAdapter(displayAdapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this,RegisterUser.class);
                startActivity(intent);



            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent1 = new Intent(Main2Activity.this, Profile.class);
                intent1.putExtra("name", names.get(position));
                intent1.putExtra("email", emails.get(position));
                intent1.putExtra("phone", phones.get(position));
                intent1.putExtra("image", image);
                startActivity(intent1);

            }
        });


    }
}
