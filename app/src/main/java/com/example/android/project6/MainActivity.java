package com.example.android.project6;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ViewPager menuPager;
    PagerAdapter fragmentPagerAdapter;
    TabLayout menuTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views in XML
        menuPager = (ViewPager) findViewById(R.id.menuPager);
        menuTabs = (TabLayout) findViewById(R.id.menuTabs);

        fragmentPagerAdapter = new PagerAdapter(getSupportFragmentManager(), MainActivity.this);

        menuPager.setAdapter(fragmentPagerAdapter);

        menuTabs.setupWithViewPager(menuPager);
    }
}
