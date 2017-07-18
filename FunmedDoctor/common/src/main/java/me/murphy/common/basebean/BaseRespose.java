package me.murphy.common.basebean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * des:封装服务器返回数据
 * Created by murphy
 * on 2016.09.9:47
 */
public class BaseRespose<T> implements Serializable {
    @SerializedName("error_code")
    public int code;
    @SerializedName("error_message")
    public String msg;

    public T data;

    public boolean success() {
        return code == 0;
    }

    @Override
    public String toString() {
        return "BaseRespose{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
