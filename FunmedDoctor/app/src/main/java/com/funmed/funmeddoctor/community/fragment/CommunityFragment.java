package com.funmed.funmeddoctor.community.fragment;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.BaseBean;
import com.funmed.funmeddoctor.bean.InfomationListBean;
import com.funmed.funmeddoctor.data.IConstants;
import com.funmed.funmeddoctor.network.APIServiceImplInfo;
import com.funmed.funmeddoctor.network.ApiService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.murphy.common.base.BaseFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/7/18.
 */

public class CommunityFragment extends BaseFragment {
    private ApiService service;
    private Map<String,String> params = new HashMap<String,String>();
    private int currentpage=1;
    private int type=1;

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
        params.put("nowpage",currentpage+"");
        params.put("size","10");
        params.put("type",type+"");
        Call<InfomationListBean> call = service.getMessage(params);
        call.enqueue(new Callback<InfomationListBean>() {
            @Override
            public void onResponse(Call<InfomationListBean> call, Response<InfomationListBean> response) {
                if (response.code()==0){
                    List<InfomationListBean.DataBean.InformationsBean> data = (List<InfomationListBean.DataBean.InformationsBean>) response.body().getData();
                }
            }

            @Override
            public void onFailure(Call<InfomationListBean> call, Throwable t) {

            }
        });
    }
}
