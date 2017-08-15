package com.funmed.funmeddoctor.scientific.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.home.activity.MainTabActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;
import me.murphy.common.baseapp.AppManager;

/**
 * Created by tony on 2017/8/7.
 */

public class CommitSuccessActivity extends BaseActivity {
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_commit_suc)
    TextView tvCommitSuc;
    @Bind(R.id.btn_see_now)
    Button btnSeeNow;
    @Bind(R.id.btn_back_to_home)
    Button btnBackToHome;

    @Override
    public int getLayoutId() {
        return R.layout.activity_commit_success;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        toolbarTitle.setText("提交成功");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    @OnClick({R.id.btn_see_now, R.id.btn_back_to_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_see_now:
                break;
            case R.id.btn_back_to_home:
                AppManager.getAppManager().returnToActivity(MainTabActivity.class);
                break;
        }
    }
}
