package com.funmed.funmeddoctor.bean;

import java.util.List;

/**
 * Created by tony on 2017/8/10.
 */

public class MsgInfoDetailBean {

    /**
     * code : 0
     * msg : 成功
     * data : {"body":[{"content":"  <p>\r\n\r\n欢迎关注苏贝康APP，如有问题请到苏贝康APP--病友圈咨询，或拨打咨询电话：021-54533696\r\n\r\n\r\n\r\n崇明县传染病医院（二级甲等）\r\n\r\n院长：陈友新\r\n特色科室：传染科、理疗科、肺科、防治科等\r\n床位：250\r\n联系电话：021-59612490\r\n地址：崇明县城桥镇鳌山路611号\r\n\r\n奉贤区中心医院（二级甲等）\r\n\r\n院长：李仁嘉\r\n特色科室：心血管科、肝病科、新生儿科等\r\n床位：520\r\n联系电话：021-57412830、57420702\r\n地址：奉贤南桥镇大寺路3号\r\n\r\n奉贤区中医院（二级甲等）\r\n\r\n院长：张世昌\r\n特色科室：中医妇科不孕症、眼科\r\n床位：250\r\n联系电话：021-57420840、57420861\r\n地址：南桥镇华苑路4号\r\n\r\n南汇县中心医院（二级甲等）\r\n\r\n院长：诸维祥\r\n特色科室：皮肤科、妇产科、骨伤科、消化内科、腹腔镜外科、口腔颌面外科等\r\n床位：444\r\n联系电话：021-58022995、58021525\r\n地址：南汇县惠南镇人民东路55号\r\n\r\n\r\n南汇县光明中医院（二级甲等）\r\n\r\n院长：尚云\r\n特色科室：妇产科、咳喘病、脾胃病、肾病、糖尿病、结肠炎、男性病、不孕症、类风关、腰腿痛病、颈椎病、白内障等\r\n床位：180\r\n联系电话：021-58020203\r\n地址：上海市南汇县惠南镇东门大街339号\r\n\r\n南汇县南华医院（二级乙等）\r\n\r\n院长：季青\r\n特色科室：传染病科\r\n床位：116\r\n联系电话：021-58020135\r\n地址：上海市南汇县惠南镇城北路71号\r\n\r\n松江区妇幼保健院（二级甲等）\r\n\r\n院长：陈时运\r\n\r\n特色科室：产科、妇科、儿科、内科、乳腺科、皮肤性病科等床位：86\r\n联系电话：021-57812642\r\n地址：松江区松江镇乐都路37号\r\n\r\n青浦区中心医院（二级甲等）\r\n\r\n院长：王玉琦\r\n特色科室：消化内科、普外科、泌尿科、骨科、血栓病等\r\n床位：426\r\n联系电话：021-59729668、59728454\r\n地址：青浦区青浦镇医院路1号\r\n\r\n上海市虹口区四川北路街道社区卫生服务中心（二级甲等）\r\n\r\n特色科室：心内科、胆道外科、耳鼻喉科、骨伤科、中医痔外科、口腔颌面外科、眼科\r\n床位：450\r\n联系电话：021-65414600\r\n地址：虹口区东长治路505号\r\n\r\n崇明县中心医院（二级甲等）\r\n院长：施院长\r\n特色专科：腹腔镜胆囊切除术、直肠癌根治低位吻合、门脉高压症各颊分流术、前列腺增生症经尿道电切治疗、膀胱肿瘤经尿道电切治疗、输尿管结石经尿道套石治疗等\r\n床位：559\r\n联系电话：021-59612701\r\n地址：崇明县城桥镇南门港街25号\r\n\r\n\r\n><\/p>\r\n","title":"上海市医院 十一组","imagepath":"/image/information/2017-08-03-17-43-13-ee220edcf9d7df8aea18eb3fd17455e.png","datetime":"2017-08-03 17:43:13"}]}
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
        private List<BodyBean> body;

        public List<BodyBean> getBody() {
            return body;
        }

        public void setBody(List<BodyBean> body) {
            this.body = body;
        }

        public static class BodyBean {
            /**
             * content :   <p>

             欢迎关注苏贝康APP，如有问题请到苏贝康APP--病友圈咨询，或拨打咨询电话：021-54533696



             崇明县传染病医院（二级甲等）

             院长：陈友新
             特色科室：传染科、理疗科、肺科、防治科等
             床位：250
             联系电话：021-59612490
             地址：崇明县城桥镇鳌山路611号

             奉贤区中心医院（二级甲等）

             院长：李仁嘉
             特色科室：心血管科、肝病科、新生儿科等
             床位：520
             联系电话：021-57412830、57420702
             地址：奉贤南桥镇大寺路3号

             奉贤区中医院（二级甲等）

             院长：张世昌
             特色科室：中医妇科不孕症、眼科
             床位：250
             联系电话：021-57420840、57420861
             地址：南桥镇华苑路4号

             南汇县中心医院（二级甲等）

             院长：诸维祥
             特色科室：皮肤科、妇产科、骨伤科、消化内科、腹腔镜外科、口腔颌面外科等
             床位：444
             联系电话：021-58022995、58021525
             地址：南汇县惠南镇人民东路55号


             南汇县光明中医院（二级甲等）

             院长：尚云
             特色科室：妇产科、咳喘病、脾胃病、肾病、糖尿病、结肠炎、男性病、不孕症、类风关、腰腿痛病、颈椎病、白内障等
             床位：180
             联系电话：021-58020203
             地址：上海市南汇县惠南镇东门大街339号

             南汇县南华医院（二级乙等）

             院长：季青
             特色科室：传染病科
             床位：116
             联系电话：021-58020135
             地址：上海市南汇县惠南镇城北路71号

             松江区妇幼保健院（二级甲等）

             院长：陈时运

             特色科室：产科、妇科、儿科、内科、乳腺科、皮肤性病科等床位：86
             联系电话：021-57812642
             地址：松江区松江镇乐都路37号

             青浦区中心医院（二级甲等）

             院长：王玉琦
             特色科室：消化内科、普外科、泌尿科、骨科、血栓病等
             床位：426
             联系电话：021-59729668、59728454
             地址：青浦区青浦镇医院路1号

             上海市虹口区四川北路街道社区卫生服务中心（二级甲等）

             特色科室：心内科、胆道外科、耳鼻喉科、骨伤科、中医痔外科、口腔颌面外科、眼科
             床位：450
             联系电话：021-65414600
             地址：虹口区东长治路505号

             崇明县中心医院（二级甲等）
             院长：施院长
             特色专科：腹腔镜胆囊切除术、直肠癌根治低位吻合、门脉高压症各颊分流术、前列腺增生症经尿道电切治疗、膀胱肿瘤经尿道电切治疗、输尿管结石经尿道套石治疗等
             床位：559
             联系电话：021-59612701
             地址：崇明县城桥镇南门港街25号


             ></p>

             * title : 上海市医院 十一组
             * imagepath : /image/information/2017-08-03-17-43-13-ee220edcf9d7df8aea18eb3fd17455e.png
             * datetime : 2017-08-03 17:43:13
             */

            private String content;
            private String title;
            private String imagepath;
            private String datetime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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
