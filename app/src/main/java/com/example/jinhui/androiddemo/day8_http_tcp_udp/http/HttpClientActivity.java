package com.example.jinhui.androiddemo.day8_http_tcp_udp.http;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 * <p>
 * 客户端与服务器的通信
 * 无法连接服务器：
 * 1. 没有设置联网权限
 * 2. ip地址和端口号不一致
 * 3. 联网的异步任务没有启动
 */

public class HttpClientActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.textView1)
    TextView textView1;

    boolean isOn = true;
    OutputStream os;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpclient);
        ButterKnife.bind(this);
    }

    @SuppressLint("StaticFieldLeak")
    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                //连接服务器 (联网操作-耗时操作)
                new AsyncTask<Void, String, String>() {
                    @Override
                    protected String doInBackground(Void... params) {
                        try {
                            // 联网
                            Socket socket = new Socket("192.168.1.102", 8585);
                            // os接收服务器端的-发送数据
                            os = socket.getOutputStream();
                            // 接收服务器端的-接收数据
                            InputStream is = socket.getInputStream();
                            DataInputStream dis = new DataInputStream(is);
                            while (isOn) {
                                //阻塞
                                String info = dis.readUTF();
                                publishProgress(info);
                            }

                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onProgressUpdate(String... values) {
                        super.onProgressUpdate(values);
                        textView1.setText(values[0]);
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);
                        if (result != null) {
                            textView1.setText(result);
                        }
                    }

                }.execute();
                break;
            case R.id.button2:
                sendData();
                break;
        }
    }

    /**
     * 通过按钮触发-发送数据
     * 产生异常：android.os.NetworkOnMainThreadException
     * 参考自： http://blog.csdn.net/mad1989/article/details/25964495
     *
     * 解释一下，从Honeycomb SDK（3.0）开始，google不再允许网络请求（HTTP、Socket）等相关操作直接在Main Thread类中，
     * 其实本来就不应该这样做，直接在UI线程进行网络操作，会阻塞UI、用户体验相当bad！即便google不禁止，一般情况下我们也不会这么做吧~
     * 所以，也就是说，在Honeycomb SDK（3.0）以下的版本，你还可以继续在Main Thread里这样做，
     * 在3.0以上，就不行了，建议和network有关比较耗时的操作放到一个子线程里,然后用Handler消息机制与主线程通信。
     */
    private void sendData() {
        // 开启一个子线程，进行网络操作，等待有返回结果，使用handler通知UI
        new Thread(networkTask).start();

//        DataOutputStream dos = new DataOutputStream(os);
//        try {
//            dos.writeUTF(editText1.getText().toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 网络操作相关的子线程
     */
    private Runnable networkTask = new Runnable() {
        @Override
        public void run() {
            DataOutputStream dos = new DataOutputStream(os);
            try {
                dos.writeUTF(editText1.getText().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
