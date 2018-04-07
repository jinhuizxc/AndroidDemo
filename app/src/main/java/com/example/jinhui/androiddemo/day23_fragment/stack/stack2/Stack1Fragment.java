package com.example.jinhui.androiddemo.day23_fragment.stack.stack2;

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
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 * <p>
 * Fragment中定义接口回调方法
 */

public class Stack1Fragment extends Fragment {

    MyListener listener;
    @BindView(R.id.bt_go)
    Button btGo;
    @BindView(R.id.tv_content)
    TextView tvContent;
    Unbinder unbinder;

    private int articleId = 234;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.stackfragment1, container, false);
        unbinder = ButterKnife.bind(this, view);

        // 取数据，设置数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            int info = bundle.getInt("stageId");
            tvContent.setText(String.valueOf(info));
        }


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.bt_go)
    public void onViewClicked() {
        if (listener != null) {
            listener.update();
            listener.sendValue(articleId);
        }
    }


    //自定义接口
    public interface MyListener {
        void update();
        void sendValue(int value);
    }

    public void setListener(MyListener listener) {
        this.listener = listener;
    }
}
