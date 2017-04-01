package com.n37bl4d3.locationtracker.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.n37bl4d3.locationtracker.interfaces.ITabLayout;

import java.util.ArrayList;

public class TabLayoutFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<ITabLayout> mITabLayoutArrayList;

    public TabLayoutFragmentPagerAdapter(FragmentManager fragmentManager, ArrayList<ITabLayout> ITabLayoutArrayList) {
        super(fragmentManager);

        mITabLayoutArrayList = ITabLayoutArrayList;
    }

    @Override
    public int getCount() {
        return mITabLayoutArrayList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mITabLayoutArrayList.get(position).getItem();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mITabLayoutArrayList.get(position).getPageTitle();
    }
}
