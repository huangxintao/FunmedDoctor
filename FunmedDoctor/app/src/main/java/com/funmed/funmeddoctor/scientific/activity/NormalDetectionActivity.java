package com.funmed.funmeddoctor.scientific.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.NormalDetectionBean;
import com.funmed.funmeddoctor.widget.PinnedHeaderListView;
import com.funmed.funmeddoctor.widget.adapter.LeftListAdapter;
import com.funmed.funmeddoctor.widget.adapter.MainSectionedAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.murphy.common.base.BaseActivity;
import me.murphy.common.commonutils.MoneyUtil;

/**
 * Created by tony on 2017/7/21.
 */

public class NormalDetectionActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.left_listview)
    ListView leftListview;
    @Bind(R.id.pinnedListView)
    PinnedHeaderListView pinnedListView;
    @Bind(R.id.tv_total_price)
    TextView tvTotalPrice;
    @Bind(R.id.btn_commit_order)
    Button btnCommitOrder;
    private boolean isScroll = true;
    private LeftListAdapter adapter;
    private double totalPrice = 0;

    private String[] leftStr = new String[]{"核酸检测", "蛋白检测", "细胞检测", "高端检测"};
    private boolean[] flagArray = {true, false, false, false, false, false, false, false, false};
    private String[][] rightStr = new String[][]{
            {"rtPCR检测", "单核苷酸多态性分析", "miRNA检测", "mRNA检测"},
            {"WB检测", "ELISA检测", "免疫组化检测"},
            {"重组病毒构建、病毒包装与滴度测定", "原带/传代细胞的培养与分离",
                    "细胞克隆技术", "细胞增殖/毒性检测",
                    "细胞凋亡/周期检测", "细胞迁移/侵袭检测", "细胞传染/传导实验", "细胞稳定株的构建",
                    "流式细胞术", "细胞免疫荧光检测技术"},
            {"单细胞外显子测序", "单细胞转录组测序", "血小板转录组测序"}
    };
    private List<List<NormalDetectionBean>> rigrtData = new ArrayList<List<NormalDetectionBean>>();
    private List<NormalDetectionBean> data = new ArrayList<NormalDetectionBean>();


    @Override
    public int getLayoutId() {
        return R.layout.activity_normal_detection;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        toolbarTitle.setText("常规检测");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        pinnedListView = (PinnedHeaderListView) findViewById(R.id.pinnedListView);
        makeData();
        final MainSectionedAdapter sectionedAdapter = new MainSectionedAdapter(this, leftStr, rigrtData);
        pinnedListView.setAdapter(sectionedAdapter);
        adapter = new LeftListAdapter(this, leftStr, flagArray);
        leftListview.setAdapter(adapter);
        leftListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                isScroll = false;

                for (int i = 0; i < leftStr.length; i++) {
                    if (i == position) {
                        flagArray[i] = true;
                    } else {
                        flagArray[i] = false;
                    }
                }
                adapter.notifyDataSetChanged();
                int rightSection = 0;
                for (int i = 0; i < position; i++) {
                    rightSection += sectionedAdapter.getCountForSection(i) + 1;
                }
                pinnedListView.setSelection(rightSection);

            }

        });

        pinnedListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView arg0, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (pinnedListView.getLastVisiblePosition() == (pinnedListView.getCount() - 1)) {
                            leftListview.setSelection(ListView.FOCUS_DOWN);
                        }

                        // 判断滚动到顶部
                        if (pinnedListView.getFirstVisiblePosition() == 0) {
                            leftListview.setSelection(0);
                        }

                        break;
                }
            }

            int y = 0;
            int x = 0;
            int z = 0;

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (isScroll) {
                    for (int i = 0; i < rightStr.length; i++) {
                        if (i == sectionedAdapter.getSectionForPosition(pinnedListView.getFirstVisiblePosition())) {
                            flagArray[i] = true;
                            x = i;
                        } else {
                            flagArray[i] = false;
                        }
                    }
                    if (x != y) {
                        adapter.notifyDataSetChanged();
                        y = x;
                        if (y == leftListview.getLastVisiblePosition()) {
//                            z = z + 3;
                            leftListview.setSelection(z);
                        }
                        if (x == leftListview.getFirstVisiblePosition()) {
//                            z = z - 1;
                            leftListview.setSelection(z);
                        }
                        if (firstVisibleItem + visibleItemCount == totalItemCount - 1) {
                            leftListview.setSelection(ListView.FOCUS_DOWN);
                        }
                    }
                } else {
                    isScroll = true;
                }
            }
        });

        btnCommitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                data.clear();
                for (int i = 0; i < rigrtData.size(); i++) {
                    for (int j = 0; j < rigrtData.get(i).size(); j++) {
                        if (rigrtData.get(i).get(j).getNumber() != 0) {
                            data.add(rigrtData.get(i).get(j));
                        }
                    }
                }
                if (data.size() > 0) {
                    bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) data);
                    bundle.putString("amount", String.valueOf(totalPrice));
                    startActivity(DetectionUserInfoUploadActivity.class, bundle);
                }else {
                    bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) data);
                    bundle.putString("amount", String.valueOf(totalPrice));
                    startActivity(DetectionUserInfoUploadActivity.class, bundle);
//                    Toast.makeText(mContext, "请选择检测指标", Toast.LENGTH_SHORT).show();
                }
//                startActivity(NormalDetectionConfirmActivity.class, bundle);
            }
        });
    }

    private void makeData() {
        List<NormalDetectionBean> subData1 = new ArrayList<>();
        subData1.add(new NormalDetectionBean("1", "rtPCR检测", 120.00, 0, R.mipmap.detection1));
        subData1.add(new NormalDetectionBean("2", "单核苷酸多态性分析", 120.00, 0, R.mipmap.detection2));
        subData1.add(new NormalDetectionBean("3", "miRNA检测", 120.00, 0, R.mipmap.detection3));
        subData1.add(new NormalDetectionBean("4", "mRNA检测", 120.00, 0, R.mipmap.detection4));

        List<NormalDetectionBean> subData2 = new ArrayList<>();
        subData2.add(new NormalDetectionBean("5", "WB检测", 120.00, 0, R.mipmap.detection5));
        subData2.add(new NormalDetectionBean("6", "ELISA检测", 120.00, 0, R.mipmap.detection6));
        subData2.add(new NormalDetectionBean("7", "免疫组化检测", 120.00, 0, R.mipmap.detection7));

        List<NormalDetectionBean> subData3 = new ArrayList<>();
        subData3.add(new NormalDetectionBean("8", "重组病毒构建、病毒包装与滴度测定", 400.00, 0, R.mipmap.detection8));
        subData3.add(new NormalDetectionBean("9", "原带/传代细胞的培养与分离", 400.00, 0, R.mipmap.detection9));
        subData3.add(new NormalDetectionBean("10", "细胞克隆技术", 400.00, 0, R.mipmap.detection10));
        subData3.add(new NormalDetectionBean("11", "细胞增殖/毒性检测", 400.00, 0, R.mipmap.detection11));
        subData3.add(new NormalDetectionBean("12", "细胞凋亡/周期检测", 400.00, 0, R.mipmap.detection12));
        subData3.add(new NormalDetectionBean("13", "细胞迁移/侵袭检测", 400.00, 0, R.mipmap.detection13));
        subData3.add(new NormalDetectionBean("14", "细胞传染/传导实验", 400.00, 0, R.mipmap.detection14));
        subData3.add(new NormalDetectionBean("15", "细胞稳定株的构建", 400.00, 0, R.mipmap.detection15));
        subData3.add(new NormalDetectionBean("16", "流式细胞术", 400.00, 0, R.mipmap.detection16));
        subData3.add(new NormalDetectionBean("17", "细胞免疫荧光检测技术", 400.00, 0, R.mipmap.detection17));

        List<NormalDetectionBean> subData4 = new ArrayList<>();
        subData4.add(new NormalDetectionBean("18", "单细胞外显子测序", 4000.00, 0, R.mipmap.detection17));
        subData4.add(new NormalDetectionBean("19", "单细胞转录组测序", 6000.00, 0, R.mipmap.detection17));
        subData4.add(new NormalDetectionBean("20", "血小板转录组测序", 4500.00, 0, R.mipmap.detection17));

        rigrtData.add(subData1);
        rigrtData.add(subData2);
        rigrtData.add(subData3);
        rigrtData.add(subData4);
    }

    public void updateTotalPrice(List<List<NormalDetectionBean>> data) {
        this.rigrtData = data;
        totalPrice = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                totalPrice += data.get(i).get(j).getPrice() * data.get(i).get(j).getNumber();
            }
        }
//        tvTotalPrice.setText("¥"+String.valueOf(totalPrice));
        tvTotalPrice.setText(MoneyUtil.MoneyFomatWithTwoPoint(totalPrice));
    }
}
