package com.funmed.funmeddoctor.community.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.AidResearchListBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/8/10.
 */

public class AidResearchDetailActivity extends BaseActivity {
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_initiator)
    TextView tvInitiator;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.tv_email)
    TextView tvEmail;
    @Bind(R.id.tv_disease_name)
    TextView tvDiseaseName;
    @Bind(R.id.tv_profile)
    TextView tvProfile;
    @Bind(R.id.tv_research_fund)
    TextView tvResearchFund;
    private AidResearchListBean.DataBean data;

    @Override
    public int getLayoutId() {
        return R.layout.activity_aid_research_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        toolbarTitle.setText("互助式研究");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        data = getIntent().getParcelableExtra("data");
        if (data != null) {
            tvDiseaseName.setText(data.getDiseaser_name());
            tvEmail.setText(data.getEmail());
            tvInitiator.setText(data.getInitiator());
            tvPhone.setText(data.getMobile());
            tvProfile.setText(data.getProfile());
            tvResearchFund.setText(data.getResearch_fund());
            tvBack.setVisibility(View.VISIBLE);
        }
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
