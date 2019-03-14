package com.yoyi.android.naranginagpur;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Removing the shadow of Action bar
        getSupportActionBar().setElevation(0);

        ViewPager viewPager = findViewById(R.id.viewpager);

        LocationAdapter locationFragmentAdapter = new LocationAdapter(this, getSupportFragmentManager());

        // Attaching the custom FragmentPagerAdapter to viewPager
        viewPager.setAdapter(locationFragmentAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        // Connecting the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);
    }
}
