package com.example.android.project6;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.project6.Fragments.AccommodationFragment;
import com.example.android.project6.Fragments.EatAndDrinkFragment;
import com.example.android.project6.Fragments.ToDoFragment;
import com.example.android.project6.Fragments.ToSeeFragment;

/**
 * Created by Edvinas on 27/05/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter{
    private static int NUM_ITEMS = 4;
    private Context context;

    public PagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new ToSeeFragment();
        else if (position == 1)
            return new ToDoFragment();
        else if (position == 2)
            return new AccommodationFragment();
        else
            return new EatAndDrinkFragment();
        }
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position){
        String tabTitles[] = new String[]{
                "To see",
                "To do",
                "Accommodation",
                "Eat and drink"};
        return tabTitles[position];
        }
    }
