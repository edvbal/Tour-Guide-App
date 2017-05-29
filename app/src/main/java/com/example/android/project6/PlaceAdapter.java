package com.example.android.project6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Edvinas on 28/05/2017.
 */

public class PlaceAdapter extends ArrayAdapter<Place>{
    Place place;

    public PlaceAdapter(Context context, ArrayList<Place> place) {
        super(context,0,place);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout,parent,false);

        place = getItem(position);

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        TextView name = (TextView) listItemView.findViewById(R.id.text);

        image.setImageResource(place.getThumbnail());
        name.setText(place.getName());

        return listItemView;
    }
}
