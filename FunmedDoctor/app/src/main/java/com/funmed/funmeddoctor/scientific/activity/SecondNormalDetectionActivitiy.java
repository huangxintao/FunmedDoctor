package com.funmed.funmeddoctor.scientific.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.NormalDetectionBean;
import com.funmed.funmeddoctor.scientific.adapter.DetectionListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/10/25.
 */

public class SecondNormalDetectionActivitiy extends BaseActivity {
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.rv_detection)
    RecyclerView rvDetection;
    private LinearLayoutManager layoutManager;
    private FragmentPagerAdapter fragmentAdapter;
    private List<List<NormalDetectionBean>> rigrtData = new ArrayList<List<NormalDetectionBean>>();
    private DetectionListAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_second_detection;
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
        initTabLayout();
        setupViewPager();
        makeData();
        layoutManager = new LinearLayoutManager(this);
        adapter = new DetectionListAdapter(SecondNormalDetectionActivitiy.this,rigrtData.get(0),"核酸检测");
        rvDetection.setLayoutManager(layoutManager);
        rvDetection.setAdapter(adapter);
    }

    private void initTabLayout() {
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        tabLayout.setupWithViewPager(viewpager);
        tabLayout.getTabAt(0).setText("核酸检测");
        tabLayout.getTabAt(1).setText("蛋白检测");
        tabLayout.getTabAt(2).setText("细胞检测");
        tabLayout.getTabAt(3).setText("高端检测");
    }

    private void setupViewPager() {
    }

    private void makeData() {
        List<NormalDetectionBean> subData1 = new ArrayList<>();
        subData1.add(new NormalDetectionBean("1", "rtPCR检测", 100.00, 0, R.mipmap.detection1));
        subData1.add(new NormalDetectionBean("2", "单核苷酸多态性分析", 800.00, 0, R.mipmap.detection2));
        subData1.add(new NormalDetectionBean("3", "miRNA检测", 260.00, 0, R.mipmap.detection3));
        subData1.add(new NormalDetectionBean("4", "mRNA检测", 6000.00, 0, R.mipmap.detection4));

        List<NormalDetectionBean> subData2 = new ArrayList<>();
        subData2.add(new NormalDetectionBean("5", "WB检测", 1200.00, 0, R.mipmap.detection5));
        subData2.add(new NormalDetectionBean("6", "ELISA检测", 2500.00, 0, R.mipmap.detection6));
        subData2.add(new NormalDetectionBean("7", "免疫组化检测", 80.00, 0, R.mipmap.detection7));

        List<NormalDetectionBean> subData3 = new ArrayList<>();
        subData3.add(new NormalDetectionBean("8", "重组病毒构建、病毒包装与滴度测定", 18000.00, 0, R.mipmap.detection8));
        subData3.add(new NormalDetectionBean("9", "原带/传代细胞的培养与分离", 12000.00, 0, R.mipmap.detection9));
        subData3.add(new NormalDetectionBean("10", "细胞克隆技术", 20000.00, 0, R.mipmap.detection10));
        subData3.add(new NormalDetectionBean("11", "细胞增殖/毒性检测", 2000.00, 0, R.mipmap.detection11));
        subData3.add(new NormalDetectionBean("12", "细胞凋亡/周期检测", 600.00, 0, R.mipmap.detection12));
        subData3.add(new NormalDetectionBean("13", "细胞迁移/侵袭检测", 500.00, 0, R.mipmap.detection13));
        subData3.add(new NormalDetectionBean("14", "细胞传染/传导实验", 2500.00, 0, R.mipmap.detection14));
        subData3.add(new NormalDetectionBean("15", "细胞稳定株的构建", 16000.00, 0, R.mipmap.detection15));
        subData3.add(new NormalDetectionBean("16", "流式细胞术", 100.00, 0, R.mipmap.detection16));
        subData3.add(new NormalDetectionBean("17", "细胞免疫荧光检测技术", 3500.00, 0, R.mipmap.detection17));

        List<NormalDetectionBean> subData4 = new ArrayList<>();
        subData4.add(new NormalDetectionBean("18", "单细胞测序", 6000.00, 0, R.mipmap.detection17));
        subData4.add(new NormalDetectionBean("19", "流行病调查", 3500.00, 0, R.mipmap.detection17));
        subData4.add(new NormalDetectionBean("20", "出院后随机调查", 3500.00, 0, R.mipmap.detection17));
        subData4.add(new NormalDetectionBean("21", "定制特定疾病生物样本库", 3500.00, 0, R.mipmap.detection17));

        rigrtData.add(subData1);
        rigrtData.add(subData2);
        rigrtData.add(subData3);
        rigrtData.add(subData4);
    }

}
