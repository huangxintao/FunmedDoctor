package com.funmed.funmeddoctor.community.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.InfomationListBean;
import com.funmed.funmeddoctor.community.adapter.CommunityFragmentAdapter;
import com.funmed.funmeddoctor.network.APIServiceImplInfo;
import com.funmed.funmeddoctor.network.ApiService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/7/18.
 */

public class CommunityFragment extends BaseFragment {
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private ApiService service;
    private Map<String, String> params = new HashMap<String, String>();
    private int currentpage = 1;
    private int type = 1;
    private CommunityFragmentAdapter fragmentAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_community;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        service = APIServiceImplInfo.getInstance().createService(ApiService.class);
    }

    @Override
    protected void initView() {
        setupViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        tabLayout.setupWithViewPager(viewpager);
        tabLayout.getTabAt(0).setText(R.string.sub_health_product);
        tabLayout.getTabAt(1).setText(R.string.health_message);
        tabLayout.getTabAt(2).setText(R.string.hospital_info);
        tabLayout.getTabAt(3).setText(R.string.doctor_message);
    }

    private void setupViewPager() {
        fragmentAdapter = new CommunityFragmentAdapter(getChildFragmentManager());
        fragmentAdapter.addFragment(SubHealthFragment.newInstance(), getString(R.string.sub_health_product));
        fragmentAdapter.addFragment(HealthFragment.newInstance(), getString(R.string.health_message));
        fragmentAdapter.addFragment(HospitalFragment.newInstance(), getString(R.string.hospital_info));
        fragmentAdapter.addFragment(DoctorFragment.newInstance(), getString(R.string.doctor_message));
        viewpager.setAdapter(fragmentAdapter);
    }
}
