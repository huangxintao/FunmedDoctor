package com.funmed.funmeddoctor.widget.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.NormalDetectionBean;
import com.funmed.funmeddoctor.scientific.activity.NormalDetectionActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.murphy.common.commonutils.ImageLoaderUtils;

/**
 * Created by tony on 2017/7/31.
 */

public class MainSectionedAdapter extends SectionedBaseAdapter {
    @Bind(R.id.imageItem)
    ImageView imageItem;
    @Bind(R.id.textItem)
    TextView textItem;
    @Bind(R.id.tv_price)
    TextView tvPrice;
    @Bind(R.id.btn_sub_count)
    Button btnSubCount;
    @Bind(R.id.tv_number)
    TextView tvNumber;
    @Bind(R.id.btn_add_count)
    Button btnAddCount;
    private Context mContext;
    private String[] leftStr;
    private String[][] rightStr;
    private List<List<NormalDetectionBean>> rightData = new ArrayList<List<NormalDetectionBean>>();
    private List<NormalDetectionBean> priceData = new ArrayList<NormalDetectionBean>();

    public MainSectionedAdapter(Context context, String[] leftStr, String[][] rightStr) {
        this.mContext = context;
        this.leftStr = leftStr;
        this.rightStr = rightStr;
    }

    public MainSectionedAdapter(Context context, String[] leftStr, List<List<NormalDetectionBean>> rightData) {
        this.mContext = context;
        this.leftStr = leftStr;
        this.rightData = rightData;
    }

    @Override
    public Object getItem(int section, int position) {
        return rightData.get(section).get(position);
    }

    @Override
    public long getItemId(int section, int position) {
        return position;
    }

    @Override
    public int getSectionCount() {
        return leftStr.length;
    }

    @Override
    public int getCountForSection(int section) {
        return rightData.get(section).size();
    }

    @Override
    public View getItemView(final int section, final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        final NormalDetectionBean normalDetectionBean = rightData.get(section).get(position);
        MyClickListener myClickListener = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.right_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.btnAddCount = convertView.findViewById(R.id.btn_add_count);
            viewHolder.btnSubCount = convertView.findViewById(R.id.btn_sub_count);
            viewHolder.textItem = convertView.findViewById(R.id.textItem);
            viewHolder.tvNumber = convertView.findViewById(R.id.tv_number);
            viewHolder.tvPrice = convertView.findViewById(R.id.tv_price);
            viewHolder.imageItem = convertView.findViewById(R.id.imageItem);
//            viewHolder.btnAddCount.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    view.getTag();
//                    normalDetectionBean.setNumber(normalDetectionBean.getNumber()+1);
//                    notifyDataSetChanged();
////                    viewHolder.btnSubCount.setVisibility(View.VISIBLE);
////                    viewHolder.tvNumber.setText(String.valueOf(normalDetectionBean.getNumber()));
//                }
//            });
//            viewHolder.btnSubCount.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    normalDetectionBean.setNumber(normalDetectionBean.getNumber()-1);
//                    viewHolder.tvNumber.setText(String.valueOf(normalDetectionBean.getNumber()));
//                }
//            });


            convertView.setTag(viewHolder);
            viewHolder.tvNumber.setTag(normalDetectionBean);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.tvNumber.setTag(normalDetectionBean);
            viewHolder.btnSubCount.setTag(normalDetectionBean);
            viewHolder.btnAddCount.setTag(normalDetectionBean);
        }

        myClickListener = new MyClickListener(section, position, convertView);
        viewHolder.btnSubCount.setTag(normalDetectionBean);
        viewHolder.btnAddCount.setOnClickListener(myClickListener);
        viewHolder.btnSubCount.setTag(normalDetectionBean);
        viewHolder.btnSubCount.setOnClickListener(myClickListener);

        viewHolder.textItem.setText(normalDetectionBean.getName());
        viewHolder.tvPrice.setText("¥" + String.valueOf(normalDetectionBean.getPrice()));
        viewHolder.tvNumber.setText(String.valueOf(normalDetectionBean.getNumber()));
        viewHolder.imageItem.setImageResource(normalDetectionBean.getImageResource());
        if (normalDetectionBean.getNumber() == 0) {
            viewHolder.btnSubCount.setVisibility(View.GONE);
            viewHolder.tvNumber.setVisibility(View.GONE);
        } else {
            viewHolder.btnSubCount.setVisibility(View.VISIBLE);
            viewHolder.tvNumber.setVisibility(View.VISIBLE);
        }
        viewHolder.tvNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (normalDetectionBean.getNumber() == 0) {
                    viewHolder.btnSubCount.setVisibility(View.GONE);
                    viewHolder.tvNumber.setVisibility(View.GONE);
                } else {
                    viewHolder.tvNumber.setVisibility(View.VISIBLE);
                    viewHolder.btnSubCount.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(mContext, rightData.get(section).get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflator.inflate(R.layout.header_item, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        layout.setClickable(false);
        ((TextView) layout.findViewById(R.id.textItem)).setText(leftStr[section]);
        return layout;
    }

    class ViewHolder {
        @Bind(R.id.imageItem)
        ImageView imageItem;
        @Bind(R.id.textItem)
        TextView textItem;
        @Bind(R.id.tv_price)
        TextView tvPrice;
        @Bind(R.id.btn_sub_count)
        Button btnSubCount;
        @Bind(R.id.tv_number)
        TextView tvNumber;
        @Bind(R.id.btn_add_count)
        Button btnAddCount;
    }

    class MyClickListener implements View.OnClickListener {
        private int section;
        private int position;
        private View convertView;

        public MyClickListener(int section, int position, View convertView) {
            this.section = section;
            this.position = position;
            this.convertView = convertView;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_add_count:
                    rightData.get(section).get(position).setNumber(rightData.get(section).get(position).getNumber() + 1);
                    ((NormalDetectionActivity) mContext).updateTotalPrice(rightData);
                    notifyDataSetChanged();
                    break;
                case R.id.btn_sub_count:
                    rightData.get(section).get(position).setNumber(rightData.get(section).get(position).getNumber() - 1);
                    ((NormalDetectionActivity) mContext).updateTotalPrice(rightData);
                    notifyDataSetChanged();
                    break;
            }
        }
    }
}
