package com.example.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class VerifyUser extends AppCompatActivity {

    GridView gridView;
    ImageView refresh;
    int[] images;
    ArrayList<Integer> match;
    ArrayList<Integer> checked;
    int check = 0;
    int temp = 0;
    Button verify;
    CheckBox checkBox;
    ArrayList<String> names;
    ArrayList<String> emails;
    ArrayList<String> phones;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_user);

        verify = findViewById(R.id.verify_btn);
        gridView = findViewById(R.id.gridView);
        images = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
                R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9};

        checked = new ArrayList<>();
        match = new ArrayList<>();
        match.add(2131099746);
        match.add(2131099747);
        match.add(2131099748);
        match.add(2131099749);

        refresh = findViewById(R.id.refresh);
        checkBox = findViewById(R.id.checkbox);

        names = new ArrayList<>();
        emails = new ArrayList<>();
        phones = new ArrayList<>();


        shuffleImages();

        final IconAdapter iconAdapter = new IconAdapter(this, images);
        gridView.setAdapter(iconAdapter);



        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shuffleImages();
                iconAdapter.notifyDataSetChanged();
            }
        });


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    check = 1;
                }
                else{
                    check = 0;
                }
            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.checked);
                imageView.setBackgroundResource(R.drawable.img1);
                imageView.animate().alpha(.5f);

               // Toast.makeText(VerifyUser.this, "" + images[position], Toast.LENGTH_SHORT).show();

                checked.add((Integer)iconAdapter.getItem(position));
                Collections.sort(match);
                Collections.sort(checked);

                if(match.equals(checked)){

                    Toast.makeText(VerifyUser.this, "verified", Toast.LENGTH_SHORT).show();
                    temp = 1;

                }

            }
        });
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(temp == 0 || check == 0){

                    AlertDialog.Builder builder = new AlertDialog.Builder(VerifyUser.this);
                    builder.setMessage("Not Verified")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    Intent intent = new Intent(VerifyUser.this, Main2Activity.class);
                                    intent.putExtra("names", names);
                                    intent.putExtra("emails", emails);
                                    intent.putExtra("phones", phones);
                                    intent.putExtra("image", image);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(temp == 1 && check == 1){


                    AlertDialog.Builder builder = new AlertDialog.Builder(VerifyUser.this);
                    builder.setMessage("Verified")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    Intent intent = getIntent();
                                    String name = intent.getExtras().getString("name");
                                    String email = intent.getExtras().getString("email");
                                    String phone = intent.getExtras().getString("phone");
                                    image = intent.getExtras().getInt("image");
                                    names.add(name);
                                    emails.add(email);
                                    phones.add(phone);
                                    Intent intent1 = new Intent(VerifyUser.this, Main2Activity.class);
                                    intent1.putExtra("names", names);
                                    intent1.putExtra("emails", emails);
                                    intent1.putExtra("phones", phones);
                                    intent1.putExtra("image", image);
                                    startActivity(intent1);


                                }
                            });

                    AlertDialog alert = builder.create();
                    alert.show();

                }


            }
        });


    }

    public void shuffleImages() {
        //Collections.shuffle(Arrays.asList(images));

        Random rnd = new Random();

        for (int i = 0; i < images.length; i++) {

            int index = rnd.nextInt(i + 1);
            // Simple swap
            int temp = images[index];
            images[index] = images[i];
            images[i] = temp;
        }


    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//    }
}

