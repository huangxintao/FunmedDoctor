package com.funmed.funmeddoctor.scientific.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.NormalDetectionBean;

import java.util.List;

/**
 * Created by tony on 2017/8/4.
 */

public class OrderConfirmDetectionAdapter extends BaseQuickAdapter<NormalDetectionBean,BaseViewHolder> {
    public OrderConfirmDetectionAdapter(List<NormalDetectionBean> data, Context context) {
        super(R.layout.item_order_confirm_detection, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, NormalDetectionBean item) {
        helper.setText(R.id.tv_detection_name,item.getName())
                .setText(R.id.tv_detection_money,String.valueOf(item.getPrice()))
                .setText(R.id.tv_detection_number,String.valueOf(item.getNumber()));
    }
}
