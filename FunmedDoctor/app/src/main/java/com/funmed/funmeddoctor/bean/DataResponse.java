package com.funmed.funmeddoctor.bean;

/**
 * Created by tony on 2017/8/7.
 */

public class DataResponse<T> {

    /**
     * code : 0
     * msg : 成功
     * data :
     */

    private int code;
    private String msg;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
