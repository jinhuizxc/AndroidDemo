package com.example.jinhui.androiddemo.day22.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day22.cache.util.LruCacheUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 * <p>
 * ListView使用二级缓存加载网络图片
 * <p>
 * 什么是二级缓存
 * <p>
 * 内存缓存 --> 存储设备缓存 --> 网络
 * 二级缓存的流程
 * <p>
 * 每次二级走，每次都这么拿图片，直到拿到图片的那一级停下来。
 * 例如有图片A：第一次拿图片，发现内存缓存中拿不到，就是存储设备拿，存储设备没有，就去网上下载。第二次拿图片，路还是这么走。如果内存缓存中拿到了，就停下来。
 * 为什么要使用二级缓存
 * <p>
 * 此时，如果不采用任何缓存机制，会造成两点问题：
 * 1. 滑动列表时显示的图片都会从网络重新获取，不论之前有没有显示过该图片。
 * 2. 图片会有错位显示问题。
 * 缓存工具类LruCache介绍
 * <p>
 * LruCache是android提供的一个缓存工具类，其算法为它把最近使用的对象用“强引用”存储在LinkHashMap中，并且把最近最少使用的对象就从缓存中移除。
 * //得到当前app可用内存的大小
 * int mem = manager.getMemoryClass();
 * <p>
 * //定义缓存大小
 * int memoryCache = mem/8;
 * <p>
 * //设置内存缓存
 * LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(memoryCache);
 * <p>
 * Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher);
 * <p>
 * //将bitmap对象添加缓存中
 * cache.put("01", bitmap);
 * <p>
 * //获取缓存中的bitmap对象
 * Bitmap bitmapGet = cache.get("01");
 * 模拟从网上下载图片并加入缓存
 * <p>
 * <p>
 * public class MyApp extends Application {
 * LruCache<String, Bitmap> cache;
 * }
 */

public class CacheActivity extends AppCompatActivity {

    @BindView(R.id.bt_cache)
    Button btCache;
    @BindView(R.id.bt_cacheexample)
    Button btCacheexample;

    // 自定义缓存工具类
    LruCacheUtil lruCacheUtil = new LruCacheUtil();
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_cache, R.id.bt_cacheexample})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_cache:
                doCache();
                break;
            case R.id.bt_cacheexample:
                startActivity(new Intent(this,CacheExampleActivity.class));
                break;
        }
    }

    /**
     * 缓存步骤：
     * 内存缓存 --> 存储设备缓存 --> 网络
     * <p>
     * 点击按钮后,打印log,如下：
     * E/Test: memMax = 256M
     * E/Test: 读取本地图片文件，显示到屏幕上
     * E/Test: 将图片载入到内存缓存中
     * 再次点击按钮，打印log：
     * E/Test: 从缓存中取出图片，显示到屏幕上
     */
    private void doCache() {
        if (lruCacheUtil.cache == null) {  //cache缓冲
            ActivityManager manager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
            //获取当前应用程序运行时可使用的最大内存
            assert manager != null;
            int memMax = manager.getMemoryClass();
            Log.e("Test", "memMax = " + memMax + "M");

            //申请一块内存空间作为缓存 (4M)
            lruCacheUtil.cache = new LruCache<String, Bitmap>(memMax / 8);
        }

        //从内存缓存中取出图片
        Bitmap bitmap = lruCacheUtil.cache.get("01");
        if (bitmap != null) {
            Log.e("Test", "从缓存中取出图片，显示到屏幕上");
            imageView.setImageBitmap(bitmap);
        } else {
            Log.e("Test", "读取本地图片文件，显示到屏幕上");
            Log.e("Test", "将图片载入到内存缓存中");
            Bitmap bitmapTemp = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_head);
            lruCacheUtil.cache.put("01", bitmapTemp);
        }
    }


}
