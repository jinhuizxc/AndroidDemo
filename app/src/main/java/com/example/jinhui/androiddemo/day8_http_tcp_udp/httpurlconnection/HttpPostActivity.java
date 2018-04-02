package com.example.jinhui.androiddemo.day8_http_tcp_udp.httpurlconnection;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.jinhui.androiddemo.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public class HttpPostActivity extends AppCompatActivity {


    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_password)
    EditText etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httppost);
        ButterKnife.bind(this);
    }

    @SuppressLint("StaticFieldLeak")
    @OnClick(R.id.button1)
    public void onViewClicked() {
        final String name = etName.getText().toString();
        final String pass = etPassword.getText().toString();

        new AsyncTask<String, String, String>() {

            @Override
            protected String doInBackground(String... params) {
                URL url;
                try {
                    url = new URL(params[0]);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //发送post请求时必须设置
                    conn.setDoOutput(true);
                    conn.setUseCaches(false);
                    conn.setRequestMethod("POST");

                    //传递数据
                    String data = "name=" + URLEncoder.encode(name, "UTF-8") + "&pass=" + URLEncoder.encode(pass, "UTF-8");
                    //设置请求方式
                    conn.setRequestProperty("Connection", "keep-alive");
                    //设置请求的头
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    //设置请求的头
                    conn.setRequestProperty("Content-Length", String.valueOf(data.getBytes().length));

                    //向服务器发送数据
                    OutputStream os = conn.getOutputStream();
                    os.write(data.getBytes());
                    os.flush();

                    //接收服务器数据
                    InputStream is = conn.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is, "utf-8");
                    BufferedReader br = new BufferedReader(isr);
                    String info = br.readLine();
                    Log.d("Test", "info = " + info);

//					byte buffer[] = new byte[1024];
//					int length = is.read(buffer);
//					String info = new String(buffer, 0, length);
//					Log.d("Test", "info = " + info);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute("http://192.168.0.101:8080/Java_Web_Hello/response_user.jsp");
    }
}
