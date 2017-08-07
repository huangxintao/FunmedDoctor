package com.funmed.funmeddoctor.scientific.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.ClinicalDataBean;
import com.funmed.funmeddoctor.clinical.adapter.ClinicalDataAdapter;
import com.funmed.funmeddoctor.scientific.activity.CooperationResearchActivity;
import com.funmed.funmeddoctor.scientific.activity.ScientificProjectOrderPlaceActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseFragment;

/**
 * Created by tony on 2017/7/18.
 */

public class ScientificFragment extends BaseFragment {

    @Bind(R.id.iv_scientific_data)
    ImageView ivScientificData;
    @Bind(R.id.rv_scientific_data)
    RecyclerView rvScientificData;
    private GridLayoutManager gridLayoutManager;
    private ClinicalDataAdapter scientificlDataAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_scientific;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        gridLayoutManager = new GridLayoutManager(getContext(),4);
        scientificlDataAdapter = new ClinicalDataAdapter(getData(),getContext());
        scientificlDataAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position){
                    case 0:
                        startActivity(ScientificProjectOrderPlaceActivity.class);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        startActivity(CooperationResearchActivity.class);
                        break;
                }
            }
        });
        rvScientificData.setLayoutManager(gridLayoutManager);
        rvScientificData.setAdapter(scientificlDataAdapter);
    }

    private List<ClinicalDataBean> getData() {
        List<ClinicalDataBean> data = new ArrayList<ClinicalDataBean>();
        ClinicalDataBean clinicalDataBean = null;
        String[] names = {"科研项目下单", "统计分析", "项目订单查询","发起互助式研究"};
        for (int i = 0; i < names.length; i++) {
            clinicalDataBean = new ClinicalDataBean();
            clinicalDataBean.setDataId(i + "");
            clinicalDataBean.setDataName(names[i]);
            clinicalDataBean.setDataImg(R.mipmap.teacher);
            data.add(clinicalDataBean);
            clinicalDataBean = null;
        }
        return data;
    }
}
