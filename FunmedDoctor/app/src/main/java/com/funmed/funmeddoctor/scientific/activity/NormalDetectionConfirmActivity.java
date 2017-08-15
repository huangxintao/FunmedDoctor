package com.funmed.funmeddoctor.scientific.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.BaseBean;
import com.funmed.funmeddoctor.bean.GarbageBean;
import com.funmed.funmeddoctor.bean.NormalDetectionBean;
import com.funmed.funmeddoctor.bean.User;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.ApiService;
import com.funmed.funmeddoctor.scientific.adapter.OrderConfirmDetectionAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import butterknife.Bind;
import me.murphy.common.base.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private List<NormalDetectionBean> interfaceList = new ArrayList<NormalDetectionBean>();
    private Map<String,String> params = new ConcurrentHashMap<String,String>();
    private LinearLayoutManager layoutManager;
    private OrderConfirmDetectionAdapter adapter;
    private String totalPrice;
    private ApiService service;

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
        service = APIServiceImpl.getInstance().createService(ApiService.class);
    }

    @Override
    public void initView() {
        toolbarTitle.setText("确认订单");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        dataList.clear();
        makeData();
        dataList = getIntent().getExtras().getParcelableArrayList("data");
        totalPrice = getIntent().getExtras().getString("amount");
        adapter = new OrderConfirmDetectionAdapter(dataList, getApplicationContext());
        rvDetectionData.setLayoutManager(layoutManager);
        rvDetectionData.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        tvTotalPrice.setText(getResources().getString(R.string.RMB)+totalPrice);
        tvXiaoji.setText(getResources().getString(R.string.RMB)+totalPrice);
        tvName.setText(getIntent().getExtras().getString("name"));
        tvPhone.setText(getIntent().getExtras().getString("phone"));
        tvEmail.setText(getIntent().getExtras().getString("email"));
        tvAddress.setText(getIntent().getExtras().getString("address"));
        btnPayOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commitOrder();
            }
        });
    }


    public void makeData(){
        interfaceList.clear();
        interfaceList.add(new NormalDetectionBean("1", "rtPCR检测","PCR_DETECTION", 100.00, 0));
        interfaceList.add(new NormalDetectionBean("2", "单核苷酸多态性分析","polymorphism_analysis", 800.00, 0));
        interfaceList.add(new NormalDetectionBean("3", "miRNA检测","miRNA_DETECTION", 260.00, 0));
        interfaceList.add(new NormalDetectionBean("4", "mRNA检测","RNA_DETECTION", 6000.00, 0));
        interfaceList.add(new NormalDetectionBean("5", "WB检测","WB_DETECTION", 1200.00, 0));
        interfaceList.add(new NormalDetectionBean("6", "ELISA检测","ELISA_DETECTION", 2500.00, 0));
        interfaceList.add(new NormalDetectionBean("7", "免疫组化检测","IHC", 80.00, 0));
        interfaceList.add(new NormalDetectionBean("8", "重组病毒构建、病毒包装与滴度测定","virus_construction", 18000.00, 0));
        interfaceList.add(new NormalDetectionBean("9", "原带/传代细胞的培养与分离","cell_separation", 12000.00, 0));
        interfaceList.add(new NormalDetectionBean("10", "细胞克隆技术","cell_clone", 20000.00, 0));
        interfaceList.add(new NormalDetectionBean("11", "细胞增殖/毒性检测","cell_proliferation", 2000.00, 0));
        interfaceList.add(new NormalDetectionBean("12", "细胞凋亡/周期检测","cell_apoptosis", 600.00, 0));
        interfaceList.add(new NormalDetectionBean("13", "细胞迁移/侵袭检测","cell_migration", 500.00, 0));
        interfaceList.add(new NormalDetectionBean("14", "细胞传染/传导实验","cell_transmission", 2500.00, 0));
        interfaceList.add(new NormalDetectionBean("15", "细胞稳定株的构建","cell_stable_construction", 16000.00, 0));
        interfaceList.add(new NormalDetectionBean("16", "流式细胞术","flow_cytometry", 100.00, 0));
        interfaceList.add(new NormalDetectionBean("17", "细胞免疫荧光检测技术","cell_immunofluorescence", 3500.00, 0));
        interfaceList.add(new NormalDetectionBean("18", "免疫/蛋白质印迹技术","proteinSouthernblot", 0.00, 0));
        interfaceList.add(new NormalDetectionBean("19", "酶联免疫吸附检测","enzyme_Linked", 0.00, 0));
        interfaceList.add(new NormalDetectionBean("20", "免疫荧光检测技术","immunofluorescenceDetection", 0.00, 0));
    }


    public void commitOrder(){
        params.clear();
        params.put("userid", User.getUser().getUserid());
        params.put("price",totalPrice);
        params.put("name",getIntent().getExtras().getString("name"));
        params.put("mobile",getIntent().getExtras().getString("phone"));
        params.put("email",getIntent().getExtras().getString("email"));
        params.put("address",getIntent().getExtras().getString("address"));
        for (int i = 0; i <interfaceList.size(); i++) {
            for (int j = 0; j <dataList.size() ; j++) {
                if (dataList.get(j).getId().equals(interfaceList.get(i).getId())){
                    interfaceList.get(i).setNumber(dataList.get(j).getNumber());
                }
                params.put(interfaceList.get(i).getDetection_field(),String.valueOf(interfaceList.get(i).getNumber()));
            }
        }
        Call<GarbageBean> call = service.addCommonDetection(params);
        call.enqueue(new Callback<GarbageBean>() {
            @Override
            public void onResponse(Call<GarbageBean> call, Response<GarbageBean> response) {
                if (response.body()!=null){
                    startActivity(CommitSuccessActivity.class);
                }
            }

            @Override
            public void onFailure(Call<GarbageBean> call, Throwable t) {

            }
        });
    }
}
