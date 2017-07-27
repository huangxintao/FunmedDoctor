package com.funmed.funmeddoctor.network;

import com.funmed.funmeddoctor.bean.BaseBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
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

    @FormUrlEncoded
    @POST("user/updatePwd.do")
    Call<BaseBean> updatePwd(@Field("old_password") String old_password,@Field("new_password") String new_password,
                             @Field("userid") String user_id);

    @FormUrlEncoded
    @POST("user/addUserInfo.do")
    Call<BaseBean> addUserInfo(@FieldMap Map<String,String> params);

    @FormUrlEncoded
    @POST("user/updateUserName.do")
    @Headers("Content-Type: application/x-www-form-urlencoded;charset=utf-8")
    Call<BaseBean> updateUserName (@FieldMap Map<String, String> params);
}
