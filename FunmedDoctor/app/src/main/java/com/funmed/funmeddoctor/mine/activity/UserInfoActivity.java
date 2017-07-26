package com.funmed.funmeddoctor.mine.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.widget.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/7/24.
 */

public class UserInfoActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.headImage)
    CircleImageView headImage;
    @Bind(R.id.headImageLayout)
    RelativeLayout headImageLayout;
    @Bind(R.id.tv_nick_name)
    TextView tvNickName;
    @Bind(R.id.rl_nick_name)
    RelativeLayout rlNickName;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.rl_sex)
    RelativeLayout rlSex;
    @Bind(R.id.tv_height)
    TextView tvHeight;
    @Bind(R.id.rl_height)
    RelativeLayout rlHeight;
    @Bind(R.id.tv_birthdy)
    TextView tvBirthdy;
    @Bind(R.id.rl_birthday)
    RelativeLayout rlBirthday;
    @Bind(R.id.tv_email)
    TextView tvEmail;
    @Bind(R.id.rl_email)
    RelativeLayout rlEmail;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.rl_address)
    RelativeLayout rlAddress;
    @Bind(R.id.tv_age)
    TextView tvAge;
    @Bind(R.id.rl_age)
    RelativeLayout rlAge;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        toolbarTitle.setText("个人信息");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    @OnClick({R.id.headImage, R.id.headImageLayout,R.id.rl_age, R.id.rl_nick_name, R.id.rl_sex, R.id.rl_height, R.id.rl_birthday, R.id.rl_email, R.id.rl_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.headImage:
                break;
            case R.id.headImageLayout:
                break;
            case R.id.rl_age:
                startActivity(ChangeAgeActivity.class);
                break;
            case R.id.rl_nick_name:
                startActivity(ChangeNickNameActivity.class);
                break;
            case R.id.rl_sex:
                startActivity(ChangeSexActivity.class);
                break;
            case R.id.rl_height:
                startActivity(ChangeHeightActivity.class);
                break;
            case R.id.rl_birthday:
                startActivity(ChangeBirthdayActivity.class);
                break;
            case R.id.rl_email:
                startActivity(ChangeEmailActivity.class);
                break;
            case R.id.rl_address:
                startActivity(ChangeAddressActivity.class);
                break;
        }
    }
}
