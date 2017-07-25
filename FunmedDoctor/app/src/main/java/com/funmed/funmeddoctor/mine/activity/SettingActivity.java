package com.funmed.funmeddoctor.mine.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.funmed.funmeddoctor.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/7/25.
 */

public class SettingActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rl_update_password)
    RelativeLayout rlUpdatePassword;
    @Bind(R.id.rl_user_info)
    RelativeLayout rlUserInfo;
    @Bind(R.id.rl_version)
    RelativeLayout rlVersion;
    @Bind(R.id.rl_service_protocol)
    RelativeLayout rlServiceProtocol;

    @Override
    public int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        toolbar.setTitle("设置");
        setSupportActionBar(toolbar);
        SetTranslanteBar();
    }


    @OnClick({R.id.rl_user_info, R.id.rl_update_password, R.id.rl_version, R.id.rl_service_protocol})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_user_info:

                break;
            case R.id.rl_update_password:

                break;
            case R.id.rl_version:

                break;
            case R.id.rl_service_protocol:

                break;
        }
    }
}
