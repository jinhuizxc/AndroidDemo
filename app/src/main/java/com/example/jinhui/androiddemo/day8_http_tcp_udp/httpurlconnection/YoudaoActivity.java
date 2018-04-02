package com.example.jinhui.androiddemo.day8_http_tcp_udp.httpurlconnection;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

public class YoudaoActivity extends AppCompatActivity {

    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.scrollView1)
    ScrollView scrollView1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youdao);
        ButterKnife.bind(this);
    }

    @SuppressLint("StaticFieldLeak")
    @OnClick(R.id.button1)
    public void onViewClicked() {

        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                try {
                    URL url = new URL(params[0]);
                    try {
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        InputStream is =  conn.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is, "utf-8");
                        BufferedReader br = new BufferedReader(isr);
                        String line = null;
                        StringBuilder buffer = new StringBuilder();
                        while((line = br.readLine()) != null){
                            buffer.append(line);
                        }
                        return buffer.toString();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                return null;
            }

            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                textView1.setText(result);
            }
        }.execute("http://fanyi.youdao.com/openapi.do?keyfrom=dicFarsight&key=305582204&type=data&doctype=xml&version=1.1&q="
                + editText1.getText().toString());
    }
}
