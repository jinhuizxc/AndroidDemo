package com.example.jinhui.androiddemo.day18.filestore;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/12.
 * Email:1004260403@qq.com
 * <p>
 *
 * 将文件存储到外部存储设备（sdcard）
 */

public class FileStoreActivity extends AppCompatActivity {

    private static final String TAG = "FileStoreActivity";
    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.button1)
    Button button1;

    // 方式1：保存的数据
//    File file = new File("/mnt/sdcard/edit.txt");
    // 方式2，推荐方式2
    String path = Environment.getExternalStorageDirectory().getPath() + "/edit.txt";
    File file = new File(path);



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filestore);
        ButterKnife.bind(this);

        // 方式1
//        Log.e(TAG, "path = " + file.getPath() + " " + file.getAbsolutePath());
        // E/FileStoreActivity: path = /mnt/sdcard/edit.txt /mnt/sdcard/edit.txt
        // 方式2
        Log.e(TAG, "path = " + path);
        // E/FileStoreActivity: path = /storage/emulated/0/edit.txt

        if (file.exists()) {
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(file);
                char chars[] = new char[1024];
                int len = 0;
                StringBuffer buffer = new StringBuffer();
                while ((len = fileReader.read(chars)) != -1) {
                    String text = new String(chars, 0, len);
                    buffer.append(text);
                }
                editText1.setText(buffer);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClick(R.id.button1)
    public void onViewClicked() {
        String text = editText1.getText().toString();

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(text);
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
