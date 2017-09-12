package com.funmed.funmeddoctor.community.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.AidResearchListBean;
import com.funmed.funmeddoctor.bean.BaseBean;
import com.funmed.funmeddoctor.bean.InfomationListBean;
import com.funmed.funmeddoctor.bean.User;
import com.funmed.funmeddoctor.community.adapter.AidResearchInfoAdapter;
import com.funmed.funmeddoctor.community.adapter.HealthInfoAdapter;
import com.funmed.funmeddoctor.data.IConstants;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.APIServiceImplInfo;
import com.funmed.funmeddoctor.network.ApiService;

import java.util.ArrayList;
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
 * Created by tony on 2017/8/8.
 */

public class SubHealthFragment extends BaseFragment {

    @Bind(R.id.rv_subhealth)
    RecyclerView rvSubhealth;
    @Bind(R.id.layout_subhealth_refresh)
    SwipeRefreshLayout layoutSubhealthRefresh;
    private Map<String, String> params = new HashMap<String, String>();
    private int currentpage = 1;
    private ApiService service;
    private List<AidResearchListBean.DataBean> data = new ArrayList<AidResearchListBean.DataBean>();
    private AidResearchInfoAdapter adapter;
    private LinearLayoutManager layoutManager;
    int lastVisableItem;
    private String title;

    public static SubHealthFragment newInstance() {
        return new SubHealthFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_subhealth;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        service = APIServiceImpl.getInstance().createService(ApiService.class);
        layoutManager = new LinearLayoutManager(getContext());
    }

    @Override
    protected void initView() {
        data.clear();
        rvSubhealth.setLayoutManager(layoutManager);
        title = "研究进展";
        adapter = new AidResearchInfoAdapter(getContext(),data,title);
        rvSubhealth.setAdapter(adapter);
        refreshData();

        layoutSubhealthRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                layoutSubhealthRefresh.setRefreshing(true);
                currentpage=1;
                data.clear();
                refreshData();
            }
        });
//        rvSubhealth.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (newState==RecyclerView.SCROLL_STATE_IDLE &&lastVisableItem+1==adapter.getItemCount()){
//                    loadMoreData();
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                lastVisableItem = layoutManager.findLastVisibleItemPosition();
//            }
//        });
    }

    private void loadMoreData() {
        currentpage++;
        refreshData();
    }

    private void refreshData() {
//        Call<AidResearchListBean> call = service.findAidResearch(User.getUser().getUserid(),"1");
        Call<AidResearchListBean> call = service.findAllResearch();
        call.enqueue(new Callback<AidResearchListBean>() {
            @Override
            public void onResponse(Call<AidResearchListBean> call, Response<AidResearchListBean> response) {
                if (response.body().getCode() == 0) {
                    data.addAll(response.body().getData());
                    adapter.notifyDataSetChanged();
                    layoutSubhealthRefresh.setRefreshing(false);
                }
            }

            @Override
            public void onFailure(Call<AidResearchListBean> call, Throwable t) {

            }
        });
    }
}
