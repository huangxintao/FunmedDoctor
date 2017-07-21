package com.funmed.funmeddoctor.clinical.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.funmed.funmeddoctor.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;

/**
 * Created by tony on 2017/7/20.
 */

public class SBKDetectionActivity extends BaseActivity {
    @Bind(R.id.webview)
    WebView webview;

    @Override
    public int getLayoutId() {
        return R.layout.activity_sbkdetection;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        webview.getSettings().setJavaScriptEnabled(true);      //设置WebView属性，能够执行Javascript脚本
        webview.loadUrl("https://www.fun-med.cn/FunengSBK/pages/Subeikang_check.html");                  //加载需要显示的网页
        webview.setWebViewClient(new WebViewClient (){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

}
