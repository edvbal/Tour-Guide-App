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
public class EatAndDrinkFragment extends Fragment {

    private ArrayList<Place> places = new ArrayList<>();
    private ListView listView;
    private PlaceAdapter placeAdapter;

    public EatAndDrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list,container,false);
        if (places.size() == 0){
            places.add(new Place(getString(R.string.bajorkiemis_city),
                    getString(R.string.bajorkiemis_city_desc),
                    R.drawable.bajorkiemis_city_thumbn, R.drawable.bajorkiemis_city,
                    getString(R.string.bajorkiemis_city_address)));
            places.add(new Place(getString(R.string.peledine_burgers),
                    getString(R.string.peledine_burgers_desc),
                    R.drawable.peledine_thumbn, R.drawable.peledine,
                    getString(R.string.peledine_burgers_address)));
            places.add(new Place(getString(R.string.bella_italia),
                    getString(R.string.bella_italia_desc),
                    R.drawable.bella_italia_thumbn, R.drawable.bella_italia,
                    getString(R.string.bella_italia_address)));
            places.add(new Place(getString(R.string.diverso),
                    getString(R.string.diverso_desc),
                    R.drawable.diverso_thumbn, R.drawable.diverso,
                    getString(R.string.diverso_address)));
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
