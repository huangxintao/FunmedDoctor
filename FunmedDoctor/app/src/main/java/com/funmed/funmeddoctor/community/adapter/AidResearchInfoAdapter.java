package com.funmed.funmeddoctor.community.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.AidResearchListBean;
import com.funmed.funmeddoctor.community.activity.AidResearchDetailActivity;
import com.funmed.funmeddoctor.community.activity.MsgInfoDetailActivity;

import java.util.List;

import me.murphy.common.commonutils.TimeUtil;

/**
 * Created by tony on 2017/8/10.
 */

public class AidResearchInfoAdapter extends BaseQuickAdapter<AidResearchListBean.DataBean,BaseViewHolder> {
    private String title="";
    private Context mContext;
    public AidResearchInfoAdapter(Context context, List<AidResearchListBean.DataBean> data, String title) {
        super(R.layout.item_aid_research_info,data);
        this.mContext = context;
        this.title = title;
    }


    @Override
    protected void convert(BaseViewHolder helper, final AidResearchListBean.DataBean item) {
        helper.setText(R.id.titleTextView,item.getDiseaser_name())
                .setText(R.id.dateItemView, TimeUtil.formatData("yyyy-MM-dd hh:mm:ss",item.getUpdate_time()/1000));
        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,AidResearchDetailActivity.class);
                intent.putExtra("data",item);
                mContext.startActivity(intent);
            }
        });
    }
}
