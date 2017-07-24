package com.funmed.funmeddoctor.mine.activity;

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
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.ApiService;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;
import me.murphy.common.commonutils.ToastUitl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/7/24.
 */

public class ForgetPasswordActivity extends BaseActivity {
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
    @Bind(R.id.btn_reset_password)
    Button btnResetPassword;
    private ApiService service;

    @Override
    public int getLayoutId() {
        return R.layout.activity_forget_password;
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
        toolbar.setTitle("找回密码");
        setSupportActionBar(toolbar);
        SetTranslanteBar();
    }


    @OnClick({R.id.btn_get_checkcode, R.id.btn_reset_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_checkcode:
                if (etTelephone!=null && !"".equals(etTelephone)){
                    getCheckCode();
                }else {
                    ToastUitl.showShort("手机号不能为空");
                }
                break;
            case R.id.btn_reset_password:

                doResetPassword();
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

    //忘记密码，重置
    private void doResetPassword() {
        Call<BaseBean> call = service.forgetPwd(etUsername.getText().toString()
                , etPassword.getText().toString()
                , etTelephone.getText().toString()
                , etCheckcode.getText().toString());
        call.enqueue(new Callback<BaseBean>() {
            @Override
            public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                if (response != null && response.body().getCode() == 0) {
                    startActivity(LoginActivity.class);
                    Toast.makeText(getApplicationContext(),"重置成功",Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(getApplicationContext(),response.body().getMsg(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseBean> call, Throwable t) {

            }
        });
    }
}
