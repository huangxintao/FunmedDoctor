package com.funmed.funmeddoctor.community.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.InfomationListBean;
import com.funmed.funmeddoctor.community.activity.MsgInfoDetailActivity;
import com.funmed.funmeddoctor.data.IConstants;

import java.util.List;

import me.murphy.common.commonutils.ImageLoaderUtils;

/**
 * Created by tony on 2017/8/8.
 */

public class HealthInfoAdapter extends BaseQuickAdapter<InfomationListBean.DataBean.InformationsBean,BaseViewHolder> {
    private Context context;
    private String title="";

    public HealthInfoAdapter(Context context,List<InfomationListBean.DataBean.InformationsBean> data,String title) {
        super(R.layout.item_health_info,data);
        this.context = context;
        this.title=title;
    }

    @Override
    protected void convert(BaseViewHolder helper, final InfomationListBean.DataBean.InformationsBean item) {
        helper.setText(R.id.titleTextView,item.getTitle())
                .setText(R.id.dateItemView,item.getDatetime());
        ImageView imageView = helper.getView(R.id.leftImage);
        ImageLoaderUtils.display(context,imageView, IConstants.RequestUrl.BASE_PICTURE_URL_SITE+item.getImagepath());
        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MsgInfoDetailActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("informationid",item.getInformationid()+"");
                context.startActivity(intent);
            }
        });
    }
}
