package com.funmed.funmeddoctor.clinical.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.DetectionListBean;

import java.util.List;

/**
 * Created by tony on 2017/7/20.
 */

public class DetectionListAdapter extends BaseQuickAdapter<DetectionListBean,BaseViewHolder> {
    public DetectionListAdapter(List<DetectionListBean> data,Context context) {
        super(R.layout.item_detection_list,data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DetectionListBean item) {
        helper.setText(R.id.tv_item_detection,item.getDetectionName());
        ImageView imageView = helper.getView(R.id.iv_item_detection_arrow);
        imageView.setImageResource(R.mipmap.right_arrow);
    }
}
