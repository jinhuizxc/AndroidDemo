package com.example.jinhui.androiddemo.day8_http_tcp_udp.httpurlconnection;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.jinhui.androiddemo.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public class HttpGetActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.progressBar1)
    ProgressBar progressBar1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpget);
        ButterKnife.bind(this);
    }

    @SuppressLint("StaticFieldLeak")
    @OnClick(R.id.button1)
    public void onViewClicked() {
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... params) {
                //联网
                try {
                    //创建URL对象
                    URL url = new URL(params[0]);
                    //打开超链接，得到一个连接对象，指向服务器上的资源
                    HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
                    // 设置请求方式为get
                    conn.setRequestMethod("GET");

                    InputStream is = conn.getInputStream();
                    //将字节流中的数据读出来，生成位图对象
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    return bitmap;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            protected void onPostExecute(Bitmap result) {
                super.onPostExecute(result);
                progressBar1.setVisibility(View.INVISIBLE);
                imageView1.setVisibility(View.VISIBLE);
                imageView1.setImageBitmap(result);
            }
        }.execute("http://www.nowamagic.net/librarys/images/random/rand_11.jpg");
    }
}
