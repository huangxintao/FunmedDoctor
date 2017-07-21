package com.funmed.funmeddoctor.clinical.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.ClinicalDataBean;
import com.funmed.funmeddoctor.clinical.activity.DetectionSchemeActivity;
import com.funmed.funmeddoctor.clinical.adapter.ClinicalDataAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.murphy.common.base.BaseFragment;

/**
 * Created by tony on 2017/7/18.
 */

public class ClinicalFragement extends BaseFragment {
    @Bind(R.id.iv_clinical_data)
    ImageView ivClinicalData;
    @Bind(R.id.rv_clinical_data)
    RecyclerView rvClinicalData;
    private GridLayoutManager gridLayoutManager;
    private ClinicalDataAdapter clinicalDataAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_clinical;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {
        gridLayoutManager = new GridLayoutManager(getContext(), 4);
        clinicalDataAdapter = new ClinicalDataAdapter(getData(), getContext());
        clinicalDataAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //跳转到数据页面
                switch (position) {
                    case 0:
                        startActivity(DetectionSchemeActivity.class);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
        });
        rvClinicalData.setLayoutManager(gridLayoutManager);
        rvClinicalData.setAdapter(clinicalDataAdapter);
    }

    private List<ClinicalDataBean> getData() {
        List<ClinicalDataBean> data = new ArrayList<ClinicalDataBean>();
        ClinicalDataBean clinicalDataBean = null;
        String[] names = {"检测方案", "检测数据", "健康教育", "工作报酬", "评论建议"};
        for (int i = 0; i < 5; i++) {
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
