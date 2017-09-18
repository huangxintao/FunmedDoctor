package com.funmed.funmeddoctor.bean;

/**
 * Created by tony on 2017/9/14.
 */

public class PayResponseBean {

    /**
     * code : 1
     * msg : 失败:Could not get a resource from the pool
     * data :
     */

    private int code;
    private String msg;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
