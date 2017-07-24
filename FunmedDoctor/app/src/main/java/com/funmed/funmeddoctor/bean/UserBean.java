package com.funmed.funmeddoctor.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tony on 2017/7/18.
 */

public class UserBean {
    private int code;
    private String msg;
    private UserEntity data;

    public UserEntity getData()
    {
        return data;
    }

    public void setData(UserEntity data)
    {
        this.data = data;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        if(msg == null)
        {
            msg = "";
        }
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public static class UserEntity extends BaseBean
    {

        /**
         * username : user
         * userid : 85
         * serialno : null
         * type : null
         * token : izJrxohtRj8yfIfSnVrlXg==
         * tokenexpiretime : 1479799393474
         * id : 102
         * age : 0
         * height : 168.0
         * weight : 36.0
         * sex : 0
         * headImage_path : /image/headImage/85/2016-11-18-18-14-34-file.png
         * email : null
         * created_time : 1479464074000
         * birthday : 2016-11-19
         * address : 四川
         * mobile : 13003777680
         */

        private String username;
        private String userid;
        private String serialno;
        private String type;
        private String token;
        private long tokenexpiretime;
        private int id;
        private int age;
        private double height;
        private double weight;
        private int sex;
        private String headImage_path;
        private String email;
        private long created_time;
        private String birthday;
        private String address;
        private String mobile;
        private int isPublic;
        /**
         * serialno : null
         * type : null
         * height : 190.0
         * weight : 70.0
         * headImage_path : null
         * email : null
         */

        @SerializedName("serialno")
        private Object serialnoX;
        @SerializedName("type")
        private Object typeX;
        @SerializedName("height")
        private double heightX;
        @SerializedName("weight")
        private double weightX;
        @SerializedName("headImage_path")
        private Object headImage_pathX;
        @SerializedName("email")
        private Object emailX;

        public String getUsername()
        {
            if(username == null)
            {
                username = "";
            }
            return username;
        }

        public void setUsername(String username)
        {
            this.username = username;
        }

        public String getUserid()
        {
            if(userid == null)
            {
                userid = "";
            }
            return userid;
        }

        public void setUserid(String userid)
        {
            this.userid = userid;
        }

        public String getSerialno()
        {
            if(serialno == null)
            {
                serialno = "";
            }
            return serialno;
        }

        public void setSerialno(String serialno)
        {
            this.serialno = serialno;
        }

        public String getType()
        {
            if(type == null)
            {
                type = "";
            }
            return type;
        }

        public void setType(String type)
        {
            this.type = type;
        }

        public String getToken()
        {
            if(token == null)
            {
                token = "";
            }
            return token;
        }

        public void setToken(String token)
        {
            this.token = token;
        }

        public long getTokenexpiretime()
        {
            return tokenexpiretime;
        }

        public void setTokenexpiretime(long tokenexpiretime)
        {
            this.tokenexpiretime = tokenexpiretime;
        }

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public int getAge()
        {
            return age;
        }

        public void setAge(int age)
        {
            this.age = age;
        }

        public double getHeight()
        {
            return height;
        }

        public void setHeight(double height)
        {
            this.height = height;
        }

        public double getWeight()
        {
            return weight;
        }

        public void setWeight(double weight)
        {
            this.weight = weight;
        }

        public int getSex()
        {
            return sex;
        }

        public void setSex(int sex)
        {
            this.sex = sex;
        }

        public String getHeadImage_path()
        {
            if(headImage_path == null)
            {
                headImage_path = "";
            }
            return headImage_path;
        }

        public void setHeadImage_path(String headImage_path)
        {
            this.headImage_path = headImage_path;
        }

        public String getEmail()
        {
            if(email == null)
            {
                email = "";
            }
            return email;
        }

        public void setEmail(String email)
        {
            this.email = email;
        }

        public long getCreated_time()
        {
            return created_time;
        }

        public void setCreated_time(long created_time)
        {
            this.created_time = created_time;
        }

        public String getBirthday()
        {
            if(birthday == null)
            {
                birthday = "";
            }
            return birthday;
        }

        public void setBirthday(String birthday)
        {
            this.birthday = birthday;
        }

        public String getAddress()
        {
            if(address == null)
            {
                address = "";
            }
            return address;
        }

        public void setAddress(String address)
        {
            this.address = address;
        }

        public String getMobile()
        {
            if(mobile == null)
            {
                mobile = "";
            }
            return mobile;
        }

        public void setMobile(String mobile)
        {
            this.mobile = mobile;
        }

        public int getIsPublic()
        {
            return isPublic;
        }

        public void setIsPublic(int isPublic)
        {
            this.isPublic = isPublic;
        }

        public Object getSerialnoX() {
            return serialnoX;
        }

        public void setSerialnoX(Object serialnoX) {
            this.serialnoX = serialnoX;
        }

        public Object getTypeX() {
            return typeX;
        }

        public void setTypeX(Object typeX) {
            this.typeX = typeX;
        }

        public double getHeightX() {
            return heightX;
        }

        public void setHeightX(double heightX) {
            this.heightX = heightX;
        }

        public double getWeightX() {
            return weightX;
        }

        public void setWeightX(double weightX) {
            this.weightX = weightX;
        }

        public Object getHeadImage_pathX() {
            return headImage_pathX;
        }

        public void setHeadImage_pathX(Object headImage_pathX) {
            this.headImage_pathX = headImage_pathX;
        }

        public Object getEmailX() {
            return emailX;
        }

        public void setEmailX(Object emailX) {
            this.emailX = emailX;
        }
    }
}
