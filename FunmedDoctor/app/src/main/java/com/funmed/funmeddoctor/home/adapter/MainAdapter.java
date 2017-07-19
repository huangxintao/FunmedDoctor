package com.funmed.funmeddoctor.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.funmed.funmeddoctor.clinical.fragment.ClinicalFragement;
import com.funmed.funmeddoctor.community.fragment.CommunityFragment;
import com.funmed.funmeddoctor.home.fragment.HomeFragment;
import com.funmed.funmeddoctor.mine.fragment.MineFragment;
import com.funmed.funmeddoctor.scientific.fragment.ScientificFragment;

/**
 * Created by tony on 2017/7/18.
 */

public class MainAdapter extends FragmentPagerAdapter {
    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFragment();
        }
        if (position == 1) {
            return new ClinicalFragement();
        }
        if (position == 2) {
            return new ScientificFragment();

        }
        if (position == 3) {
            return new CommunityFragment();
        }
        return new MineFragment();
    }


    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "首页";
            case 1:
                return "临床数据";
            case 2:
                return "科研数据";
            case 4:
                return "社区";
            case 5:
                return "我的";

        }
        return null;
    }
}
