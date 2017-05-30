package com.example.android.project6.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.project6.Place;
import com.example.android.project6.PlaceAdapter;
import com.example.android.project6.PlaceInfoActivity;
import com.example.android.project6.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoFragment extends Fragment {
    private ArrayList<Place> places = new ArrayList<>();
    private ListView listView;
    private PlaceAdapter placeAdapter;

    public ToDoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        if(places.size() == 0){
            places.add(new Place(getString(R.string.republic_bar),
                    getString(R.string.republic_bar_desc),
                    R.drawable.republic_bar_thumbn, R.drawable.republic_bar,
                    getString(R.string.republic_bar_address)));
            places.add(new Place(getString(R.string.sauleja_spa),
                    getString(R.string.sauleja_spa_desc),
                    R.drawable.sauleja_spa_thumbn, R.drawable.sauleja_spa,
                    getString(R.string.sauleja_spa_address)));
            places.add(new Place(getString(R.string.lokes_peda_park),
                    getString(R.string.lokes_peda_park_desc),
                    R.drawable.lokes_peda_thumbn, R.drawable.lokes_peda,
                    getString(R.string.lokes_peda_park_address)));
            places.add(new Place(getString(R.string.kaunas_areo_club),
                    getString(R.string.kaunas_areo_club_desc),
                    R.drawable.kaunas_aeroclub_thumbn, R.drawable.kaunas_aeroclub,
                    getString(R.string.kaunas_areo_club_address)));
            places.add(new Place(getString(R.string.break_free_room),
                    getString(R.string.break_free_room_desc),
                    R.drawable.break_free_thumbn, R.drawable.break_free,
                    getString(R.string.break_free_room_address)));
        }

        listView = (ListView) rootView.findViewById(R.id.list);

        placeAdapter = new PlaceAdapter(getActivity(), places);

        listView.setAdapter(placeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlaceInfoActivity.class);
                intent.putExtra("picture", placeAdapter.getItem(position).getPicture());
                intent.putExtra("name", placeAdapter.getItem(position).getName());
                intent.putExtra("description", placeAdapter.getItem(position).getDescription());
                intent.putExtra("address", placeAdapter.getItem(position).getAddress());
                startActivity(intent);
            }
        });


        return rootView;
    }

}
