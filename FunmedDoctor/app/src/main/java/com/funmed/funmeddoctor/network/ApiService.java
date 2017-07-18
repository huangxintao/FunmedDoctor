package com.funmed.funmeddoctor.network;

import com.funmed.funmeddoctor.bean.BaseBean;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by huangxintao on 2017/7/17.
 */

public interface ApiService {
    String BASE_URL = "http://121.40.169.248:8010/FunengSBK/";
    /**
     * 首页
     *
     * @return
     */
    @FormUrlEncoded
    @POST("user/register.do")
    Observable<BaseBean> register(@Field("username") String username, @Field("password") String password,
                                  @Field("mobile") String mobile, @Field("checkCode") String checkCode);

    @FormUrlEncoded
    @POST("user/checkCode.do")
    Observable<BaseBean> getCheckCode(@Field("mobile") String mobile);
}
