package com.example.jinhui.androiddemo.day4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 */

public class OnkeyDownActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onkeydown);
    }

    long time;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//			Toast.makeText(this, "" + event.getEventTime(), Toast.LENGTH_SHORT).show();
//			if(event.getEventTime() - time < 2000){
//				finish();
//			}else{
//				time = event.getEventTime();
//			}
//		}
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "再按一次退出" , Toast.LENGTH_SHORT).show();
            if(event.getEventTime()- time < 2000){
                finish();
            }else{
                time = event.getEventTime();
            }
        }
        return true;
    }
}
