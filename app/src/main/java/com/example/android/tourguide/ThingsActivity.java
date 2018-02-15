package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ThingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.things_to_do_ramoji, R.string.ramoji_description, R.drawable.ramoji, 17.2543, 78.6808));
        places.add(new Place(R.string.things_to_do_salarjung, R.string.salarjung_description, R.drawable.salarjung, 17.3715, 78.4804));
        places.add(new Place(R.string.things_to_do_birla_mandir, R.string.birla_mandir_description, R.drawable.birlamandir, 17.4062, 78.4691));
        places.add(new Place(R.string.things_to_do_lumbinipark, R.string.lumbinipark_description, R.drawable.lumbini, 17.4101, 78.4732));

        PlaceAdapter placeAdapter = new PlaceAdapter(this, places, R.color.primaryThingsToDo, R.color.secondaryThingsToDo);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(placeAdapter);
    }
}
