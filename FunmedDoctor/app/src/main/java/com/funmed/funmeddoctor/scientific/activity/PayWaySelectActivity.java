package com.funmed.funmeddoctor.scientific.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.PayResponseBean;
import com.funmed.funmeddoctor.bean.WXPayResponseBean;
import com.funmed.funmeddoctor.data.IConstants;
import com.funmed.funmeddoctor.network.APIServiceImpl;
import com.funmed.funmeddoctor.network.ApiService;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import butterknife.Bind;
import butterknife.OnClick;
import me.murphy.common.alipay.PayResult;
import me.murphy.common.base.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/9/13.
 */

public class PayWaySelectActivity extends BaseActivity {
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.order_no)
    TextView orderNo;
    @Bind(R.id.money_tol)
    TextView moneyTol;
    @Bind(R.id.zhifubao_img)
    ImageView zhifubaoImg;
    @Bind(R.id.zhifubao_pay)
    RelativeLayout zhifubaoPay;
    @Bind(R.id.weixin_img)
    ImageView weixinImg;
    @Bind(R.id.weixin_pay)
    RelativeLayout weixinPay;
    private String order_id = "";
    private String subject = "";
    private String body = "";
    private String price = "";
    private ApiService service;
    private Map<String, String> params = new ConcurrentHashMap<String, String>();
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_CHECK_FLAG = 2;
    private String ip_address;
    private IWXAPI mIWXAPI;

    private Handler mHandler = new Handler() {

        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(PayWaySelectActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                        startActivity(CommitSuccessActivity.class);
                        finish();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(PayWaySelectActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(PayWaySelectActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };


    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_way_select;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        service = APIServiceImpl.getInstance().createService(ApiService.class);
    }

    @Override
    public void initView() {
        toolbarTitle.setText("订单支付");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        order_id = getIntent().getExtras().getString("order_id");
        subject = getIntent().getExtras().getString("subject");
        body = getIntent().getExtras().getString("body");
        price = getIntent().getExtras().getString("price");
        orderNo.setText(order_id);
        moneyTol.setText(price);
        mIWXAPI=WXAPIFactory.createWXAPI(PayWaySelectActivity.this,IConstants.APP_ID);
        mIWXAPI.registerApp(IConstants.APP_ID);
    }

    @OnClick({R.id.zhifubao_pay, R.id.weixin_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhifubao_pay:
                getAlipayInfo();
                break;
            case R.id.weixin_pay:
                getWXPayInfo();
                break;
        }
    }

    public void getAlipayInfo() {
        params.clear();
        params.put("outTradeNo", order_id);
        params.put("subject", subject);
        params.put("body", body);
        params.put("price", price);
//        params.put("price","0.01");
        Call<PayResponseBean> call = service.getAliPayInfo(params);
        call.enqueue(new Callback<PayResponseBean>() {
            @Override
            public void onResponse(Call<PayResponseBean> call, final Response<PayResponseBean> response) {
                if (response.body() != null) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            PayTask alipay = new PayTask(PayWaySelectActivity.this);
                            // 调用支付接口，获取支付结果
                            String result = alipay.pay(response.body().getData(), true);

                            Message msg = new Message();
                            msg.what = SDK_PAY_FLAG;
                            msg.obj = result;
                            mHandler.sendMessage(msg);
                        }
                    }).start();
                }
            }

            @Override
            public void onFailure(Call<PayResponseBean> call, Throwable t) {

            }
        });
    }

    public void getWXPayInfo() {
        params.clear();
        params.put("body", body);
        params.put("detail", subject);
//        params.put("total_price", price);
        params.put("total_price", "0.01");
        params.put("out_trade_no", order_id);
        params.put("spbill_create_ip", getIPAddress(PayWaySelectActivity.this));
        params.put("attach", "1");
        Call<WXPayResponseBean> call = service.getWXPayInfo(params);
        call.enqueue(new Callback<WXPayResponseBean>() {
            @Override
            public void onResponse(Call<WXPayResponseBean> call, Response<WXPayResponseBean> response) {
                boolean sendReq = false;
                if (response.body() != null) {
                    if (response.body().getData().getAppid().equals(IConstants.APP_ID)) {

                        PayReq req = new PayReq();
                        req.appId = response.body().getData().getAppid();
                        req.partnerId = response.body().getData().getPartnerid();
                        req.prepayId = response.body().getData().getPrepayid();
                        req.nonceStr = response.body().getData().getNoncestr();
                        req.timeStamp = response.body().getData().getTimestamp();
                        req.packageValue = response.body().getData().getPackageX();
                        req.sign = response.body().getData().getSign();
                        sendReq = mIWXAPI.sendReq(req);
                    }
                }
            }

            @Override
            public void onFailure(Call<WXPayResponseBean> call, Throwable t) {

            }
        });
    }

    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    /**
     * 将得到的int类型的IP转换为String类型
     *
     * @param ip
     * @return
     */
    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

}
