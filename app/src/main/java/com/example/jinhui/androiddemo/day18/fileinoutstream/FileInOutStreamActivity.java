package com.example.jinhui.androiddemo.day18.fileinoutstream;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/12.
 * Email:1004260403@qq.com
 * <p>
 * 文件输入输出流
 * 将文件存储到内部存储设备（内存）
 */

public class FileInOutStreamActivity extends AppCompatActivity {

    private static final String TAG = "FileInOutStreamActivity";
    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.button1)
    Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fileinoutstream);
        ButterKnife.bind(this);

        // 得到应用程序保存数据的路径
        String path = this.getFilesDir().getPath();
        Log.e(TAG, "path = " + path);
        // E/FileInOutStreamActivity: path = /data/user/0/com.example.jinhui.androiddemo/files

        // 读取数据
//        File file = new File("/data/user/0/com.example.jinhui.androiddemo/files/a.txt");
        File file = new File(path + "/a.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte b[] = new byte[1024];
            int len = 0;
            StringBuffer buffer = new StringBuffer();
            while ((len = fileInputStream.read(b)) != -1){
                String s = new String(b, 0, len);
                buffer.append(s);
            }
            Log.e(TAG, buffer.toString());
            editText1.setText(buffer.toString());
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.button1)
    public void onViewClicked() {
        String text = editText1.getText().toString();
        try {
            //  MODE_WORLD_READABLE 模式已经被废弃。
            // getSharedPreferences("test" , MODE_PRIVATE);
            // MODE_WORLD_READABLE模式换成 MODE_PRIVATE
            FileOutputStream fileOutputStream = this.openFileOutput("a.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
