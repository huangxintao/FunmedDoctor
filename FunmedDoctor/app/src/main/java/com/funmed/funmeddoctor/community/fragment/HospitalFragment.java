package com.funmed.funmeddoctor.community.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.InfomationListBean;
import com.funmed.funmeddoctor.community.adapter.HealthInfoAdapter;
import com.funmed.funmeddoctor.data.IConstants;
import com.funmed.funmeddoctor.network.APIServiceImplInfo;
import com.funmed.funmeddoctor.network.ApiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import me.murphy.common.base.BaseFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/8/8.
 */

public class HospitalFragment extends BaseFragment {

    @Bind(R.id.rv_hospital)
    RecyclerView rvHospital;
    @Bind(R.id.layout_hospital_refresh)
    SwipeRefreshLayout layoutHospitalRefresh;
    private Map<String, String> params = new HashMap<String, String>();
    private int currentpage = 1;
    private ApiService service;
    private List<InfomationListBean.DataBean.InformationsBean> data = new ArrayList<InfomationListBean.DataBean.InformationsBean>();
    private HealthInfoAdapter adapter;
    private LinearLayoutManager layoutManager;
    int lastVisableItem;
    private String title;

    public static HospitalFragment newInstance() {
        return new HospitalFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_hospital;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        service = APIServiceImplInfo.getInstance().createService(ApiService.class);
        layoutManager = new LinearLayoutManager(getContext());
    }

    @Override
    protected void initView() {
        rvHospital.setLayoutManager(layoutManager);
        title = "医院信息";
        adapter = new HealthInfoAdapter(getContext(), data,title);
        rvHospital.setAdapter(adapter);
        refreshData();

        layoutHospitalRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                layoutHospitalRefresh.setRefreshing(true);
                currentpage = 1;
                data.clear();
                refreshData();
            }
        });
        rvHospital.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisableItem + 1 == adapter.getItemCount()) {
                    loadMoreData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisableItem = layoutManager.findLastVisibleItemPosition();
            }
        });
    }

    private void loadMoreData() {
        currentpage++;
        refreshData();
    }

    private void refreshData() {
        params.clear();
        params.put("nowpage", currentpage + "");
        params.put("size", "10");
        params.put("type", IConstants.TYPE_HOSPITAL + "");
        Call<InfomationListBean> call = service.getMessage(params);
        call.enqueue(new Callback<InfomationListBean>() {
            @Override
            public void onResponse(Call<InfomationListBean> call, Response<InfomationListBean> response) {
                if (response.body().getCode() == 0) {
                    data.addAll(response.body().getData().getInformations());
                    adapter.notifyDataSetChanged();
                    layoutHospitalRefresh.setRefreshing(false);
                }
            }

            @Override
            public void onFailure(Call<InfomationListBean> call, Throwable t) {

            }
        });
    }
}
