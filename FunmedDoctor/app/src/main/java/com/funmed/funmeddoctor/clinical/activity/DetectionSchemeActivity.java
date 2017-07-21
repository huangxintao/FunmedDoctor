package com.funmed.funmeddoctor.clinical.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.DetectionListBean;
import com.funmed.funmeddoctor.clinical.adapter.DetectionListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/7/18.
 */

public class DetectionSchemeActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_home_detection)
    RecyclerView rvHomeDetection;
    @Bind(R.id.rv_medical_detection)
    RecyclerView rvMedicalDetection;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager linearLayoutManager1;
    private DetectionListAdapter homeDetectionListAdapter;
    private DetectionListAdapter medicalDetectionListAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_detection_scheme;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        homeDetectionListAdapter = new DetectionListAdapter(getHomeDetectionListData(),getApplicationContext());
        medicalDetectionListAdapter = new DetectionListAdapter(getMedicalDetectonListData(),getApplicationContext());
    }


    @Override
    public void initView() {
        SetTranslanteBar();
        toolbar.setTitle("检测方案");
        setSupportActionBar(toolbar);
        rvHomeDetection.setLayoutManager(linearLayoutManager);
        rvHomeDetection.setAdapter(homeDetectionListAdapter);
        homeDetectionListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position){
                    case 0:
                        startActivity(SBKDetectionActivity.class);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });
        rvMedicalDetection.setLayoutManager(linearLayoutManager1);
        rvMedicalDetection.setAdapter(medicalDetectionListAdapter);
        medicalDetectionListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                }
            }
        });
    }

    private List<DetectionListBean> getHomeDetectionListData() {
        List<DetectionListBean> list = new ArrayList<DetectionListBean>();
        DetectionListBean detectionListBean= null;
        String[] names = {"苏贝康系统检测","望诊","问诊","样本送检"};
        for (int i = 0; i <4 ; i++) {
            detectionListBean = new DetectionListBean();
            detectionListBean.setDetectionName(names[i]);
            list.add(detectionListBean);
            detectionListBean = null;
        }
        return list;
    }

    private List<DetectionListBean> getMedicalDetectonListData() {
        List<DetectionListBean> list = new ArrayList<DetectionListBean>();
        DetectionListBean detectionListBean= null;
        String[] names = {"周边医院检测","体检中心检测"};
        for (int i = 0; i <2 ; i++) {
            detectionListBean = new DetectionListBean();
            detectionListBean.setDetectionName(names[i]);
            list.add(detectionListBean);
            detectionListBean = null;
        }
        return list;
    }
}
