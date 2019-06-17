package com.nkhatho.leole.doggyparlour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSeeAllDogs;
    Button btnBookADog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnSeeAllDogs = (Button) findViewById(R.id.btnSeeAllDogs);
        btnBookADog = (Button) findViewById(R.id.btnBookADog);

        btnSeeAllDogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent dogInfoFragments = new Intent(MainActivity.this,com.nkhatho.leole.doggyparlour.DogInfoActivity.class);
                startActivity(dogInfoFragments);

            }
        });

        btnBookADog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bookADog = new Intent(MainActivity.this,com.nkhatho.leole.doggyparlour.DogBookingActivity.class);
                startActivity(bookADog);
            }
        });
    }


}
