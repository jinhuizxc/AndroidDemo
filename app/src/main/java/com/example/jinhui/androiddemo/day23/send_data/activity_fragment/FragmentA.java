package com.example.jinhui.androiddemo.day23.send_data.activity_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class FragmentA extends Fragment {

    TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        tv = (TextView) view.findViewById(R.id.textView1);
        return view;
    }

    public void setName(String name) {
        tv.setText(name);
    }
}
