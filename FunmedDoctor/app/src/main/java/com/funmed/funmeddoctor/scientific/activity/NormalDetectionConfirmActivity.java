package com.funmed.funmeddoctor.scientific.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.NormalDetectionBean;
import com.funmed.funmeddoctor.scientific.adapter.OrderConfirmDetectionAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/8/3.
 */

public class NormalDetectionConfirmActivity extends BaseActivity {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_detection_data)
    RecyclerView rvDetectionData;
    @Bind(R.id.tv_xiaoji)
    TextView tvXiaoji;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.tv_email)
    TextView tvEmail;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.tv_total_price)
    TextView tvTotalPrice;
    @Bind(R.id.btn_pay_order)
    Button btnPayOrder;
    private List<NormalDetectionBean> dataList = new ArrayList<NormalDetectionBean>();
    private LinearLayoutManager layoutManager;
    private OrderConfirmDetectionAdapter adapter;
    private String totalPrice;

    @Override
    public int getLayoutId() {
        return R.layout.activity_normal_detection_confirm;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        layoutManager = new LinearLayoutManager(getApplicationContext());
        adapter = new OrderConfirmDetectionAdapter(dataList, getApplicationContext());
    }

    @Override
    public void initView() {
        toolbarTitle.setText("确认订单");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        dataList.clear();
        dataList = getIntent().getExtras().getParcelableArrayList("data");
        totalPrice = getIntent().getExtras().getString("amount");
        adapter = new OrderConfirmDetectionAdapter(dataList, getApplicationContext());
        rvDetectionData.setLayoutManager(layoutManager);
        rvDetectionData.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        tvTotalPrice.setText(getResources().getString(R.string.RMB)+totalPrice);
        tvXiaoji.setText(getResources().getString(R.string.RMB)+totalPrice);
    }
}
