package com.funmed.funmeddoctor.bean;

/**
 * Created by tony on 2017/7/17.
 */

public class BaseBean {

    /**
     * code : 0
     * msg : 登录成功
     * data : {"username":"18652669038","userid":"4328","serialno":null,"type":null,"token":"5h+ZUkSunwm1Scf+hzBliw==","tokenexpiretime":1500969286395,"id":307,"age":0,"height":190,"weight":70,"sex":1,"headImage_path":null,"email":null,"created_time":1499678294000,"birthday":"2017-07-03","address":"上海市","mobile":"18652669038","isPublic":0}
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
         * username : 18652669038
         * userid : 4328
         * serialno : null
         * type : null
         * token : 5h+ZUkSunwm1Scf+hzBliw==
         * tokenexpiretime : 1500969286395
         * id : 307
         * age : 0
         * height : 190.0
         * weight : 70.0
         * sex : 1
         * headImage_path : null
         * email : null
         * created_time : 1499678294000
         * birthday : 2017-07-03
         * address : 上海市
         * mobile : 18652669038
         * isPublic : 0
         */

        private String username;
        private String userid;
        private Object serialno;
        private Object type;
        private String token;
        private long tokenexpiretime;
        private int id;
        private int age;
        private double height;
        private double weight;
        private int sex;
        private Object headImage_path;
        private Object email;
        private long created_time;
        private String birthday;
        private String address;
        private String mobile;
        private int isPublic;

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

        public Object getSerialno() {
            return serialno;
        }

        public void setSerialno(Object serialno) {
            this.serialno = serialno;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public long getTokenexpiretime() {
            return tokenexpiretime;
        }

        public void setTokenexpiretime(long tokenexpiretime) {
            this.tokenexpiretime = tokenexpiretime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public Object getHeadImage_path() {
            return headImage_path;
        }

        public void setHeadImage_path(Object headImage_path) {
            this.headImage_path = headImage_path;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public long getCreated_time() {
            return created_time;
        }

        public void setCreated_time(long created_time) {
            this.created_time = created_time;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getIsPublic() {
            return isPublic;
        }

        public void setIsPublic(int isPublic) {
            this.isPublic = isPublic;
        }
    }
}
