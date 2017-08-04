package com.funmed.funmeddoctor.scientific.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.NormalDetectionBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/8/4.
 */

public class DetectionUserInfoUploadActivity extends BaseActivity {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_email)
    EditText etEmail;
    @Bind(R.id.et_address)
    EditText etAddress;
    @Bind(R.id.btn_next)
    Button btnNext;
    private List<NormalDetectionBean> dataList = new ArrayList<NormalDetectionBean>();

    public int getLayoutId() {
        return R.layout.activity_detection_user_info;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        toolbarTitle.setText("联系人信息");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        dataList.clear();
        dataList = getIntent().getExtras().getParcelableArrayList("data");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) dataList);
                bundle.putString("name",etName.getText().toString());
                bundle.putString("phone",etPhone.getText().toString());
                bundle.putString("email",etEmail.getText().toString());
                bundle.putString("address",etAddress.getText().toString());
                bundle.putString("amount",getIntent().getExtras().getString("amount"));
                startActivity(NormalDetectionConfirmActivity.class,bundle);
            }
        });
    }
}
