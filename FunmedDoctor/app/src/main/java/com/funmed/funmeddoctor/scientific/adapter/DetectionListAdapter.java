package com.funmed.funmeddoctor.scientific.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.NormalDetectionBean;
import com.funmed.funmeddoctor.scientific.activity.NormalDetectionActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2017/10/26.
 */

public class DetectionListAdapter extends BaseQuickAdapter<NormalDetectionBean,BaseViewHolder> {

    private String[] items = {"血液样本","细胞样本","......"};
    private Context context;
    private String title="";
    private List<NormalDetectionBean> data = new ArrayList<NormalDetectionBean>();
    public DetectionListAdapter(Context context,List<NormalDetectionBean> data,String title) {
        super(R.layout.item_second_normal_detection, data);
        this.context= context;
        this.title = title;
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, NormalDetectionBean item) {
        MyClickListener myClickListener = null;
        helper.setText(R.id.textItem,item.getName())
                .setText(R.id.tv_price,item.getPrice()+"");
        Spinner spinner = helper.getView(R.id.sp_yangben);
        spinner.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, items));
    }

    class MyClickListener implements View.OnClickListener {
        private int position;
        private View convertView;

        public MyClickListener(int position, View convertView) {
            this.position = position;
            this.convertView = convertView;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_add_count:
                    data.get(position).setNumber(data.get(position).getNumber() + 1);
                    notifyDataSetChanged();
                    break;
                case R.id.btn_sub_count:
                    data.get(position).setNumber(data.get(position).getNumber() - 1);
                    notifyDataSetChanged();
                    break;
            }
        }
    }
}
