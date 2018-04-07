package com.example.jinhui.androiddemo.day23_fragment.send_data.fragment_activity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 *
 * 通过fragment给activity传值，通过回调接口的方式传值
 *
 * 实例化接口的listener，oncreate（）或者onattach（）里面
 *
 */

public class FragmentB extends Fragment {

    private EditText et;
    private Button button;

    // 定义接口
    public interface MyListener{
        void sendMessage(String message);
    }
    private MyListener myListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // 实例化接口listener
        myListener = (MyListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        et = view.findViewById(R.id.et);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击按钮传值
                String info = et.getText().toString().trim();
                myListener.sendMessage(info);
            }
        });

        SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                Fragment_activityActivity main = (Fragment_activityActivity) FragmentB.this.getActivity();
                // 设置进度
                main.setFragmentProgress(progress);
            }
        });


        return view;
    }
}
