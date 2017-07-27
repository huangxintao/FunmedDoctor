package com.funmed.funmeddoctor.mine.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.User;
import com.funmed.funmeddoctor.mine.activity.SettingActivity;
import com.funmed.funmeddoctor.mine.activity.UserInfoActivity;
import com.funmed.funmeddoctor.widget.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseFragment;

/**
 * Created by tony on 2017/7/18.
 */

public class MineFragment extends BaseFragment {
    @Bind(R.id.tv_mine_login_regist)
    TextView tvMineLoginRegist;
    @Bind(R.id.ll_mine_settings)
    LinearLayout llMineSettings;
    @Bind(R.id.ll_mine_myorder)
    LinearLayout llMineMyorder;
    @Bind(R.id.ll_mine_about_us)
    LinearLayout llMineAboutUs;
    @Bind(R.id.ll_mine_userinfo)
    LinearLayout llMineUserinfo;
    @Bind(R.id.headImage)
    CircleImageView headImage;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        tvMineLoginRegist.setText(User.getUser().getUsername());
    }


    @OnClick({R.id.ll_mine_userinfo, R.id.ll_mine_settings, R.id.ll_mine_myorder, R.id.ll_mine_about_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_mine_userinfo:
                startActivity(UserInfoActivity.class);
                break;
            case R.id.ll_mine_settings:
                startActivity(SettingActivity.class);
                break;
            case R.id.ll_mine_myorder:
                break;
            case R.id.ll_mine_about_us:
                break;
        }
    }

}
