package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list);

        ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.string.historical_charminar, R.string.description_historical_charminar, R.drawable.charminar_historical, 17.3616, 78.4747));
        places.add(new Place(R.string.historical_golkonda, R.string.description_historical_golkonda, R.drawable.golkonda_historical, 17.3833, 78.4011));
        places.add(new Place(R.string.historical_chowmahalla, R.string.description_historical_chowmahalla, R.drawable.chowmahalla, 17.3578, 78.4717));
        places.add(new Place(R.string.historical_mecca, R.string.description_historical_mecca, R.drawable.mecca_masjid, 17.3604, 78.4736));

        PlaceAdapter placeAdapter = new PlaceAdapter(this, places, R.color.primaryHistorical, R.color.secondaryHistorical);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(placeAdapter);

    }
}
