package com.funmed.funmeddoctor.clinical.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.ClinicalDataBean;

import java.util.List;

/**
 * Created by tony on 2017/7/19.
 */

public class ClinicalDataAdapter extends BaseQuickAdapter<ClinicalDataBean,BaseViewHolder> {

    public ClinicalDataAdapter(List<ClinicalDataBean> data,Context context) {
        super(R.layout.item_clinical_data,data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ClinicalDataBean item) {
        helper.setText(R.id.itemName,item.getDataName());
        ImageView imageView = helper.getView(R.id.itemIcon);
        imageView.setImageResource(R.mipmap.teacher);
    }
}
