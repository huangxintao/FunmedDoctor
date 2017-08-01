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

import com.funmed.funmeddoctor.R;

import butterknife.Bind;

/**
 * Created by tony on 2017/7/31.
 */

public class MainSectionedAdapter extends SectionedBaseAdapter {
    @Bind(R.id.imageItem)
    ImageView imageItem;
    @Bind(R.id.textItem)
    TextView textItem;
    @Bind(R.id.tv_price_name)
    TextView tvPriceName;
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

    public MainSectionedAdapter(Context context, String[] leftStr, String[][] rightStr) {
        this.mContext = context;
        this.leftStr = leftStr;
        this.rightStr = rightStr;
    }

    @Override
    public Object getItem(int section, int position) {
        return rightStr[section][position];
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
        return rightStr[section].length;
    }

    @Override
    public View getItemView(final int section, final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.right_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.btnAddCount = convertView.findViewById(R.id.btn_add_count);
            viewHolder.btnAddCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewHolder.btnSubCount.setVisibility(View.VISIBLE);
                    viewHolder.number++;
                    viewHolder.tvNumber.setText(String.valueOf(viewHolder.number));
                }
            });
            viewHolder.btnSubCount = convertView.findViewById(R.id.btn_sub_count);
            viewHolder.btnSubCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewHolder.number--;
                    viewHolder.tvNumber.setText(String.valueOf(viewHolder.number));
                }
            });
            viewHolder.textItem = convertView.findViewById(R.id.textItem);
            viewHolder.tvNumber = convertView.findViewById(R.id.tv_number);
            viewHolder.tvPrice = convertView.findViewById(R.id.tv_price);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textItem.setText(rightStr[section][position]);
        viewHolder.tvNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if ("0".equals(viewHolder.tvNumber.getText().toString())) {
                    viewHolder.btnSubCount.setVisibility(View.GONE);
                } else {
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
                Toast.makeText(mContext, rightStr[section][position], Toast.LENGTH_SHORT).show();
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
        @Bind(R.id.tv_price_name)
        TextView tvPriceName;
        @Bind(R.id.tv_price)
        TextView tvPrice;
        @Bind(R.id.btn_sub_count)
        Button btnSubCount;
        @Bind(R.id.tv_number)
        TextView tvNumber;
        @Bind(R.id.btn_add_count)
        Button btnAddCount;
        int number =0;
    }
}
