package com.example.jinhui.androiddemo.day22.cache;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day22.cache.util.LruCacheUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class CacheExampleActivity extends AppCompatActivity {

    private static final String TAG = "CacheExampleActivity";
    @BindView(R.id.bt_get)
    Button btGet;
    @BindView(R.id.imageView)
    ImageView imageView;

    LruCacheUtil lruCacheUtil = new LruCacheUtil();
    @BindView(R.id.bt_test)
    Button btTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cacheexample);
        ButterKnife.bind(this);

        if (lruCacheUtil.cache == null) {  //cache缓冲
            ActivityManager manager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
            //获取当前应用程序运行时可使用的最大内存
            assert manager != null;
            int memMax = manager.getMemoryClass();
            Log.e("Test", "memMax = " + memMax + "M");
            // 分配缓存大小
            lruCacheUtil.cache = new LruCache<String, Bitmap>(memMax / 8);
        }

    }


    /**
     * 测试：
     * 先点击获取图片按钮,打印log：
     * E/CacheExampleActivity: path = /storage/emulated/0/01.png
     * E/CacheExampleActivity: 从网络获取图片
     * 
     * 点击测试按钮，打印log：
     *  E/CacheExampleActivity: 从缓存中获取图片
     *  
     *  将缓存部分bitmap = lruCacheUtil.cache.get("01");注释掉，
     *  再次测试，打印log：
     *  E/CacheExampleActivity: path = /storage/emulated/0/01.png
     *  E/CacheExampleActivity: 从Sdcard获取图片
     *  注意需要加上读、写外部权限(测试时仅仅是写权限就可用，建议2个都全部加上)
     *  
     * @param view
     */
    @OnClick({R.id.bt_get, R.id.bt_test})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.bt_get:
                doGet();
                break;
            case R.id.bt_test:
                doGet();
                break;
        }

    }

    @SuppressLint("StaticFieldLeak")
    private void doGet() {
        //从缓存中获取图片
        Bitmap bitmap = null;
        bitmap = lruCacheUtil.cache.get("01");
        if (bitmap != null) {
            Log.e(TAG, "从缓存中获取图片");
            //如果缓存中有图片，直接显示到imageview上
            imageView.setImageBitmap(bitmap);
        } else {
            //从Sdcard获取图片
            final String path = Environment.getExternalStorageDirectory().getPath() + "/01.png";
            Log.e(TAG, "path = " + path);
            File file = new File(path);
            if (file.exists()) {
                Log.e(TAG, "从Sdcard获取图片");
                bitmap = BitmapFactory.decodeFile(file.getPath());
                imageView.setImageBitmap(bitmap);
            } else {
                Log.e(TAG, "从网络获取图片");
                // 如果sdcard上没有保存该图片,从网络获取图片
                new AsyncTask<String, Void, Bitmap>() {
                    @Override
                    protected Bitmap doInBackground(String... params) {
                        try {
                            URL url = new URL(params[0]);
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            InputStream is = conn.getInputStream();
                            Bitmap bitmap = BitmapFactory.decodeStream(is);
                            is.close();
                            conn.disconnect();
                            return bitmap;

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    protected void onPostExecute(Bitmap result) {
                        imageView.setImageBitmap(result);
                        // 保存到sdcard
                        File file = new File(path);
                        try {
                            FileOutputStream fos = new FileOutputStream(file);
                            // 将bitmap保存到sdcard上
                            result.compress(Bitmap.CompressFormat.PNG, 100, fos);
                            fos.close();

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //保存到缓存中
                        lruCacheUtil.cache.put("01", result);
                    }

                }.execute("http://www.nowamagic.net/librarys/images/random/rand_11.jpg");
            }
        }
    }
}
