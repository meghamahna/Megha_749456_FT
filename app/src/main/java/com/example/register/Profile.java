package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    ImageView imageView;
    TextView name_text;
    TextView email_text;
    TextView phone_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = findViewById(R.id.imageView);
        name_text = findViewById(R.id.name);
        email_text = findViewById(R.id.email);
        phone_text = findViewById(R.id.phone);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String email = intent.getExtras().getString("email");
        String phone = intent.getExtras().getString("phone");
        int image = intent.getExtras().getInt("image");

        imageView.setImageResource(image);
        name_text.setText(name);
        phone_text.setText(phone);
        email_text.setText(email);
    }
}
