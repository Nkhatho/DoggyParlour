package com.nkhatho.leole.doggyparlour;

import android.app.Application;
import android.widget.ImageView;

import java.util.ArrayList;

public class DogApplicationClass extends Application {

    public static ArrayList<Dog> list;
    public static String[] dogBreedInfo;
    public static String[] dogBreed;

    private String[] dogNames;
    private int[] dogAges;
    private String[] dogStatus;



    @Override
    public void onCreate() {
        super.onCreate();

        list = new ArrayList<>();
        dogNames = getResources().getStringArray(R.array.names);
        dogAges = getResources().getIntArray(R.array.age);
        dogBreed = getResources().getStringArray(R.array.breed);
        dogStatus = getResources().getStringArray(R.array.status);
        dogBreedInfo = getResources().getStringArray(R.array.breed_info);

        for(int x = 0; x < dogNames.length; ++x){

            list.add(new Dog(dogNames[x], dogAges[x], dogBreed[x], dogStatus[x], dogBreedInfo[x]));
        }
    }

    public static int getDogStatusImage(String dogStatus){

        int dogStatusImage = R.mipmap.booked;

        if(dogStatus.equals("Booked In")){
            dogStatusImage = R.mipmap.booked;
        }
        else if(dogStatus.equals("Done")){
            dogStatusImage = R.mipmap.done;
        }
        else if(dogStatus.equals("Busy")){
            dogStatusImage = R.mipmap.busy;
        }

        return dogStatusImage;
    }

    public static int getDogBreedImage(String dogBreed){

        int dogBreedImage = R.mipmap.labrador;

        if(dogBreed.equals("Golden Retriever")){
            dogBreedImage =R.mipmap.golden_retriever;
        }
        else if(dogBreed.equals("Labrador")){
            dogBreedImage = R.mipmap.labrador;
        }
        else if(dogBreed.equals("Spaniel")){
            dogBreedImage = R.mipmap.spaniel;
        }
        else if(dogBreed.equals("Huskie")){
            dogBreedImage = R.mipmap.huskie;
        }

        return dogBreedImage;
    }
}
