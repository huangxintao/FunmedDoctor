package com.funmed.funmeddoctor.scientific.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.BaseBean;
import com.funmed.funmeddoctor.bean.DataResponse;
import com.funmed.funmeddoctor.bean.User;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.APIServiceImplInfo;
import com.funmed.funmeddoctor.network.ApiService;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/8/7.
 */

public class CooperationResearchActivity extends BaseActivity {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_initiator)
    EditText etInitiator;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_email)
    EditText etEmail;
    @Bind(R.id.et_disease_name)
    EditText etDiseaseName;
    @Bind(R.id.et_profile)
    EditText etProfile;
    @Bind(R.id.et_research_fund)
    EditText etResearchFund;
    @Bind(R.id.btn_commit)
    Button btnCommit;
    private ApiService service;
    private Map<String,String> params = new HashMap<String,String>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_cooperation_research;
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
        toolbarTitle.setText("发起互助式研究");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @OnClick(R.id.btn_commit)
    public void onViewClicked() {
        params.clear();
        if (checkNull()){
            params.put("initiator",etInitiator.getText().toString());
            params.put("userid", User.getUser().getUserid());
            params.put("mobile",etPhone.getText().toString());
            params.put("email",etEmail.getText().toString());
            params.put("diseaser_name",etDiseaseName.getText().toString());
            params.put("profile",etProfile.getText().toString());
            params.put("research_fund",etResearchFund.getText().toString());
            Call<DataResponse<String>> call = service.addResearchForm(params);
            call.enqueue(new Callback<DataResponse<String>>() {
                @Override
                public void onResponse(Call<DataResponse<String>> call, Response<DataResponse<String>> response) {
                    if (response!=null && response.body().getCode()==0){
                        Toast.makeText(CooperationResearchActivity.this,response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        startActivity(CommitSuccessActivity.class);
                    }else {
                        Toast.makeText(CooperationResearchActivity.this,response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<DataResponse<String>> call, Throwable t) {

                }
            });
        }
    }

    private boolean checkNull() {
        boolean checked = false;
        if (TextUtils.isEmpty(etInitiator.getText())){
            Toast.makeText(mContext, "请输入发起人姓名", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(etPhone.getText())){
            Toast.makeText(mContext, "请输入电话号码", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(etEmail.getText())){
            Toast.makeText(mContext, "请输入邮件", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(etDiseaseName.getText())){
            Toast.makeText(mContext, "请输入罕见病名称", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(etProfile.getText())){
            Toast.makeText(mContext, "请输入摘要", Toast.LENGTH_SHORT).show();   
        }else if (TextUtils.isEmpty(etResearchFund.getText())){
            Toast.makeText(mContext, "请输入预计经费", Toast.LENGTH_SHORT).show();
        }else {
            checked = true;
        }
        return checked;
    }
}
