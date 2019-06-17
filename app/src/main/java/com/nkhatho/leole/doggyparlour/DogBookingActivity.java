package com.nkhatho.leole.doggyparlour;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class DogBookingActivity extends AppCompatActivity {

    EditText etDogName;
    EditText etDogBreed;
    EditText etDogAge;
    Button btnSubmitBooking;
    Animation shakeAnimation;//for animation
    private LinearLayout quizLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dog_booking_activity);

        etDogName = (EditText) findViewById(R.id.etDogName);
        etDogBreed = (EditText) findViewById(R.id.etDogBreed);
        etDogAge = (EditText) findViewById(R.id.etDogAge);
        btnSubmitBooking = (Button) findViewById(R.id.btnSubmitBooking);

        shakeAnimation = AnimationUtils.loadAnimation(DogBookingActivity.this, R.anim.incorrect_shake);
        shakeAnimation.setRepeatCount(3); // animation repeats 3 times
        
        btnSubmitBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dogName = etDogName.getText().toString().trim();
                String dogBreed = etDogBreed.getText().toString().trim();
                String dogAge = etDogAge.getText().toString().trim();

                if( isEmptyCredentials(dogName, dogBreed, dogAge)){

                    int loopLength = DogApplicationClass.dogBreed.length;

                    for(int x = 0; x < loopLength; ++x){

                        if(DogApplicationClass.dogBreed[x].equals(dogBreed)){

                            DogApplicationClass.list.add(new Dog(dogName, Integer.parseInt(dogAge), dogBreed,
                                    "Booked In", DogApplicationClass.dogBreedInfo[x]));
                            x = 3;
                            Toast.makeText(DogBookingActivity.this, "Dog booking was successful!!!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else if(x + 1 == loopLength){
                            Toast.makeText(DogBookingActivity.this, "Sorry, we don't have " + dogBreed +
                                    " breeds.\nPlease try another.", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else{
                    Toast.makeText(DogBookingActivity.this, "Please enter all fields correctly!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }



    public boolean isEmptyCredentials(String dogName, String dogBreed, String dogAge){

        boolean isNameInvalid = false;
        boolean isBreedInvalid = false;
        boolean isAgeInvalid = false;

        boolean isValid = false;

        if(dogName.equals("")){
            isNameInvalid = true;
        }

        if(dogBreed.equals("")){
            isBreedInvalid = true;
        }


        if(dogAge.equals("")){
            isAgeInvalid = true;
        }


        if(isNameInvalid){
            etDogName.startAnimation(shakeAnimation);
        }

        if(isBreedInvalid){
            etDogBreed.startAnimation(shakeAnimation);
        }

        if(isAgeInvalid){
            etDogAge.startAnimation(shakeAnimation);
        }

        if(isNameInvalid == false && isBreedInvalid == false && isAgeInvalid == false ){

            isValid = true;
        }


        return isValid;
    }
}
