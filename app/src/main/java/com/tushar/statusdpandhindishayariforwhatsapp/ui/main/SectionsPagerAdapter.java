package com.tushar.statusdpandhindishayariforwhatsapp.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tushar.statusdpandhindishayariforwhatsapp.R;
import com.tushar.statusdpandhindishayariforwhatsapp.statuscategory;
import com.tushar.statusdpandhindishayariforwhatsapp.video;
import com.tushar.statusdpandhindishayariforwhatsapp.dp;
import com.tushar.statusdpandhindishayariforwhatsapp.shayari;
import com.tushar.statusdpandhindishayariforwhatsapp.status;
import com.tushar.statusdpandhindishayariforwhatsapp.trending;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,
            R.string.tab_text_3,R.string.tab_text_4,R.string.tab_text_5,R.string.tab_text_6};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position)
        {
            case 0:
                fragment=new status();
                break;
            case 1:
                fragment=new trending();
                break;
            case 2:
                fragment=new shayari();
                break;
            case 3:
                fragment=new dp();
                break;

            case 5:
                fragment=new statuscategory();
                break;

            case 4:
                fragment=new video();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 6;
    }
}