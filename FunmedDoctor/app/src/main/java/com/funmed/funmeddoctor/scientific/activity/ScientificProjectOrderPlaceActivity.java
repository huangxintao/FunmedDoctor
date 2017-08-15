package com.funmed.funmeddoctor.scientific.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.ScientificOrderTypeBean;
import com.funmed.funmeddoctor.scientific.adapter.ScientificOrderTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/7/21.
 */

public class ScientificProjectOrderPlaceActivity extends BaseActivity {
    @Bind(R.id.iv_scientific_desc)
    ImageView ivScientificDesc;
    @Bind(R.id.rv_scientific_order_type)
    RecyclerView rvScientificOrderType;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    private ScientificOrderTypeAdapter adapter;
    private GridLayoutManager linearLayoutManager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_scientific_order_place;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        adapter = new ScientificOrderTypeAdapter(getList());
        linearLayoutManager = new GridLayoutManager(getApplicationContext(),4);
    }

    @Override
    public void initView() {
        toolbarTitle.setText("科研项目下单");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        rvScientificOrderType.setLayoutManager(linearLayoutManager);
        rvScientificOrderType.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(NormalDetectionActivity.class);
                        break;
                    case 1:
                        startActivity(SeniorDetectionActivity.class);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });
    }


    private List<ScientificOrderTypeBean> getList() {
        List<ScientificOrderTypeBean> list = new ArrayList<ScientificOrderTypeBean>();
        ScientificOrderTypeBean bean = null;
        String[] names = {"常规检测", "高端检测", "找样本服务", "协助SCI"};
        for (int i = 0; i < 4; i++) {
            bean = new ScientificOrderTypeBean();
            bean.setTypeName(names[i]);
            list.add(bean);
            bean = null;
        }
        return list;
    }
}
