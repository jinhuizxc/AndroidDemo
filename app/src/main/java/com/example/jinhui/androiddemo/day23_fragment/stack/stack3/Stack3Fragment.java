package com.example.jinhui.androiddemo.day23_fragment.stack.stack3;

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

public class Stack3Fragment extends Fragment implements View.OnClickListener {

    MyListener listener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stackfragment1, container, false);
        Button btn = (Button) view.findViewById(R.id.bt_go);
        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.update();
        }
    }


    //自定义接口
    public interface MyListener{
        void update();
    }

    public void setListener(MyListener listener) {
        this.listener = listener;
    }
}
