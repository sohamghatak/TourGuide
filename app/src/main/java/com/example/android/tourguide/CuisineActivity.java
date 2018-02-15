package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class CuisineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.string.cuisine_name_biriyani, R.string.cuisine_description_biriyani, R.drawable.biriyani));
        places.add(new Place(R.string.cuisine_name_haleem, R.string.cuisine_description_haleem, R.drawable.haleem));
        places.add(new Place(R.string.cuisine_name_meetha, R.string.cuisine_description_meetha, R.drawable.doublekameetha));
        places.add(new Place(R.string.cuisine_name_paya, R.string.cuisine_description_paya, R.drawable.paya));
        places.add(new Place(R.string.cuisine_name_dalcha, R.string.cuisine_description_dalcha, R.drawable.dalcha));

        CuisineAdapter cuisineAdapter = new CuisineAdapter(this, places, R.color.cuisineColor);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(cuisineAdapter);
    }
}
