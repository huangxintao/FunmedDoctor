package com.funmed.funmeddoctor.scientific.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.ScientificOrderTypeBean;

import java.util.List;

/**
 * Created by tony on 2017/7/21.
 */

public class ScientificOrderTypeAdapter extends BaseQuickAdapter<ScientificOrderTypeBean,BaseViewHolder> {
    public ScientificOrderTypeAdapter(List<ScientificOrderTypeBean> data) {
        super(R.layout.item_scientific_order_type, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ScientificOrderTypeBean item) {
        helper.setText(R.id.tv_scientific_type_name,item.getTypeName());
    }
}
