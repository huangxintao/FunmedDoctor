package com.funmed.funmeddoctor.network;

import com.funmed.funmeddoctor.bean.BaseBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by tony on 2017/7/17.
 */

public interface ApiService {
    String BASE_URL = "http://www.sup-heal.com:8080/FunengSR/";
    /**
     * 首页
     *
     * @return
     */
    @FormUrlEncoded
    @POST("user/register.do")
    Call<BaseBean> register(@Field("username") String username, @Field("password") String password,
                                  @Field("mobile") String mobile, @Field("checkCode") String checkCode);

    @FormUrlEncoded
    @POST("user/checkCode.do")
    Call<BaseBean> getCheckCode(@Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("user/login.do")
    Call<BaseBean> login(@Field("username") String username,@Field("password") String password);

    @FormUrlEncoded
    @POST("user/forgetPwd.do")
    Call<BaseBean> forgetPwd(@Field("username") String username, @Field("password") String password,
                             @Field("mobile") String mobile, @Field("checkCode") String checkCode);
}
