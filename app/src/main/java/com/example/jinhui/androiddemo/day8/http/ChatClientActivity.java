package com.example.jinhui.androiddemo.day8.http;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
 * 客户端服务器聊天室
 */

public class ChatClientActivity extends AppCompatActivity {

    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;

    OutputStream os;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatclient);
        ButterKnife.bind(this);
    }

    @SuppressLint("StaticFieldLeak")
    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                final String info = editText1.getText().toString();
                // 向textView添加内容
                textView1.append("me:" + info + "\n");
                editText1.setText("");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // 将用户输入的信息发送给服务器
                        DataOutputStream dos = new DataOutputStream(os);
                        try {
                            dos.writeUTF(info);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
            case R.id.button2:
                // 登入聊天室
                new AsyncTask<Void, String, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            Socket socket = new Socket("192.168.1.102", 8989);
                            publishProgress("联网成功", "1");
                            os = socket.getOutputStream();
                            //接收服务器数据
                            InputStream is = socket.getInputStream();
                            DataInputStream dis = new DataInputStream(is);
                            while(true){
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

                    protected void onProgressUpdate(String... values) {
                        super.onProgressUpdate(values);
                        if(values.length == 2){
                            Toast.makeText(ChatClientActivity.this, "联网成功", Toast.LENGTH_SHORT).show();
                        }else{
                            textView1.append(values[0]+"\n");
                        }
                    }

                }.execute();
                break;
        }
    }
}
