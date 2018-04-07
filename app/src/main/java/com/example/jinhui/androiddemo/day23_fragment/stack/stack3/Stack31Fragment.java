package com.example.jinhui.androiddemo.day23_fragment.stack.stack3;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by jinhui on 2018/4/7.
 * Email:1004260403@qq.com
 */
public class Stack31Fragment extends Fragment {

    @BindView(R.id.bt_back)
    Button btBack;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.bt_article)
    Button btArticle;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stack2, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.bt_back, R.id.bt_article})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                break;
            case R.id.bt_article:
                break;
        }
    }
}
