package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class RegisterUser extends AppCompatActivity {

    EditText name;
    EditText phone;
    EditText email;
    Button save;
    int[] imageIcons;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        imageIcons = new int[]{R.drawable.icon01_01, R.drawable.icon01_02, R.drawable.icon01_03, R.drawable.icon01_04,
                R.drawable.icon01_05, R.drawable.icon01_06, R.drawable.icon01_07, R.drawable.icon01_08,
                R.drawable.icon01_09, R.drawable.icon01_10};

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        save = findViewById(R.id.save_button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty() && !phone.getText().toString().isEmpty() && !email.getText().toString().isEmpty()) {

                    image = getRandom(imageIcons);
                    Intent intent = new Intent(RegisterUser.this, VerifyUser.class);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("phone", phone.getText().toString());
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("image", image);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterUser.this, "you should fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
