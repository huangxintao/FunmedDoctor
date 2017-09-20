package com.funmed.funmeddoctor.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tony on 2017/9/19.
 */

public class WXPayResponseBean {

    /**
     * code : 0
     * msg : 成功
     * data : {"appid":"wx84c8bdc2aa4e2178","noncestr":"VwPMvGCmiaiCA0f2","package":"Sign=WXPay","partnerid":"1463442302","prepayid":"wx201709191437554bf7e48aa60902107104","sign":"CDDC6105FC4180ADB954AB722DE8B669","timestamp":"1505803076036"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * appid : wx84c8bdc2aa4e2178
         * noncestr : VwPMvGCmiaiCA0f2
         * package : Sign=WXPay
         * partnerid : 1463442302
         * prepayid : wx201709191437554bf7e48aa60902107104
         * sign : CDDC6105FC4180ADB954AB722DE8B669
         * timestamp : 1505803076036
         */

        private String appid;
        private String noncestr;
        @SerializedName("package")
        private String packageX;
        private String partnerid;
        private String prepayid;
        private String sign;
        private String timestamp;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
