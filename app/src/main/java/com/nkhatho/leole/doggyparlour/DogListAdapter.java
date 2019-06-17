package com.nkhatho.leole.doggyparlour;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class DogListAdapter extends ArrayAdapter<Dog> {

    private final Context context;
    private final ArrayList<Dog> list;

    public DogListAdapter(@NonNull Context context, ArrayList<Dog> list)
    {
        super(context, R.layout.dog_row_layout,list);
        this.context = context;
        this.list = list;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflateLayout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflateLayout.inflate(R.layout.dog_row_layout, parent, false);

        ImageView ivDog = (ImageView) rowView.findViewById(R.id.ivDog);
        ImageView ivDogStatus = (ImageView) rowView.findViewById(R.id.ivDogStatus);
        TextView tvDogNameAge = (TextView) rowView.findViewById(R.id.tvDogNameAge);
        TextView tvDogBreed = (TextView) rowView.findViewById(R.id.tvDogBreed);

        ivDog.setImageResource(R.mipmap.huskie);
        tvDogNameAge.setText(list.get(position).getDogName() + " (Age: " + list.get(position).getDogAge() + ")");
        tvDogBreed.setText(list.get(position).getDogBreed());
        ivDogStatus.setImageResource(R.mipmap.done);

        String dogBreed = list.get(position).getDogBreed();
        String dogStatus = list.get(position).getDogStatus();

        ivDogStatus.setImageResource(DogApplicationClass.getDogStatusImage(dogStatus));
        ivDog.setImageResource(DogApplicationClass.getDogBreedImage(dogBreed));


        return rowView;
    }

}
