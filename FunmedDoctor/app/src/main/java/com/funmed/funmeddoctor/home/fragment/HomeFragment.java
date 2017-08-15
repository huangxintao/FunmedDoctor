package com.funmed.funmeddoctor.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.widget.CircleMenuLayout;
import com.funmed.funmeddoctor.widget.DotProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseFragment;

/**
 * Created by tony on 2017/7/18.
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.id_circle_menu_item_center)
    RelativeLayout idCircleMenuItemCenter;
    @Bind(R.id.circle_menu_layout)
    CircleMenuLayout circleMenuLayout;
    private String[] mItemTexts;
    private int[] mItemImgs;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        getData();
        circleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
        circleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {

            }

            @Override
            public void itemCenterClick(View view) {

            }
        });
    }

    private void getData() {
        mItemImgs = null;
        mItemTexts = null;
        mItemTexts = new String[]{"临床数据", "科研数据", "社区", "医生导航"};
        mItemImgs = new int[]{R.mipmap.circle_icon1, R.mipmap.circle_icon2, R.mipmap.circle_icon3, R.mipmap.circle_icon4};
    }

}
