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
import com.funmed.funmeddoctor.bean.User;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.ApiService;
import com.umeng.socialize.media.Base;

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
 * Created by tony on 2017/8/3.
 */

public class SeniorDetectionActivity extends BaseActivity {

    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_single_cell_sequencing)
    EditText etSingleCellSequencing;
    @Bind(R.id.et_epidemic)
    EditText etEpidemic;
    @Bind(R.id.et_leave_hospital)
    EditText etLeaveHospital;
    @Bind(R.id.et_biological_sample_bank)
    EditText etBiologicalSampleBank;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_email)
    EditText etEmail;
    @Bind(R.id.et_address)
    EditText etAddress;
    @Bind(R.id.btn_commit)
    Button btnCommit;
    private ApiService service;
    private Map<String, String> params = new HashMap<String, String>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_senior_detection;
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
        toolbarTitle.setText("高端检测");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    @OnClick(R.id.btn_commit)
    public void onViewClicked() {
        params.clear();
        if (checkNull()){
            params.put("userid", User.getUser().getUserid());
            params.put("name",etName.getText().toString());
            params.put("mobile",etName.getText().toString());
            params.put("email",etName.getText().toString());
            params.put("address",etName.getText().toString());
            params.put("single_Cell_Sequencing",etSingleCellSequencing.getText().toString());
            params.put("epidemic",etEpidemic.getText().toString());
            params.put("leave_Hospital",etLeaveHospital.getText().toString());
            params.put("Biological_Sample_Bank",etBiologicalSampleBank.getText().toString());
            Call<BaseBean> call = service.addSeniorDetection(params);
            call.enqueue(new Callback<BaseBean>() {
                @Override
                public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                    if (response != null && response.body().getCode() == 0) {
                        Toast.makeText(SeniorDetectionActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        startActivity(CommitSuccessActivity.class);
                    } else {
                        Toast.makeText(SeniorDetectionActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<BaseBean> call, Throwable t) {
                    Toast.makeText(SeniorDetectionActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private boolean checkNull() {
        boolean checked = false;
        if (TextUtils.isEmpty(etName.getText())) {
            Toast.makeText(mContext, "请输入联系人姓名", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etPhone.getText())) {
            Toast.makeText(mContext, "请输入电话号码", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etEmail.getText())) {
            Toast.makeText(mContext, "请输入邮箱", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etAddress.getText())) {
            Toast.makeText(mContext, "请输入地址", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etBiologicalSampleBank.getText())) {
            Toast.makeText(mContext, "请填写必要数据", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etEpidemic.getText())) {
            Toast.makeText(mContext, "请填写必要数据", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(etSingleCellSequencing.getText())){
            Toast.makeText(mContext, "请填写必要数据", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(etLeaveHospital.getText())){
            Toast.makeText(mContext, "请填写必要数据", Toast.LENGTH_SHORT).show();
        }else {
            checked = true;
        }
        return checked;
    }
}
