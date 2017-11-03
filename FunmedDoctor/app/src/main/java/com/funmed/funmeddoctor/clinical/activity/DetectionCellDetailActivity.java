package com.funmed.funmeddoctor.clinical.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/11/1.
 */

public class DetectionCellDetailActivity extends BaseActivity {

    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.btn_add_to_order)
    Button btnAddToOrder;

    @Override
    public int getLayoutId() {
        return R.layout.activity_detection_cell_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
//        NormalDetectionBean data = getIntent().getParcelableExtra("data");
//        if (data != null) {
//            toolbarTitle.setText(data.getName());
//        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @OnClick(R.id.btn_add_to_order)
    public void onViewClicked() {
        finish();
    }
}
