package com.funmed.funmeddoctor.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.home.activity.MainTabActivity;
import com.funmed.funmeddoctor.widget.CircleMenuLayout;
import com.funmed.funmeddoctor.widget.DotProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseFragment;
import me.murphy.common.baserx.RxManager;
import me.murphy.common.commonutils.TUtil;

/**
 * Created by tony on 2017/7/18.
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.id_circle_menu_item_center)
    RelativeLayout idCircleMenuItemCenter;
    @Bind(R.id.dotProgressBar)
    DotProgressBar dotProgressBar;
    @Bind(R.id.circle_menu_layout)
    CircleMenuLayout circleMenuLayout;
    private final String[] mItemTexts = new String[]{"临床数据", "科研数据", "医生社区", "个人账户"};
    ;
    private final int[] mItemImgs = new int[]{R.mipmap.circle_icon1, R.mipmap.circle_icon2, R.mipmap.circle_icon3, R.mipmap.circle_icon4};
    ;

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
        dotProgressBar.setDescribeText("医生您好！");
        dotProgressBar.refreshDotProgress(100);
        circleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
        circleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                switch (pos){
                    case 0:
                        ((MainTabActivity)getActivity()).setSelectedItem(1);
                        break;
                    case 1:
                        ((MainTabActivity)getActivity()).setSelectedItem(2);
                        break;
                    case 2:
                        ((MainTabActivity)getActivity()).setSelectedItem(3);
                        break;
                    case 3:
                        ((MainTabActivity)getActivity()).setSelectedItem(4);
                        break;

                }
            }

            @Override
            public void itemCenterClick(View view) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            rootView = inflater.inflate(getLayoutResource(), container, false);
        mRxManager = new RxManager();
        ButterKnife.bind(this, rootView);
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        initPresenter();
        initVariable();
        initView();
        return rootView;
    }
}
