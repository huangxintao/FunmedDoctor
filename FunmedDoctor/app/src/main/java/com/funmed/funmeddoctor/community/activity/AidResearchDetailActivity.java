package com.funmed.funmeddoctor.community.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.AidResearchListBean;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

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
    @Bind(R.id.tv_help_type)
    TextView tvHelpType;
    @Bind(R.id.tv_sample_name)
    TextView tvSampleName;
    @Bind(R.id.tv_sample_size)
    TextView tvSampleSize;
    @Bind(R.id.tv_detection_method)
    TextView tvDetectionMethod;
    @Bind(R.id.tv_special_requirements)
    TextView tvSpecialRequirements;
    @Bind(R.id.ll_find_sample)
    LinearLayout llFindSample;
    @Bind(R.id.tv_end_time)
    TextView tvEndTime;
    @Bind(R.id.tv_is_urgent)
    TextView tvIsUrgent;
    @Bind(R.id.tv_is_checked)
    TextView tvIsChecked;
    @Bind(R.id.ll_find_partener)
    LinearLayout llFindPartener;

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
        toolbarRightTitle.setBackgroundResource(R.mipmap.share_icon);
        toolbarRightTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ShareAction(AidResearchDetailActivity.this)
                        .setPlatform(SHARE_MEDIA.WEIXIN)//传入平台
                        .withText("hello")//分享内容
                        .withMedia(new UMImage(AidResearchDetailActivity.this, R.mipmap.about_icon))
                        .setCallback(shareListener)//回调监听器
                        .share();
            }
        });

        data = getIntent().getParcelableExtra("data");
        if (data != null) {
            tvInitiator.setText(data.getInitiator());
            tvEmail.setText(data.getEmail());
            tvPhone.setText(data.getMobile());
            tvDiseaseName.setText(data.getDiseaser_name());
            tvBack.setVisibility(View.VISIBLE);
            if ("1".equals(data.getFormtype())) {
                llFindSample.setVisibility(View.VISIBLE);
                llFindPartener.setVisibility(View.GONE);
                tvHelpType.setText("找样本");
                tvProfile.setText(data.getHelp_content());
                tvSampleName.setText(data.getSample_name());
                tvSampleSize.setText(data.getSample_size());
                tvDetectionMethod.setText(data.getInspection_methods_and_indexes());
                tvSpecialRequirements.setText(data.getSpecial_requirements());
            } else {
                llFindSample.setVisibility(View.GONE);
                llFindPartener.setVisibility(View.VISIBLE);
                tvHelpType.setText("找合作伙伴");
                tvResearchFund.setText(data.getResearch_fund());
                tvProfile.setText(data.getProfile());
                tvEndTime.setText(data.getCycle() + "");
                tvIsUrgent.setText(data.getUrgent() + "");
                tvIsChecked.setText(data.getIscheck());
            }
        }
//
//        if (data != null) {
//            tvInitiator.setText(data.getInitiator());
//            tvEmail.setText(data.getEmail());
//            tvPhone.setText(data.getMobile());
//            tvProfile.setText(data.getProfile());
//            tvBack.setVisibility(View.VISIBLE);
//        }
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(AidResearchDetailActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(AidResearchDetailActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(AidResearchDetailActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
}
