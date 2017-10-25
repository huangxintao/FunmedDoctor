package com.funmed.funmeddoctor.scientific.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.community.adapter.CommunityFragmentAdapter;
import com.funmed.funmeddoctor.community.fragment.DoctorFragment;
import com.funmed.funmeddoctor.community.fragment.HealthFragment;
import com.funmed.funmeddoctor.community.fragment.HospitalFragment;
import com.funmed.funmeddoctor.community.fragment.SubHealthFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/10/25.
 */

public class SecondNormalDetectionActivitiy extends BaseActivity {
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private FragmentPagerAdapter fragmentAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_second_detection;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        toolbarTitle.setText("常规检测");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initTabLayout() {
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        tabLayout.setupWithViewPager(viewpager);
        tabLayout.getTabAt(0).setText("核酸检测");
        tabLayout.getTabAt(1).setText("蛋白检测");
        tabLayout.getTabAt(2).setText("细胞检测");
        tabLayout.getTabAt(3).setText("高端检测");
    }

    private void setupViewPager() {
        fragmentAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return null;
            }

            @Override
            public int getCount() {
                return 0;
            }
        };
    }
}
