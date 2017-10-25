package com.funmed.funmeddoctor.home.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.clinical.activity.SBKDetectionActivity;
import com.funmed.funmeddoctor.home.activity.MainTabActivity;
import com.funmed.funmeddoctor.scientific.activity.CooperationResearchActivity;
import com.funmed.funmeddoctor.scientific.activity.NormalDetectionActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseFragment;
import me.murphy.common.baserx.RxManager;
import me.murphy.common.commonutils.TUtil;

/**
 * Created by tony on 2017/7/18.
 */

public class HomeFragment extends BaseFragment {
    //    @Bind(R.id.id_circle_menu_item_center)
//    RelativeLayout idCircleMenuItemCenter;
//    @Bind(R.id.dotProgressBar)
//    DotProgressBar dotProgressBar;
//    @Bind(R.id.circle_menu_layout)
//    CircleMenuLayout circleMenuLayout;
    private final String[] mItemTexts = new String[]{"临床数据", "科研数据", "医生社区", "个人账户"};
    ;
    private final int[] mItemImgs = new int[]{R.mipmap.circle_icon1, R.mipmap.circle_icon2, R.mipmap.circle_icon3, R.mipmap.circle_icon4};
    @Bind(R.id.home_image)
    ImageView homeImage;
    @Bind(R.id.tv_left)
    TextView tvLeft;
    @Bind(R.id.tv_right)
    TextView tvRight;
    private PopupWindow popupWindow;

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
//        dotProgressBar.setDescribeText("医生您好！");
//        dotProgressBar.refreshDotProgress(100);
//        circleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
//        circleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
//            @Override
//            public void itemClick(View view, int pos) {
//                switch (pos){
//                    case 0:
//                        ((MainTabActivity)getActivity()).setSelectedItem(1);
//                        break;
//                    case 1:
//                        ((MainTabActivity)getActivity()).setSelectedItem(2);
//                        break;
//                    case 2:
//                        ((MainTabActivity)getActivity()).setSelectedItem(3);
//                        break;
//                    case 3:
//                        ((MainTabActivity)getActivity()).setSelectedItem(4);
//                        break;
//
//                }
//            }
//
//            @Override
//            public void itemCenterClick(View view) {
//
//            }
//        });
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

    @OnClick({R.id.tv_left, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                startActivity(SBKDetectionActivity.class);
                break;
            case R.id.tv_right:
                showPopupWindow();
                break;
        }
    }

    private void showPopupWindow(){
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.select_scientific_data_pop,null);
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,true);
        popupWindow.setContentView(contentView);

        TextView tv1 = (TextView)contentView.findViewById(R.id.tv_have_money);
        TextView tv2 = (TextView)contentView.findViewById(R.id.tv_have_no_money);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(NormalDetectionActivity.class);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CooperationResearchActivity.class);
            }
        });
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.activity_main_tab,null);
        popupWindow.showAtLocation(root, Gravity.NO_GRAVITY,0,0);
    }
}
