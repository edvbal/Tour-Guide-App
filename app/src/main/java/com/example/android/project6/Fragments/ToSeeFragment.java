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
public class ToSeeFragment extends Fragment {

    private ArrayList<Place> places = new ArrayList<>();
    private ListView listView;
    private PlaceAdapter placeAdapter;

    public ToSeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list,container,false);

        if (places.size() == 0){
            places.add(new Place(getString(R.string.kaunas_castle),
                    getString(R.string.kaunas_castle_desc),
                    R.drawable.kaunas_castle, R.drawable.kaunas_castle2,
                    getString(R.string.kaunas_castle_address)));
            places.add(new Place(getString(R.string.ciurlionis_museum),
                    getString(R.string.ciurlionis_museum_desc),
                    R.drawable.ciurlionis_musem_thumbn, R.drawable.ciurlionis_museum,
                    getString(R.string.ciurlionis_museum_address)));
            places.add(new Place(getString(R.string.ix_fort_museum),
                    getString(R.string.ix_fort_desc),
                    R.drawable.ix_fort_thumbn, R.drawable.ix_fort,
                    getString(R.string.ix_fort_address)));
            places.add(new Place(getString(R.string.atomic_bunker),
                    getString(R.string.atomic_bunker_desc),
                    R.drawable.atomic_bunker_thumbn, R.drawable.atomic_bunker,
                    getString(R.string.atomic_bunker_address)));
            places.add(new Place(getString(R.string.kaunas_town_hall),
                    getString(R.string.kaunas_town_hall_desc),
                    R.drawable.kaunas_town_hall_thumbn, R.drawable.kaunas_town_hall,
                    getString(R.string.kaunas_town_hall_address)));
            places.add(new Place(getString(R.string.aleksotas_funicular),
                    getString(R.string.aleksotas_funicular_desc),
                    R.drawable.aleksotas_funicular_thumbn, R.drawable.aleksotas_funicular,
                    getString(R.string.aleksotas_funicular_address)));
            places.add(new Place(getString(R.string.thunder_house),
                    getString(R.string.thunder_house_desc),
                    R.drawable.thunder_house_thumbn, R.drawable.thunder_house,
                    getString(R.string.thunder_house_address)));
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
