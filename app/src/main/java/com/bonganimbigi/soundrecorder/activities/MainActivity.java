package com.bonganimbigi.soundrecorder.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.bonganimbigi.soundrecorder.R;
import com.bonganimbigi.soundrecorder.fragments.FileViewerFragment;
import com.bonganimbigi.soundrecorder.fragments.LicensesFragment;
import com.bonganimbigi.soundrecorder.fragments.PlaybackFragment;
import com.bonganimbigi.soundrecorder.fragments.RecordFragment;


public class MainActivity extends ActionBarActivity{

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
//        pager = (ViewPager) findViewById(R.id.pager);
//        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }


    public class MyAdapter extends FragmentPagerAdapter {
        private String[] titles = new String[] {getString(R.string.tab_title_record), getString(R.string.tab_title_saved_recordings)};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return RecordFragment.newInstance(position);
                case 1:
                    return FileViewerFragment.newInstance(position);
            }

            return null;
        }

        public int getCount() {
            return titles.length;
        }

        public String getPageTitle(int position){
            return titles[position];
        }
    }



    public MainActivity() {
    }
}
