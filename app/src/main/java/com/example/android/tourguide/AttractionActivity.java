package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class AttractionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.string.attraction_charminar, R.string.description_charminar, R.drawable.charminar, 17.3616, 78.4747));
        places.add(new Place(R.string.attraction_hussain_sagar, R.string.description_hussain_sagar, R.drawable.hussainsagar, 17.4239, 78.4738));
        places.add(new Place(R.string.attraction_falaknuma, R.string.description_falaknuma, R.drawable.falaknuma, 17.3313, 78.4662));
        places.add(new Place(R.string.attraction_golkonda, R.string.description_golkonda, R.drawable.golkonda, 17.3833, 78.4011));
        places.add(new Place(R.string.attraction_ntr, R.string.description_ntr, R.drawable.ntrgardens, 17.4120, 78.4704));

        PlaceAdapter placeAdapter = new PlaceAdapter(this, places, R.color.primaryAttraction, R.color.secondaryAttraction);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(placeAdapter);

    }
}
