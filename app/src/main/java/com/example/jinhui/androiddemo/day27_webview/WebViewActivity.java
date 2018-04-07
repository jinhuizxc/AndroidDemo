package com.example.jinhui.androiddemo.day27_webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.example.jinhui.androiddemo.R;
import com.just.agentweb.AgentWeb;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/4/8.
 * Email:1004260403@qq.com
 * <p>
 * 关于webView了解的有多少呢？从项目的帮助中心抽出来的，之后会持续更新关于webview的部分
 * <p>
 * 优秀的webview加载库：https://github.com/Justson/AgentWeb
 */
public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.ll)
    LinearLayout ll;

    public static final String HOST_URL = "https://lingduren.org/ldjy-student/";
    public static final String HELP_CENTER = "questions/1/index";

    AgentWeb mAgentWeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);

        webView = findViewById(R.id.webView);
        ll = findViewById(R.id.ll);
        // 加载帮助中心的html5可以显示
//        addData();

        // 运用这个库也可以加载html——AgentWeb
        // https://github.com/Justson/AgentWeb
        addData1();
    }

    private void addData() {

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
            }
        });

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        // 测试3个网站均可以访问
//        webView.loadUrl(HOST_URL + HELP_CENTER);
//        webView.loadUrl("https://www.csdn.net/");
        webView.loadUrl("https://www.jianshu.com/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


    }

    private void addData1() {

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
            }
        });

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(ll, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(HOST_URL + HELP_CENTER);
    }


}
