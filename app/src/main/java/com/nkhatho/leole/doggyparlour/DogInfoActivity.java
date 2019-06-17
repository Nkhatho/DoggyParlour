package com.nkhatho.leole.doggyparlour;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DogInfoActivity extends AppCompatActivity implements DogListFragment.onDogClickedListener {

    TextView tvDogDetail;
    ImageView ivDogStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dog_info_activity);

        tvDogDetail = (TextView) findViewById(R.id.tvDogDetail);
        ivDogStatus = (ImageView) findViewById(R.id.ivDogStatuss);
    }

    @Override
    public void onDogSelected(int index) {

        String dogBreedInfo = DogApplicationClass.list.get(index).getDogBreedInfo();
        String dogStatus = DogApplicationClass.list.get(index).getDogStatus();

        tvDogDetail.setText(dogBreedInfo);

        ivDogStatus.setImageResource(DogApplicationClass.getDogStatusImage(dogStatus));


    }

}
