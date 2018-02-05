package com.example.jinhui.androiddemo.day23.stack.stack2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 *
 * Fragment中定义接口回调方法
 */

public class StackFragment1 extends Fragment implements View.OnClickListener {

    UpdateDataToActivity up;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stackfragment1, container, false);
        Button btn = (Button) view.findViewById(R.id.button1);
        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(up != null){
            up.update();
        }
    }


    //自定义接口
    public interface UpdateDataToActivity{
        void update();
    }

    public void setUp(UpdateDataToActivity up) {
        this.up = up;
    }
}
