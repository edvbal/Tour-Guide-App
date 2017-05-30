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
public class AccommodationFragment extends Fragment {

    private ArrayList<Place> places = new ArrayList<>();
    private ListView listView;
    private PlaceAdapter placeAdapter;

    public AccommodationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list,container,false);
        if (places.size() == 0){
            places.add(new Place(getString(R.string.park_inn_kaunas),
                    getString(R.string.park_inn_kaunas_desc),
                    R.drawable.park_inn_thumbn, R.drawable.park_inn,
                    getString(R.string.park_inn_kaunas_address)));
            places.add(new Place(getString(R.string.kaunas_hotel),
                    getString(R.string.kaunas_hotel_desc),
                    R.drawable.kaunas_hotel_thumbn, R.drawable.kaunas_hotel,
                    getString(R.string.kaunas_hotel_address)));
            places.add(new Place(getString(R.string.europa_royale_hotel),
                    getString(R.string.europa_royale_hotel_desc),
                    R.drawable.europa_royale_thumbn, R.drawable.europa_royale,
                    getString(R.string.europa_royale_hotel_address)));
            places.add(new Place(getString(R.string.santaka_hotel),
                    getString(R.string.santaka_hotel_desc),
                    R.drawable.santaka_hotel_thumbn, R.drawable.santaka_hotel,
                    getString(R.string.santaka_hotel_address)));
        }

        listView = (ListView) rootView.findViewById(R.id.list);

        placeAdapter = new PlaceAdapter(getActivity(), places);

        listView.setAdapter(placeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlaceInfoActivity.class);
                intent.putExtra("picture",placeAdapter.getItem(position).getPicture());
                intent.putExtra("name",placeAdapter.getItem(position).getName());
                intent.putExtra("description",placeAdapter.getItem(position).getDescription());
                intent.putExtra("address",placeAdapter.getItem(position).getAddress());
                startActivity(intent);
            }
        });

        return rootView;
    }

}
