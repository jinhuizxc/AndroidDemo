package com.example.jinhui.androiddemo.day23_fragment.send_data.fragment_fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jinhui on 2018/4/7.
 * Email:1004260403@qq.com
 */
public class RightFragment extends Fragment {


    @BindView(R.id.textView)
    TextView textView;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_right, container, false);
        textView = view.findViewById(R.id.textView);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public void setText(String str) {
        textView.setText(str);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
