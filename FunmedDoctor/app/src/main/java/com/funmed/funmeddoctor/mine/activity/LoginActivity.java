package com.funmed.funmeddoctor.mine.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.BaseBean;
import com.funmed.funmeddoctor.bean.User;
import com.funmed.funmeddoctor.home.activity.MainTabActivity;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.ApiService;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    private ApiService service;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        service = APIServiceImpl.getInstance().createService(ApiService.class);
    }

    @Override
    public void initView() {
        toolbarTitle.setText("登录");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    @OnClick({R.id.btn_login, R.id.tv_forget_password, R.id.tv_register_now})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                doLogin();
                break;
            case R.id.tv_forget_password:
                startActivity(ForgetPasswordActivity.class);
                break;
            case R.id.tv_register_now:
                startActivity(RegisterActivity.class);
                break;
        }
    }

    private void doLogin() {
        Call<BaseBean> call = service.login(etUsername.getText().toString(), etPassword.getText().toString());
        call.enqueue(new Callback<BaseBean>() {
            @Override
            public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                if (response != null && response.body().getCode() == 0) {
                    Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("username", etUsername.getText().toString());
                    editor.putString("password", etPassword.getText().toString());
                    editor.putString("user_id", response.body().getData().getUserid());
                    editor.commit();
                    User.getUser().setUsername(response.body().getData().getUsername());
                    User.getUser().setUserid(response.body().getData().getUserid());
                    User.getUser().setToken(response.body().getData().getToken());
                    User.getUser().setAge(response.body().getData().getAge());
                    User.getUser().setHeight(response.body().getData().getHeight());
                    User.getUser().setWeight(response.body().getData().getWeight());
                    User.getUser().setSex(response.body().getData().getSex());
                    User.getUser().setHeadImage_path(response.body().getData().getHeadImage_path());
                    User.getUser().setBirthday(response.body().getData().getBirthday());
                    User.getUser().setAddress(response.body().getData().getAddress());
                    User.getUser().setMobile(response.body().getData().getMobile());
                    startActivity(MainTabActivity.class);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseBean> call, Throwable t) {
                startActivity(MainTabActivity.class);
                t.printStackTrace();
            }
        });
    }
}
