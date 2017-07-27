package com.funmed.funmeddoctor.mine.activity;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.BaseBean;
import com.funmed.funmeddoctor.bean.User;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.ApiService;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;
import me.murphy.common.commonutils.ToastUitl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/7/26.
 */

public class ChangeAgeActivity extends BaseActivity {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_age)
    EditText etAge;
    private ApiService service;
    private Map<String, String> params = new ArrayMap<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_change_age;
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
        toolbarTitle.setText("修改年龄");
        toolbarRightTitle.setText("保存");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @OnClick({R.id.toolbar_right_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_right_title:
                params.put("age", etAge.getText().toString());
                params.put("userid", User.getUser().getUserid());
                Call<BaseBean> call = service.addUserInfo(params);
                call.enqueue(new Callback<BaseBean>() {
                    @Override
                    public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                        if (response.body()!=null && response.body().getCode()==0){
                            Toast.makeText(ChangeAgeActivity.this,response.body().getMsg(), Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(ChangeAgeActivity.this,response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseBean> call, Throwable t) {
                        Toast.makeText(ChangeAgeActivity.this,t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
