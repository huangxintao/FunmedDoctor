package com.funmed.funmeddoctor.bean;

/**
 * Created by huangxintao on 2017/7/17.
 * 功能描述
 */

public class BaseBean {
    /**
     * returnCode : 0
     * returnMsg : success
     * data : {" username ":"xxx"," userid":"xxx"," token ":"xxx"," tokenexpiretime ":"xxx"}
     */

    private int returnCode;
    private String returnMsg;

    @Override
    public String toString() {
        return "BaseBean{" +
                "returnCode=" + returnCode +
                ", returnMsg='" + returnMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    private DataBean data;

    public static class DataBean {
        /**
         *  username  : xxx
         *  userid : xxx
         *  token  : xxx
         *  tokenexpiretime  : xxx
         */

        private String username;
        private String userid;
        private String token;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getTokenexpiretime() {
            return tokenexpiretime;
        }

        public void setTokenexpiretime(String tokenexpiretime) {
            this.tokenexpiretime = tokenexpiretime;
        }

        private String tokenexpiretime;
    }
}
