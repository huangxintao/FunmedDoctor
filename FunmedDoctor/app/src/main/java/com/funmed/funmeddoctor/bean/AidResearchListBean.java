package com.funmed.funmeddoctor.bean;

import java.util.List;

/**
 * Created by tony on 2017/8/8.
 */

public class AidResearchListBean {

    /**
     * code : 0
     * msg : 成功
     * data : [{"id":13,"initiator":"哈哈","mobile":"13820080808","email":"8473454687@qq.com","diseaser_name":"直男癌","profile":"你好啊","research_fund":"20000","create_time":1502082644000,"update_time":1502082644000,"userid":"4328","formtype":"1"},{"id":14,"initiator":"哈哈","mobile":"13820080808","email":"8473454687@qq.com","diseaser_name":"直男癌","profile":"你好啊","research_fund":"20000","create_time":1502082677000,"update_time":1502082677000,"userid":"4328","formtype":"1"},{"id":17,"initiator":"哈哈","mobile":"13820080808","email":"8473454687@qq.com","diseaser_name":"直男癌","profile":"你好啊","research_fund":"20000","create_time":1502083050000,"update_time":1502083050000,"userid":"4328","formtype":"1"},{"id":18,"initiator":"哈哈","mobile":"13820080808","email":"1024837534@qq.com","diseaser_name":"癌症","profile":"癌症","research_fund":"20000","create_time":1502084647000,"update_time":1502084647000,"userid":"4328","formtype":"1"},{"id":19,"initiator":"哈哈","mobile":"13820050808","email":"djsvjzvsks@163.com","diseaser_name":"癌症","profile":"癌症","research_fund":"20000","create_time":1502084813000,"update_time":1502084813000,"userid":"4328","formtype":"1"},{"id":22,"initiator":"哈哈","mobile":"18652669038","email":"874813405@qq.com","diseaser_name":"癌症","profile":"癌症很难搞","research_fund":"50000","create_time":1502085646000,"update_time":1502085646000,"userid":"4328","formtype":"1"},{"id":29,"initiator":"黄新桃","mobile":"18652669038","email":"1024553047@qq.com","diseaser_name":"癌症","profile":"癌症","research_fund":"20000","create_time":1502088385000,"update_time":1502088385000,"userid":"4328","formtype":"1"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 13
         * initiator : 哈哈
         * mobile : 13820080808
         * email : 8473454687@qq.com
         * diseaser_name : 直男癌
         * profile : 你好啊
         * research_fund : 20000
         * create_time : 1502082644000
         * update_time : 1502082644000
         * userid : 4328
         * formtype : 1
         */

        private int id;
        private String initiator;
        private String mobile;
        private String email;
        private String diseaser_name;
        private String profile;
        private String research_fund;
        private long create_time;
        private long update_time;
        private String userid;
        private String formtype;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInitiator() {
            return initiator;
        }

        public void setInitiator(String initiator) {
            this.initiator = initiator;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDiseaser_name() {
            return diseaser_name;
        }

        public void setDiseaser_name(String diseaser_name) {
            this.diseaser_name = diseaser_name;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getResearch_fund() {
            return research_fund;
        }

        public void setResearch_fund(String research_fund) {
            this.research_fund = research_fund;
        }

        public long getCreate_time() {
            return create_time;
        }

        public void setCreate_time(long create_time) {
            this.create_time = create_time;
        }

        public long getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(long update_time) {
            this.update_time = update_time;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getFormtype() {
            return formtype;
        }

        public void setFormtype(String formtype) {
            this.formtype = formtype;
        }
    }
}
