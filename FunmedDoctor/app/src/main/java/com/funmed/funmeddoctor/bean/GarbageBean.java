package com.funmed.funmeddoctor.bean;

/**
 * Created by tony on 2017/8/14.
 */

public class GarbageBean {

    /**
     * code : 0
     * msg : 成功
     * data : {"form_id":50,"form_type":"commonDetection"}
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
         * form_id : 50
         * form_type : commonDetection
         */

        private int form_id;
        private String form_type;

        public int getForm_id() {
            return form_id;
        }

        public void setForm_id(int form_id) {
            this.form_id = form_id;
        }

        public String getForm_type() {
            return form_type;
        }

        public void setForm_type(String form_type) {
            this.form_type = form_type;
        }
    }
}
