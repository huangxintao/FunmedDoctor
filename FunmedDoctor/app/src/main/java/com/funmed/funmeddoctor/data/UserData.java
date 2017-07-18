package com.funmed.funmeddoctor.data;

import com.funmed.funmeddoctor.bean.UserBean;

/**
 * Created by huangxintao on 2017/7/18.
 */

public class UserData {

    public final static int SYSTEM_LOGIN = 1;
    public final static int THIRD_LOGIN = 2;
    /**
     * 用户信息
     */
    private UserBean userBean = null;
    private static UserData mInstance = null;
    private UserData()
    {

    }
    public static UserData getInstance()
    {
        if(mInstance == null)
        {
            mInstance = new UserData();
        }
        return mInstance;
    }

    public UserBean getUserBean()
    {
        return userBean;
    }

    public void setUserBean(UserBean userBean)
    {
        this.userBean = userBean;
    }
}
