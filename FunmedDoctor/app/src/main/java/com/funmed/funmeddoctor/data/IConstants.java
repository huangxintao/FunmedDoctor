package com.funmed.funmeddoctor.data;

/**
 * Created by huangxintao on 2017/7/18.
 */

public interface IConstants {
    interface RequestUrl
    {
        /**
         * https根地址
         */
        String BASE_URL_SITE = "https://www.fun-med.cn/FunengSBK/";
        /**
         * http根地址
         */
//        String BASE_URL_SITE = "http://121.40.169.248:8010/FunengSBK/";
        /**
         * 图片根地址
         */
        String BASE_PICTURE_URL_SITE = "http://121.40.169.248";
        /**
         * 注册
         */
        String REGISTER = BASE_URL_SITE + "user/register.do";
        /**
         * 登录
         */
        String LOGIN = BASE_URL_SITE +  "user/login.do";
        /**
         * 修改密码
         */
        String UPDATE_PWD = BASE_URL_SITE +  "user/updatePwd.do";
        /**
         * 忘记密码
         */
        String FORGET_PWD = BASE_URL_SITE + "user/forgetPwd.do";
        /**
         * 短信验证
         */
        String MESSAGE_CHECK = BASE_URL_SITE + "user/checkCode.do";
        /**
         * 获取设备绑定信息
         */
        String GET_EQUIPMENT_BIND_INFO = BASE_URL_SITE +  "equipment/findCover.do";
        /**
         * 查询检查结果
         */
        String QUERY_DETECTION_RESULT = BASE_URL_SITE +  "equipment/doRead.do";
        /**
         * 首页获取健康指数
         */
        String QUERY_HEALTH = BASE_URL_SITE + "user/findHealthIndex.do";
        /**
         * 更新用户信息
         */
        String UPDATE_USER_INFO = BASE_URL_SITE + "user/addUserInfo.do";
        /**
         * 更新userName
         */
        String UPDATE_USER_USERNAME = BASE_URL_SITE + "user/updateUserName.do";
        /**
         * 智能检测
         */
        String CAPACITY_CHECK = BASE_URL_SITE + "equipment/doTest.do";
        /**
         * 人工检测
         */
        String PEOPLE_CHECK = BASE_URL_SITE + "appImage/upload.do";
        /**
         * 绑定设备
         */
        String BIND_EQUIPMENT = BASE_URL_SITE + "equipment/bind.do";
        /**
         * 删除设备
         */
        String DELETE_EQUIPMENT = BASE_URL_SITE + "equipment/clearBind.do";
        /**
         * 第三方登录
         */
        String THIRD_LOGIN = BASE_URL_SITE + "user/thirdPlatformLogin.do";
        /**
         * 查询资讯标题
         */
        String QUERY_MESSAGE_TITLE = BASE_URL_SITE + "information/findTitle.do";
        /**
         * 查询资讯的内容
         */
        String QUERY_MESSAGE_CONTENT = BASE_URL_SITE + "information/findInformationBody.do";
        /**
         * 激活设备
         */
        String ACTIVE_EQUIP = BASE_URL_SITE + "equipment/doTest.do";
        /**
         * 官网地址
         */
        String WEBSITE_URL = "http://www.fun-med.cn:8090/index/";
        /**
         * 分享地址
         */
        String SHARE_URL = "http://a.app.qq.com/o/simple.jsp?pkgname=com.funmed.superhealth";
        /**
         * 发送验证码、电话号码、检测项目接口
         */
        String SEND_PHONE_NUM = BASE_URL_SITE + "user/doPublic.do";
        /**
         * 查询产品列表接口
         */
        String QUERY_PRODUCT = BASE_URL_SITE + "order/findGoods.do";
        /**
         * 查询我的收货地址
         */
        String QUERY_MY_ADDRESS = BASE_URL_SITE + "order/findReceiveAddress.do";
        /**
         * 添加我的收货地址
         */
        String ADD_MY_ADDRESS = BASE_URL_SITE + "order/addReceiveAddress.do";
        /**
         * 修改我的收货地址
         */
        String UPDATE_MY_ADDRESS = BASE_URL_SITE + "order/updateReceiveAddress.do";
        /**
         * 删除我的收货地址
         */
        String DELETE_MY_ADDRESS = BASE_URL_SITE + "order/deleteReceiveAddress.do";
        /**
         * 添加商品到购物车
         */
        String ADD_PRODUCT_TO_SHOPPING_CART = BASE_URL_SITE + "order/cart/add.do";
        /**
         * 删除购物车商品
         */
        String DELETE_PRODUCT_FROM_SHOPPING_CART = BASE_URL_SITE + "order/cart/deleteItemList.do";
        /**
         * 查询购物车
         */
        String QUERY_PRODUCT_FROM_SHOPPING_CART = BASE_URL_SITE + "order/cart/showCart.do";
        /**
         * 通过商品ID查询商品信息
         */
        String QUERY_PRODUCT_BY_ID = BASE_URL_SITE + "order/findGoodsById.do";
        /**
         * 查询用户的订单
         */
        String QUERY_USER_ORDER = BASE_URL_SITE + "order/findOrderItemsByUserid.do";
        /**
         * 创建订单
         */
        String CREATE_ORDER = BASE_URL_SITE + "order/createOrder.do";
        /**
         * 取消或删除订单
         */
        String CANCEL_ORDER = BASE_URL_SITE + "order/cancelOrder.do";
        /**
         * 根据订单号查询订单
         */
        String QUERY_ORDER_BY_ORDERID = BASE_URL_SITE + "order/findOrderItemsByOrderid.do";
        /**
         * 查询优惠码
         */
        String QUERY_PROMO_CODE = BASE_URL_SITE + "order/findCoupon.do";
        /**
         * 查询支付宝订单信息
         */
        String QUERY_ORDER_INFO = BASE_URL_SITE + "alipay/pay.do";
        /**
         * 查询微信支付订单信息
         */
        String QUERY_WECHAT_PAY_INFO = BASE_URL_SITE + "alipay/weixinpay.do";
        /**
         * 修改订单状态
         */
        String UPDATE_ORDER_STATE = BASE_URL_SITE + "order/updateOrderState.do";
    }

    interface UpdateUserInfoCode
    {
        int USER_NICK = 1;
        int USER_HEIGHT = 2;
        int USER_WEIGHT = 3;
    }

    interface EquipmentCode
    {
        int SCAN_EQUIPMENT_NO = 1;
    }

    interface DataFragmentCode
    {
        String DATA_LOGIN = "data_login";
    }

    interface UmengCode
    {
        int LOGIN_SUCCESS = 1;//授权成功
    }

    interface ChoicePhotoCode
    {
        int SYSTEM_PHOTO = 1000;//系统相册
        int TAKE_PHOTO = 10001;//拍照
        int CROP_PHOTO = 10002;//剪切
        int CROP_CANCEL = 1003;//取消

    }

    interface StringData
    {
        String FILE_FOLDER_NAME = "HeathApplication";
        String CACHE_FILE_NAME = "Funmed_cache";
        String EXCEPTION = "exception";
        String LOADING = "loading";
        String PHONE_NUM = "021-54533696";
    }

    interface JsonData
    {
        /**
         * 使用帮助
         */
        String USE_HELP = "[{\"itemName\":\"苏贝康是什么？\",\"itemContent\":\"\\u3000\\u3000尿常规检测、怀孕检测、肿瘤检测等各种身体数据检测，对健康体检、安全用药的监护、中毒与职业病的防护、泌尿系统疾病以及其他系统疾病和全身性疾病的辅助诊断与观察具有重要参考作用。\\n\\n\\u3000\\u3000“苏贝康”是通过马桶成像技术、Canny图像分割技术帮助用户快捷、方面进行健康分析，提供个性化的健康资讯。为用户提供一个全方位的身体健康数据监控。\"},{\"itemName\":\"何为智能检测？\",\"itemContent\":\"\\u3000\\u3000智能检测，就是利用咱们苏贝康的智能硬件设备。实现人性化的健康数据检测。\"},{\"itemName\":\"何为人工检测？\",\"itemContent\":\"\\u3000\\u3000人工检测，其实就是我们提供了咱们智能马桶上部分的成像技术，让用户可以通过自己拍摄试纸条，从而拿到相应的尿十项数据。\"},{\"itemName\":\"如何进行智能检测？\",\"itemContent\":\"\\u3000\\u30001.激活设备，打开app选中我的，在设备栏中点击激活设备。输入您的wifi账号及密码，点击搜索。就可以搜索到当前接入wifi的苏贝康智能硬件设备。\\n\\n\\u3000\\u30002.绑定设备，打开app选中我的，在设备栏中选中管理设备，进行设备号的输入或者扫码。\\n\\n\\u3000\\u30003.进行检测，点击检测，选中智能检测。选中设备号及需要选择的套餐。既可进行检测。\\n\\n\\u3000\\u30004.查看身体健康数据，选中数据，选中您检测的日期，可以查看您在不同日期的身体健康数据。实时监控您的身体健康。\"},{\"itemName\":\"如何进行人工检测？\",\"itemContent\":\"\\u3000\\u30001.准备尿液，把尿杯里的尿液倒入试管，讲试纸垂直放入试管中蘸取尿液（试纸上的色条完全浸入尿液），浸泡2秒后，试纸的背面沿着是关口去处。在纸巾上，将残留在试纸两侧和背面的尿液吸干，以免试纸交互污染。\\n\\n\\u3000\\u30002.调出我们app端人工检测的摄像头，开始拍照。\\n\\n\\u3000\\u30003.点击开始检测，弹出提示框，显示成功。既可去数据界面，查看您的尿十项数据了。\"}]";
    }

    interface PicassoCode
    {
        String PICASSO_TAG = "PICASSO_TAG";
    }

    interface ActivityReqCode
    {
        int LEAVE_MSG = 10000;//留言
        int UPDATE_USER_INFO = 10001;//修改用户信息
        int REGISTER_ACCOUNT_CODE = 10002;//注册账号
        int SEND_PHONE_NUM = 10003;//公共账号检测，发送验证码
        int CHOICE_ADDRESS = 10004;//选择收货地址
    }

    interface BroadCastCode
    {
        String UMENG_LOGIN_SERVICE_BROAD_CAST_CODE_R = "com.sky.cast.umeng_loginservice_r";
        String UMENG_LOGIN_SERVICE_BROAD_CAST_CODE = "com.sky.cast.umeng_loginservice";
        String LOGIN_SERVICE_BROAD_CAST_CODE = "com.sky.cast.loginservice";
        String BASE_ACTIVITY_BROAD_CAST_CODE = "com.sky.cast.base.activity";
        String BASE_FRAGMENT_ACTIVITY_BROAD_CAST_CODE = "com.sky.cast.base.fragment.activity";
        String PAY_BROAD_CAST_CODE = "com.sky.case.pay";
    }

    interface ProductType
    {
        String CHECK_CARD_TYPE = "2";//体检卡
        String CHECK_PRODUCT_TYPE = "1";//体检仪器
    }
}

