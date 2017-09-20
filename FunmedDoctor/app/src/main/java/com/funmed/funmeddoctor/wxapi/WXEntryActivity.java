package com.funmed.funmeddoctor.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.funmed.funmeddoctor.data.IConstants;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.weixin.callback.WXCallbackActivity;

/**
 * Created by tony on 2017/8/17.
 */

public class WXEntryActivity extends WXCallbackActivity implements IWXAPIEventHandler{
    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";
    private IWXAPI api;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, IConstants.APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        if (baseResp.errCode == 0) {//支付成功
            Intent intent = new Intent();
            intent.setAction("fbPayAction");
//          intent.setAction("goodsPayAction");
//          intent.setAction("integraPayAction");
            sendBroadcast(intent);
            Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
            finish();
        }else if (baseResp.errCode == -1) {//支付失败
            Toast.makeText(this, "支付失败", Toast.LENGTH_SHORT).show();
            finish();
        }else {//取消
            Toast.makeText(this, "支付取消", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
