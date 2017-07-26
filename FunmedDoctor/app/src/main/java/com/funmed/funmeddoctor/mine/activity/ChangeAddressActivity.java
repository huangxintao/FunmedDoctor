package com.funmed.funmeddoctor.mine.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/7/26.
 */

public class ChangeAddressActivity extends BaseActivity {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_address)
    EditText etAddress;

    @Override
    public int getLayoutId() {
        return R.layout.activity_change_address;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        toolbarTitle.setText("修改地址");
        toolbarRightTitle.setText("保存");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    @OnClick({R.id.toolbar_title, R.id.toolbar_right_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_title:
                break;
            case R.id.toolbar_right_title:
                break;
        }
    }
}
