package com.funmed.funmeddoctor.scientific.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.funmed.funmeddoctor.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/7/21.
 */

public class NormalDetectionActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_normal_detection;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        SetTranslanteBar();
        setSupportActionBar(toolbar);
    }

}
