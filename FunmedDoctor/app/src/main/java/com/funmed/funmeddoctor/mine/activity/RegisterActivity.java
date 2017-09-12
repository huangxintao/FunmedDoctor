package com.funmed.funmeddoctor.mine.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.BaseBean;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.ApiService;
import com.funmed.funmeddoctor.utils.CountDownTimerUtils;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;
import me.murphy.common.commonutils.ToastUitl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/7/18.
 */

public class RegisterActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_telephone)
    EditText etTelephone;
    @Bind(R.id.et_checkcode)
    EditText etCheckcode;
    @Bind(R.id.btn_get_checkcode)
    TextView btnGetCheckcode;
    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.et_confirm_password)
    EditText etConfirmPassword;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    private ApiService service;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
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
        toolbarTitle.setText("注册");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @OnClick({R.id.btn_get_checkcode, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_checkcode:
                if (!TextUtils.isEmpty(etTelephone.getText())) {
                    CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(btnGetCheckcode,60000,1000);
                    countDownTimerUtils.start();
                    getCheckCode();
                } else {
                    Toast.makeText(mContext, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_register:
                if (checkNull()) {
                    goRegister();
                }
                break;
        }
    }

    //获取验证码
    private void getCheckCode() {
        Call<BaseBean> call = service.getCheckCode(String.valueOf(etTelephone.getText()));
        call.enqueue(new Callback<BaseBean>() {
            @Override
            public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                if (response != null && response.body().getCode() == 0) {

                }
                Log.e("checkcode", response.body().toString());
            }

            @Override
            public void onFailure(Call<BaseBean> call, Throwable t) {

            }
        });
    }

    //注册
    private void goRegister() {
        Call<BaseBean> call = service.register(etUsername.getText().toString()
                , etPassword.getText().toString()
                , etTelephone.getText().toString()
                , etCheckcode.getText().toString());
        call.enqueue(new Callback<BaseBean>() {
            @Override
            public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                if (response != null && response.body().getCode() == 0) {
                    startActivity(LoginActivity.class);
                    Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseBean> call, Throwable t) {

            }
        });
    }

    //验证用户输入信息
    private boolean checkNull() {
        boolean isChecked = false;

        if (TextUtils.isEmpty(etTelephone.getText())) {
            Toast.makeText(getApplicationContext(), "请输入手机号", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etUsername.getText())) {
            Toast.makeText(getApplicationContext(), "请输入用户名", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etCheckcode.getText())) {
            Toast.makeText(getApplicationContext(), "请输入验证码", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etPassword.getText())) {
            Toast.makeText(getApplicationContext(), "密码格式不对", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etConfirmPassword.getText())) {
            Toast.makeText(getApplicationContext(), "请再次输入密码", Toast.LENGTH_SHORT).show();
        } else if (!etPassword.getText().equals(etConfirmPassword.getText())) {
            Toast.makeText(getApplicationContext(), "两次输入的密码不同", Toast.LENGTH_SHORT).show();
        } else {
            isChecked = true;
        }
        return isChecked;
    }
}
