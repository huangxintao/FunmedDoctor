package com.funmed.funmeddoctor.community.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.funmed.funmeddoctor.R;
import com.funmed.funmeddoctor.bean.MsgInfoDetailBean;
import com.funmed.funmeddoctor.data.IConstants;
import com.funmed.funmeddoctor.network.APIServiceImplInfo;
import com.funmed.funmeddoctor.network.ApiService;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.murphy.common.base.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tony on 2017/8/10.
 */

public class MsgInfoDetailActivity extends BaseActivity {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.webview)
    WebView webview;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    private String title = "";
    private String informationid = "";
    private ApiService service;

    @Override
    public int getLayoutId() {
        return R.layout.activity_msg_info_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {
        service = APIServiceImplInfo.getInstance().createService(ApiService.class);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initView() {
        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra("title");
            informationid = intent.getStringExtra("informationid");
        }
        toolbarTitle.setText(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        webview.getSettings().setDefaultTextEncodingName("utf-8");
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setAppCacheEnabled(false);
        webview.getSettings().setJavaScriptEnabled(false);
        webview.getSettings().setNeedInitialFocus(false);
        webview.getSettings().setSupportZoom(false);
        webview.getSettings().setAppCacheMaxSize(0);
        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.setWebChromeClient(new WebChromeClient());
        requestData();
    }

    private void requestData() {
        Call<MsgInfoDetailBean> call = service.getMsgDeatil(informationid);
        call.enqueue(new Callback<MsgInfoDetailBean>() {
            @Override
            public void onResponse(Call<MsgInfoDetailBean> call, Response<MsgInfoDetailBean> response) {
                if (response != null) {
                    String webContent = getHtmlData(response.body().getData().getBody().get(0).getContent(),
                            response.body().getData().getBody().get(0).getTitle(),
                            IConstants.RequestUrl.BASE_PICTURE_URL_SITE + response.body().getData().getBody().get(0).getImagepath());
                    webview.loadData(webContent, "text/html;charset=utf-8", "utf-8");
//                    webview.loadData(response.body().getData().getBody().get(0).getContent(),"text/html;charset=utf-8","utf-8");
                }
            }

            @Override
            public void onFailure(Call<MsgInfoDetailBean> call, Throwable t) {

            }
        });
    }

    private String getHtmlData(String bodyHTML, String title, String imageUrl) {
        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style>img{max-width: 100%; width:auto; height:auto;}</style>" +
                "<style>p{font-family:\"Times New Roman\",Georgia,Serif;font-size:14px;}</style>" +
                "</head>";

        String otherHtml = "<div style=\"text-align: center;\"><b><font size=\"4\">" + title + "</font></b></div><div style=\"text-align: center;\"><br></div><div style=\"text-align: center;\"><img src=\"" + imageUrl + "\"></div>";
        if (bodyHTML.contains("\n")) {
            bodyHTML = bodyHTML.replaceAll("\\n", "<br />");
        }
        bodyHTML = "<font color=\"#2B2B2B\">" + bodyHTML + "</font>";
        return "<html>" + head + "<body>" + otherHtml + bodyHTML + "</body></html>";
    }
}
