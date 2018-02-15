package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        TextView attraction = (TextView) findViewById(R.id.attraction);
        attraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent attractionIntent = new Intent(ContentActivity.this, AttractionActivity.class);
                startActivity(attractionIntent);
            }
        });

        TextView historicalSites = (TextView) findViewById(R.id.historical_sites);
        historicalSites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historicalIntent = new Intent(ContentActivity.this, HistoricalActivity.class);
                startActivity(historicalIntent);
            }
        });

        TextView cuisine = (TextView) findViewById(R.id.local_cuisine);
        cuisine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cuisineIntent = new Intent(ContentActivity.this, CuisineActivity.class);
                startActivity(cuisineIntent);
            }
        });

        TextView thingsToDo = (TextView) findViewById(R.id.things_to_do);
        thingsToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thingsToDoIntent = new Intent(ContentActivity.this, ThingsActivity.class);
                startActivity(thingsToDoIntent);
            }
        });
    }
}
