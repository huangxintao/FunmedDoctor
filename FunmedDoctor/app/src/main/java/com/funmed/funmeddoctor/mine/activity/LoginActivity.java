package com.funmed.funmeddoctor.mine.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.home.activity.MainTabActivity;

import butterknife.Bind;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/7/18.
 */

public class LoginActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @Bind(R.id.tv_register_now)
    TextView tvRegisterNow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        toolbar.setTitle("登录");
        setSupportActionBar(toolbar);
        SetTranslanteBar();
    }


    @OnClick({R.id.btn_login, R.id.tv_forget_password, R.id.tv_register_now})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                doLogin();
                break;
            case R.id.tv_forget_password:
                startActivity(RegisterActivity.class);
                break;
            case R.id.tv_register_now:
                startActivity(RegisterActivity.class);
                break;
        }
    }

    private void doLogin() {
        startActivity(MainTabActivity.class);
        finish();
    }
}
