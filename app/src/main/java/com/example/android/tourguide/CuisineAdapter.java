package com.example.android.tourguide;

import android.app.Activity;
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

/**
 * Created by ghataks on 11/5/2017.
 */

public class CuisineAdapter extends ArrayAdapter<Place> {

    private int mColorResourceID;
    private final static String BEST_PLACE = "Best Place to try this dish:";

    public CuisineAdapter(Activity context, ArrayList<Place> places, int ColorResourceID) {
        super(context, 0, places);
        mColorResourceID = ColorResourceID;
    }
    //using a View Holder class to hold and reuse views
    static class CuisineViewHolder {
        ImageView holderImageView;
        TextView holderPlaceTextView;
        TextView holderBestPlaceTextView;
        TextView holderDescriptionTextView;
        View holderCuisineContainer;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        CuisineViewHolder cuisineViewHolder;

        View listItemView = convertView;

        if (listItemView == null) {
            cuisineViewHolder = new CuisineViewHolder();
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.cuisine_list, parent, false);
            cuisineViewHolder.holderImageView = listItemView.findViewById(R.id.dish_image_view);
            cuisineViewHolder.holderPlaceTextView = listItemView.findViewById(R.id.dish_name_text_view);
            cuisineViewHolder.holderBestPlaceTextView = listItemView.findViewById(R.id.best_place_text_view);
            cuisineViewHolder.holderDescriptionTextView = listItemView.findViewById(R.id.restaurant_text_view);
            cuisineViewHolder.holderCuisineContainer = listItemView.findViewById(R.id.text_container);
            listItemView.setTag(cuisineViewHolder);
        } else {
            cuisineViewHolder = (CuisineViewHolder) convertView.getTag();
        }
        Place currentPlace = getItem(position);

        cuisineViewHolder.holderImageView.setImageResource(currentPlace.getmResourceImage());

        cuisineViewHolder.holderPlaceTextView.setText(currentPlace.getmNameOfPlace());

        cuisineViewHolder.holderBestPlaceTextView.setText(BEST_PLACE);

        cuisineViewHolder.holderDescriptionTextView.setText(currentPlace.getmDescritption());

        int cuisineColor = ContextCompat.getColor(getContext(), mColorResourceID);
        cuisineViewHolder.holderCuisineContainer.setBackgroundColor(cuisineColor);
        return listItemView;
    }


}
