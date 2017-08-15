package com.funmed.funmeddoctor.clinical.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

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
    @Bind(R.id.tv_back)
    TextView tvBack;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

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
        toolbar.setFitsSystemWindows(false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            toolbar.setPadding(0, getStatusBarHeight(this), 0, 0);
        }
        webview.getSettings().setJavaScriptEnabled(true);      //设置WebView属性，能够执行Javascript脚本
        webview.loadUrl("https://www.fun-med.cn/FunengSBK/pages/Subeikang_check.html");                  //加载需要显示的网页
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
    //获取状态栏高度
    private static int getStatusBarHeight(Context context) {
        int statusBarHeight = dip2px(context, 25);
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

    //根据手机的分辨率从 dp 的单位 转成为 px(像素)
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
