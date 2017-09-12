package com.funmed.funmeddoctor.home.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.home.adapter.MainAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
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
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    /**
     * 用来控制tab变化
     */
    private Controller controller;

    public void setSelectedItem(int pos){
        controller.setSelect(pos);
    }

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
        toolbarTitle.setText("设置");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        controller = mTab.builder()
                .addTabItem(R.mipmap.home, "首页",getResources().getColor(R.color.main_color))
                .addTabItem(R.mipmap.course, "临床数据",getResources().getColor(R.color.main_color))
                .addTabItem(R.mipmap.data_normal, "科研数据",getResources().getColor(R.color.main_color))
                .addTabItem(R.mipmap.found_normal, "社区",getResources().getColor(R.color.main_color))
                .addTabItem(R.mipmap.mine, "我的",getResources().getColor(R.color.main_color))
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
                toolbarTitle.setText("首页");
                break;
            case 1:
                toolbarTitle.setText("临床数据");
                break;
            case 2:
                toolbarTitle.setText("科研数据");
                break;
            case 3:
                toolbarTitle.setText("社区");
                break;
            case 4:
                toolbarTitle.setText("我的");
        }
        mViewPager.setCurrentItem(index, false);
    }

    @Override
    public void onRepeatClick(int index, Object tag) {

    }

    private long exitTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
