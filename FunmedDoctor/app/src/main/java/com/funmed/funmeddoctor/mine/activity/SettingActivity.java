package com.funmed.funmeddoctor.mine.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.btn_logout)
    Button btnLogout;
    @Bind(R.id.tv_version_name)
    TextView tvVersionName;

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
        toolbarTitle.setText("设置");
        toolbarRightTitle.setVisibility(View.GONE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvVersionName.setText(getVersion());
    }


    @OnClick({R.id.rl_user_info, R.id.rl_update_password, R.id.rl_version, R.id.rl_service_protocol, R.id.btn_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_user_info:
                startActivity(UserInfoActivity.class);
                break;
            case R.id.rl_update_password:
                startActivity(UpdatePasswordActivity.class);
                break;
            case R.id.rl_version:

                break;
            case R.id.rl_service_protocol:

                break;
            case R.id.btn_logout:
                SharedPreferences sp = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username", "0");
                editor.putString("password", "0");
                editor.putString("user_id", "0");
                editor.commit();
                startActivity(LoginActivity.class);
                finish();
                break;
        }
    }

    public String getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return this.getString(R.string.can_not_find_version_name);
        }
    }
}
