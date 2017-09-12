package com.funmed.funmeddoctor.mine.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.AidResearchListBean;
import com.funmed.funmeddoctor.bean.User;
import com.funmed.funmeddoctor.community.adapter.AidResearchInfoAdapter;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/8/11.
 */

public class MyResearchActivity extends BaseActivity {
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_myresearch)
    RecyclerView rvMyresearch;
    @Bind(R.id.layout_myresearch_refresh)
    SwipeRefreshLayout layoutMyresearchRefresh;
    private ApiService service;
    private List<AidResearchListBean.DataBean> data = new ArrayList<AidResearchListBean.DataBean>();
    private AidResearchInfoAdapter adapter;
    private LinearLayoutManager layoutManager;
    private int currentpage = 1;
    private String title = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_research;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        service = APIServiceImpl.getInstance().createService(ApiService.class);
        layoutManager = new LinearLayoutManager(this);
    }

    @Override
    public void initView() {
        toolbarTitle.setText("我发起的");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        title = "我发起的";
        rvMyresearch.setLayoutManager(layoutManager);
        adapter = new AidResearchInfoAdapter(this, data, title);
        rvMyresearch.setAdapter(adapter);
        refreshData();

        layoutMyresearchRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                layoutMyresearchRefresh.setRefreshing(true);
                currentpage = 1;
                data.clear();
                refreshData();
            }
        });
    }

    private void refreshData() {
        Call<AidResearchListBean> call = service.findAidResearch(User.getUser().getUserid(), "1");
//        Call<AidResearchListBean> call = service.findAllResearch();
        call.enqueue(new Callback<AidResearchListBean>() {
            @Override
            public void onResponse(Call<AidResearchListBean> call, Response<AidResearchListBean> response) {
                if (response.body().getCode() == 0) {
                    data.addAll(response.body().getData());
                    adapter.notifyDataSetChanged();
                    layoutMyresearchRefresh.setRefreshing(false);
                    Call<AidResearchListBean> call1 = service.findAidResearch(User.getUser().getUserid(), "2");
//                    Call<AidResearchListBean> call = service.findAllResearch();
                    call1.enqueue(new Callback<AidResearchListBean>() {
                        @Override
                        public void onResponse(Call<AidResearchListBean> call, Response<AidResearchListBean> response) {
                            if (response.body().getCode() == 0) {
                                data.addAll(response.body().getData());
                                adapter.notifyDataSetChanged();
                                layoutMyresearchRefresh.setRefreshing(false);
                            }
                        }

                        @Override
                        public void onFailure(Call<AidResearchListBean> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<AidResearchListBean> call, Throwable t) {

            }
        });
    }
}
