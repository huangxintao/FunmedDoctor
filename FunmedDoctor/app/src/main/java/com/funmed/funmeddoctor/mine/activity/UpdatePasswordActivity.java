package com.funmed.funmeddoctor.mine.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.BaseBean;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.ApiService;

import butterknife.Bind;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;
import me.murphy.common.commonutils.ToastUitl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/7/26.
 */

public class UpdatePasswordActivity extends BaseActivity {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_old_password)
    EditText etOldPassword;
    @Bind(R.id.et_new_password)
    EditText etNewPassword;
    @Bind(R.id.et_new_password_confirm)
    EditText etNewPasswordConfirm;
    @Bind(R.id.btn_confirm)
    Button btnConfirm;
    private ApiService service;
    private boolean isPwdChecked = true;
    private String user_id;

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_password;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        service = APIServiceImpl.getInstance().createService(ApiService.class);
        SharedPreferences sp = getSharedPreferences("user", Context.MODE_PRIVATE);
        user_id = sp.getString("user_id", "0");
    }

    @Override
    public void initView() {
        toolbarTitle.setText("修改密码");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        if (checkPwd()) {
            Call<BaseBean> call = service.updatePwd(etOldPassword.getText().toString(), etNewPassword.getText().toString(), user_id);
            call.enqueue(new Callback<BaseBean>() {
                @Override
                public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                    if (response.body()!=null && response.body().getCode()==0){
                        Toast.makeText(getApplicationContext(),response.body().getMsg(),Toast.LENGTH_SHORT).show();
                        startActivity(LoginActivity.class);
                        SharedPreferences sp = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("username","0");
                        editor.putString("password","0");
                        editor.putString("user_id","0");
                        editor.commit();
                    }else {
                        Toast.makeText(getApplicationContext(),response.body().getMsg(),Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<BaseBean> call, Throwable t) {

                }
            });

        }
    }

    private boolean checkPwd() {
        return isPwdChecked;
    }
}
