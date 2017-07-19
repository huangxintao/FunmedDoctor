package com.funmed.funmeddoctor.home.activity;

import android.graphics.Color;
import android.support.v7.widget.Toolbar;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.home.adapter.MainAdapter;

import butterknife.Bind;
import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;
import me.murphy.common.base.BaseActivity;
import me.murphy.common.commonwidget.NoSmoothScrollViewPager;

/**
 * Created by tony on 2017/7/18.
 */

public class MainTabActivity extends BaseActivity implements OnTabItemSelectListener {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.container)
    NoSmoothScrollViewPager mViewPager;
    @Bind(R.id.tab)
    PagerBottomTabLayout mTab;
    /**
     * 用来控制tab变化
     */
    private Controller controller;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_tab;

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        SetTranslanteBar();
        setSupportActionBar(mToolbar);

        controller = mTab.builder()
                .addTabItem(R.mipmap.home, "首页")
                .addTabItem(R.mipmap.course, "临床数据")
                .addTabItem(R.mipmap.course, "科研数据")
                .addTabItem(R.mipmap.teacher,"社区")
                .addTabItem(R.mipmap.mine, "我的")
                .setMessageBackgroundColor(Color.RED)
                .setMessageNumberColor(Color.WHITE)
                .build();
        controller.addTabItemClickListener(this);
        MainAdapter mSectionsPagerAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPager = (NoSmoothScrollViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setIsCanScroll(false);
    }

    @Override
    public void onSelected(int index, Object tag) {
        switch (index) {
            case 0:
                mToolbar.setTitle("首页");
                break;
            case 1:
                mToolbar.setTitle("临床数据");
                break;
            case 2:
                mToolbar.setTitle("科研数据");
                break;
            case 3:
                mToolbar.setTitle("社区");
                break;
            case 4:
                mToolbar.setTitle("我的");
//            default:
//                mToolbar.setTitle("首页");
//                break;

        }
        mViewPager.setCurrentItem(index, false);
    }

    @Override
    public void onRepeatClick(int index, Object tag) {

    }
}
