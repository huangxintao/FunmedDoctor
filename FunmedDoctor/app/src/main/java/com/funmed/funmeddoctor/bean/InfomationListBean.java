package com.funmed.funmeddoctor.bean;

import java.util.List;

/**
 * Created by tony on 2017/8/3.
 */

public class InfomationListBean {

    /**
     * code : 0
     * msg : 成功
     * data : {"informations":[{"informationid":505,"title":"衰老原来是从这个时间点开始的！记住这11个变老时间关卡，让你比同龄人年轻几十岁！","imagepath":"/image/information/2017-08-01-18-12-28-dg.jpg","datetime":"2017-08-01 18:12:28"},{"informationid":504,"title":"天气持续\u201c高烧\u201d，如何预防中暑？","imagepath":"/image/information/2017-08-01-18-01-40-gdfs.jpg","datetime":"2017-08-01 18:01:40"},{"informationid":499,"title":"鱼的记忆只有7秒，而你的记忆只有24小时","imagepath":"/image/information/2017-07-27-18-01-36-hgg.jpg","datetime":"2017-07-27 18:01:36"},{"informationid":498,"title":"\u201c吸血鬼\u201d不再只是特殊传奇？","imagepath":"/image/information/2017-07-27-17-56-12-290859977405396561.jpg","datetime":"2017-07-27 17:56:12"},{"informationid":497,"title":"不要让皮肤的瘢痕长进心里","imagepath":"/image/information/2017-07-26-16-11-18-20170726160322.jpg","datetime":"2017-07-26 16:11:18"},{"informationid":492,"title":"有车的注意：夏天上车后一定要做这件事，一暴晒汽车变毒气室！","imagepath":"/image/information/2017-07-26-10-27-07-1fddfda7f44b80a5487a28cc6d8dfa6.png","datetime":"2017-07-26 10:27:07"},{"informationid":490,"title":"一口酒喝出7种癌！记住离劝酒的人远点！他劝的不是酒，是癌！","imagepath":"/image/information/2017-07-25-09-38-09-fccce23e2b4c207ebd6191711de4711.png","datetime":"2017-07-25 09:38:09"},{"informationid":489,"title":" 早餐千万别随便吃，这7大误区要小心","imagepath":"/image/information/2017-07-25-09-27-34-hjs.jpg","datetime":"2017-07-25 09:27:34"},{"informationid":486,"title":"让你看起来比同龄人年轻20岁的9个好习惯，50岁开始坚持做都不晚！","imagepath":"/image/information/2017-07-20-18-34-07-微信图片_20170720183135.jpg","datetime":"2017-07-20 18:34:07"},{"informationid":482,"title":" 三伏天别做这7件事，伤心伤脾又伤肺","imagepath":"/image/information/2017-07-19-13-17-04-gfh.jpg","datetime":"2017-07-19 13:17:04"}]}
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
        private List<InformationsBean> informations;

        public List<InformationsBean> getInformations() {
            return informations;
        }

        public void setInformations(List<InformationsBean> informations) {
            this.informations = informations;
        }

        public static class InformationsBean {
            /**
             * informationid : 505
             * title : 衰老原来是从这个时间点开始的！记住这11个变老时间关卡，让你比同龄人年轻几十岁！
             * imagepath : /image/information/2017-08-01-18-12-28-dg.jpg
             * datetime : 2017-08-01 18:12:28
             */

            private int informationid;
            private String title;
            private String imagepath;
            private String datetime;

            public int getInformationid() {
                return informationid;
            }

            public void setInformationid(int informationid) {
                this.informationid = informationid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImagepath() {
                return imagepath;
            }

            public void setImagepath(String imagepath) {
                this.imagepath = imagepath;
            }

            public String getDatetime() {
                return datetime;
            }

            public void setDatetime(String datetime) {
                this.datetime = datetime;
            }
        }
    }
}
