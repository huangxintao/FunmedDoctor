package com.funmed.funmeddoctor.network;

import com.funmed.funmeddoctor.bean.BaseBean;
import com.funmed.funmeddoctor.bean.DataResponse;
import com.funmed.funmeddoctor.bean.InfomationListBean;

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
    String BASE_URL_INFORMATION = "http://121.40.169.248:8010/FunengSBK/";
    /**
     * 首页
     *
     * @return
     */
    /**
     * 用户注册接口
     * @param username
     * @param password
     * @param mobile
     * @param checkCode
     * @return
     */
    @FormUrlEncoded
    @POST("user/register.do")
    Call<BaseBean> register(@Field("username") String username, @Field("password") String password,
                                  @Field("mobile") String mobile, @Field("checkCode") String checkCode);

    /**
     * 获取手机短信验证码
     * @param mobile
     * @return
     */
    @FormUrlEncoded
    @POST("user/checkCode.do")
    Call<BaseBean> getCheckCode(@Field("mobile") String mobile);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("user/login.do")
    Call<BaseBean> login(@Field("username") String username,@Field("password") String password);

    /**
     * 忘记密码
     * @param username
     * @param password
     * @param mobile
     * @param checkCode
     * @return
     */
    @FormUrlEncoded
    @POST("user/forgetPwd.do")
    Call<BaseBean> forgetPwd(@Field("username") String username, @Field("password") String password,
                             @Field("mobile") String mobile, @Field("checkCode") String checkCode);

    /**
     * 修改密码
     * @param old_password
     * @param new_password
     * @param user_id
     * @return
     */
    @FormUrlEncoded
    @POST("user/updatePwd.do")
    Call<BaseBean> updatePwd(@Field("old_password") String old_password,@Field("new_password") String new_password,
                             @Field("userid") String user_id);

    /**
     * 添加用户信息
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("user/addUserInfo.do")
    Call<BaseBean> addUserInfo(@FieldMap Map<String,String> params);

    /**
     * 修改用户名
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("user/updateUserName.do")
    @Headers("Content-Type: application/x-www-form-urlencoded;charset=utf-8")
    Call<BaseBean> updateUserName (@FieldMap Map<String, String> params);

    /**
     * 获取资讯列表
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("information/findTitle.do")
    Call<InfomationListBean> getMessage(@FieldMap Map<String,String> params);

    /**
     * 提交互助式研究表
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("research/addResearchForm.do")
    Call<DataResponse<String>> addResearchForm(@FieldMap Map<String,String> params);

    /**
     * 查询发起的互助式研究表
     * @param useid
     * @return
     */
    @FormUrlEncoded
    @POST("research/findAidResearch.do")
    Call<BaseBean> findAidResearch(@Field("userid")String useid);
}
