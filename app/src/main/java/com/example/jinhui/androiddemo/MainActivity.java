package com.example.jinhui.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.day10.AdvanceInterface2Activity;
import com.example.jinhui.androiddemo.day11_customview.AdvanceInterface3Activity;
import com.example.jinhui.androiddemo.day12.AdvanceInterface4Activity;
import com.example.jinhui.androiddemo.day13.AdvanceInterface5Activity;
import com.example.jinhui.androiddemo.day14.Service1Activity;
import com.example.jinhui.androiddemo.day15.Service2Activity;
import com.example.jinhui.androiddemo.day16.BroadcastReceiverActivity;
import com.example.jinhui.androiddemo.day17.MusicplayerActivity;
import com.example.jinhui.androiddemo.day18.DataStoreActivity;
import com.example.jinhui.androiddemo.day19.ContentProviderActivity;
import com.example.jinhui.androiddemo.day1_layout.WidgetAndLayoutActivity;
import com.example.jinhui.androiddemo.day2.ListenerActivity;
import com.example.jinhui.androiddemo.day20_adapter.UiOptimize1Activity;
import com.example.jinhui.androiddemo.day21_adapter_footer_header.UiOptimize2Activity;
import com.example.jinhui.androiddemo.day22.UiOptimize3Activity;
import com.example.jinhui.androiddemo.day23_fragment.UiOptimize4Activity;
import com.example.jinhui.androiddemo.day24.UiOptimize5Activity;
import com.example.jinhui.androiddemo.day25.ModelActivity;
import com.example.jinhui.androiddemo.day26.DataActivity;
import com.example.jinhui.androiddemo.day27_webview.WebViewActivity;
import com.example.jinhui.androiddemo.day3_interface.InterfaceActivity;
import com.example.jinhui.androiddemo.day4.Interface2Activity;
import com.example.jinhui.androiddemo.day5.ActivityActivity;
import com.example.jinhui.androiddemo.day6.AnimActivity;
import com.example.jinhui.androiddemo.day7.ThreadActivity;
import com.example.jinhui.androiddemo.day8_http_tcp_udp.HttpActivity;
import com.example.jinhui.androiddemo.day9.AdvanceInterface1Activity;
import com.example.jinhui.androiddemo.desinpattern.DesinPatternActivity;
import com.example.jinhui.androiddemo.feature.banner.rvbanner1.RVBannerActivity;
import com.example.jinhui.androiddemo.feature.banner.rvbanner2.RVBanner2Activity;
import com.example.jinhui.androiddemo.feature.banner.rvbanner3.RVBanner3Activity;
import com.example.jinhui.androiddemo.feature.banner.viewpagerbanner.ViewPagerActivity;
import com.example.jinhui.androiddemo.glide.GlideActivity;
import com.example.jinhui.androiddemo.material_design.swiperefreshlayout.SwipeRefreshLayoutActivity;
import com.example.jinhui.androiddemo.material_design.tablayout.TabLayoutActivity;
import com.example.jinhui.androiddemo.recyclerview.doublerecyclerview.DoubleRVActivity;
import com.example.jinhui.androiddemo.ui.activity.MultiScrollDemoActivity;
import com.example.jinhui.androiddemo.ui.feature.shopcar.ShoppingCartActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 2018/1/23,
 * 最近在学习自定义篇，启舰大神的文章，
 * 想着以前自己也有很多Android笔记，这么久了，
 * 可以整理一篇合集，做到温故而知新！
 * <p>
 * 解决Android Studio出现GC overhead limit exceeded:
 * https://www.cnblogs.com/jeffen/p/7607239.html
 * <p>
 * 安卓UI相关开源项目库汇总: https://github.com/opendigg/awesome-github-android-ui
 */
public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bt_widget)
    Button btWidget;
    @BindView(R.id.bt_listener)
    Button btListener;
    @BindView(R.id.bt_interface)
    Button btInterface;
    @BindView(R.id.bt_interface2)
    Button btInterface2;
    @BindView(R.id.bt_activity)
    Button btActivity;
    @BindView(R.id.bt_anim)
    Button btAnim;
    @BindView(R.id.bt_thread)
    Button btThread;
    @BindView(R.id.bt_http)
    Button btHttp;
    @BindView(R.id.bt_advanceInterface1)
    Button btAdvanceInterface1;
    @BindView(R.id.bt_advanceInterface2)
    Button btAdvanceInterface2;
    @BindView(R.id.bt_advanceInterface3)
    Button btAdvanceInterface3;
    @BindView(R.id.bt_advanceInterface4)
    Button btAdvanceInterface4;
    @BindView(R.id.bt_advanceInterface5)
    Button btAdvanceInterface5;
    @BindView(R.id.bt_service01)
    Button btService01;
    @BindView(R.id.bt_service02)
    Button btService02;
    @BindView(R.id.bt_broadcastreceiver)
    Button btBroadcastreceiver;
    @BindView(R.id.bt_musicplayer)
    Button btMusicplayer;
    @BindView(R.id.bt_datastore)
    Button btDatastore;
    @BindView(R.id.bt_contentprovider)
    Button btContentprovider;
    @BindView(R.id.bt_uioptimize01)
    Button btUioptimize01;
    @BindView(R.id.bt_uioptimize02)
    Button btUioptimize02;
    @BindView(R.id.bt_uioptimize03)
    Button btUioptimize03;
    @BindView(R.id.bt_uioptimize04)
    Button btUioptimize04;
    @BindView(R.id.bt_uioptimize05)
    Button btUioptimize05;
    @BindView(R.id.bt_model)
    Button btModel;
    @BindView(R.id.bt_data)
    Button btData;
    @BindView(R.id.bt_designpattern)
    Button btDesignpattern;
    @BindView(R.id.bt_webView)
    Button btWebView;
    @BindView(R.id.bt_swiperefreshlayout)
    Button btSwiperefreshlayout;
    @BindView(R.id.bt_recyclerView)
    Button btRecyclerView;
    @BindView(R.id.bt_double_rv)
    Button btDoubleRv;
    @BindView(R.id.bt_viewpager)
    Button btViewpager;
    @BindView(R.id.bt_rvBanner2)
    Button btRvBanner2;
    @BindView(R.id.bt_rvBanner3)
    Button btRvBanner3;
    @BindView(R.id.bt_glide)
    Button btGlide;
    @BindView(R.id.bt_tablayout)
    Button btTablayout;
    @BindView(R.id.bt_multiscroll)
    Button btMultiscroll;
    @BindView(R.id.bt_shopCar)
    Button btShopCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_widget, R.id.bt_listener, R.id.bt_interface,
            R.id.bt_interface2, R.id.bt_activity, R.id.bt_anim,
            R.id.bt_thread, R.id.bt_http, R.id.bt_advanceInterface1,
            R.id.bt_advanceInterface2, R.id.bt_advanceInterface3,
            R.id.bt_advanceInterface4, R.id.bt_advanceInterface5,
            R.id.bt_service01, R.id.bt_service02, R.id.bt_broadcastreceiver,
            R.id.bt_musicplayer, R.id.bt_datastore, R.id.bt_contentprovider,
            R.id.bt_uioptimize01, R.id.bt_uioptimize02, R.id.bt_uioptimize03,
            R.id.bt_uioptimize04, R.id.bt_uioptimize05, R.id.bt_model,
            R.id.bt_designpattern, R.id.bt_data, R.id.bt_webView,
            R.id.bt_swiperefreshlayout, R.id.bt_recyclerView, R.id.bt_double_rv,
            R.id.bt_viewpager, R.id.bt_rvBanner2, R.id.bt_rvBanner3,
            R.id.bt_glide, R.id.bt_tablayout, R.id.bt_multiscroll,
            R.id.bt_shopCar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_widget:
                startActivity(new Intent(this, WidgetAndLayoutActivity.class));
                break;
            case R.id.bt_listener:
                startActivity(new Intent(this, ListenerActivity.class));
                break;
            case R.id.bt_interface:
                startActivity(new Intent(this, InterfaceActivity.class));
                break;
            case R.id.bt_interface2:
                startActivity(new Intent(this, Interface2Activity.class));
                break;
            case R.id.bt_activity:
                startActivity(new Intent(this, ActivityActivity.class));
                break;
            case R.id.bt_anim:
                startActivity(new Intent(this, AnimActivity.class));
                break;
            case R.id.bt_thread:
                startActivity(new Intent(this, ThreadActivity.class));
                break;
            case R.id.bt_http:
                startActivity(new Intent(this, HttpActivity.class));
                break;
            case R.id.bt_advanceInterface1:
                startActivity(new Intent(this, AdvanceInterface1Activity.class));
                break;
            case R.id.bt_advanceInterface2:
                startActivity(new Intent(this, AdvanceInterface2Activity.class));
                break;
            case R.id.bt_advanceInterface3:
                startActivity(new Intent(this, AdvanceInterface3Activity.class));
                break;
            case R.id.bt_advanceInterface4:
                startActivity(new Intent(this, AdvanceInterface4Activity.class));
                break;
            case R.id.bt_advanceInterface5:
                startActivity(new Intent(this, AdvanceInterface5Activity.class));
                break;
            case R.id.bt_service01:
                startActivity(new Intent(this, Service1Activity.class));
                break;
            case R.id.bt_service02:
                startActivity(new Intent(this, Service2Activity.class));
                break;
            case R.id.bt_broadcastreceiver:
                startActivity(new Intent(this, BroadcastReceiverActivity.class));
                break;
            case R.id.bt_musicplayer:
                startActivity(new Intent(this, MusicplayerActivity.class));
                break;
            case R.id.bt_datastore:
                startActivity(new Intent(this, DataStoreActivity.class));
                break;
            case R.id.bt_contentprovider:
                startActivity(new Intent(this, ContentProviderActivity.class));
                break;
            case R.id.bt_uioptimize01:
                startActivity(new Intent(this, UiOptimize1Activity.class));
                break;
            case R.id.bt_uioptimize02:
                startActivity(new Intent(this, UiOptimize2Activity.class));
                break;
            case R.id.bt_uioptimize03:
                startActivity(new Intent(this, UiOptimize3Activity.class));
                break;
            case R.id.bt_uioptimize04:
                startActivity(new Intent(this, UiOptimize4Activity.class));
                break;
            case R.id.bt_uioptimize05:
                startActivity(new Intent(this, UiOptimize5Activity.class));
                break;
            case R.id.bt_model:
                startActivity(new Intent(this, ModelActivity.class));
                break;
            case R.id.bt_designpattern:
                startActivity(new Intent(this, DesinPatternActivity.class));
                break;
            case R.id.bt_data:
                startActivity(new Intent(this, DataActivity.class));
                break;
            case R.id.bt_webView:
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.bt_swiperefreshlayout:
                startActivity(new Intent(this, SwipeRefreshLayoutActivity.class));
                break;
            case R.id.bt_recyclerView:
                startActivity(new Intent(this, RVBannerActivity.class));
                break;
            case R.id.bt_double_rv:
                startActivity(new Intent(this, DoubleRVActivity.class));
                break;
            case R.id.bt_viewpager:
                startActivity(new Intent(this, ViewPagerActivity.class));
                break;
            case R.id.bt_rvBanner2:
                startActivity(new Intent(this, RVBanner2Activity.class));
                break;
            case R.id.bt_rvBanner3:
                startActivity(new Intent(this, RVBanner3Activity.class));
                break;
            case R.id.bt_glide:
                startActivity(new Intent(this, GlideActivity.class));
                break;
            case R.id.bt_tablayout:
                startActivity(new Intent(this, TabLayoutActivity.class));
                break;
            case R.id.bt_multiscroll:
                startActivity(new Intent(this, MultiScrollDemoActivity.class));
                break;
            case R.id.bt_shopCar:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
        }
    }


}
