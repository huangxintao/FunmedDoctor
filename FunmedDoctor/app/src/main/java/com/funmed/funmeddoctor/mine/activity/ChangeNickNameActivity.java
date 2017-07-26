package com.funmed.funmeddoctor.mine.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/7/26.
 */

public class ChangeNickNameActivity extends BaseActivity {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_nickname)
    EditText etNickname;

    @Override
    public int getLayoutId() {
        return R.layout.activity_change_nick_name;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        toolbarTitle.setText("修改昵称");
        toolbarRightTitle.setText("保存");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
