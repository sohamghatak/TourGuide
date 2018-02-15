package com.example.android.tourguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by ghataks on 11/4/2017.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {
    private int mPrimaryColorResourceID;
    private int mSecondaryColorResourceID;

    //using a View Holder class to hold and reuse views
    static class ViewHolder {
        ImageView holderImageView;
        TextView holderPlaceTextView;
        TextView holderDescriptionTextView;
        TextView holderLocationButton;
        View holderPrimaryTextContainer;
        View holderSecondaryTextContainer;
    }

    public PlaceAdapter(Activity context, ArrayList<Place> places, int primaryColorResourceID) {
        super(context, 0, places);
        mPrimaryColorResourceID = primaryColorResourceID;
    }

    public PlaceAdapter(Activity context, ArrayList<Place> places, int primaryColorResourceID, int secondaryColorResourceID) {
        super(context, 0, places);
        mPrimaryColorResourceID = primaryColorResourceID;
        mSecondaryColorResourceID = secondaryColorResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.holderImageView = listItemView.findViewById(R.id.attraction_image_view);
            viewHolder.holderPlaceTextView = listItemView.findViewById(R.id.place_text_view);
            viewHolder.holderDescriptionTextView = listItemView.findViewById(R.id.description_text_view);
            viewHolder.holderLocationButton = listItemView.findViewById(R.id.location_button);
            viewHolder.holderPrimaryTextContainer = listItemView.findViewById(R.id.place_text_view);
            viewHolder.holderSecondaryTextContainer = listItemView.findViewById(R.id.description_text_view);
            listItemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Place currentPlace = getItem(position);

        viewHolder.holderImageView.setImageResource(currentPlace.getmResourceImage());

        viewHolder.holderPlaceTextView.setText(currentPlace.getmNameOfPlace());

        viewHolder.holderDescriptionTextView.setText(currentPlace.getmDescritption());

        //Start a Google Maps intent with the latitude and longitude values
        double mLatitude = currentPlace.getResourceLatitude();
        double mLongitude = currentPlace.getResourceLongitude();

        final String uri = String.format(Locale.ENGLISH, "geo:%f,%f", mLatitude, mLongitude);

        viewHolder.holderLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));

                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                    getContext().startActivity(intent);
                }
            }
        });

        //Set the background color for the primary and secondary text view in the list_item xml layout
        int primaryColor = ContextCompat.getColor(getContext(), mPrimaryColorResourceID);
        int secondaryColor = ContextCompat.getColor(getContext(), mSecondaryColorResourceID);
        viewHolder.holderPrimaryTextContainer.setBackgroundColor(primaryColor);
        viewHolder.holderSecondaryTextContainer.setBackgroundColor(secondaryColor);

        return listItemView;
    }
}
