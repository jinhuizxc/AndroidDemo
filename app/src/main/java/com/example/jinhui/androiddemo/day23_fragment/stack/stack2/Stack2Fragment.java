package com.example.jinhui.androiddemo.day23_fragment.stack.stack2;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by jinhui on 2018/4/7.
 * Email:1004260403@qq.com
 * <p>
 * 这个界面是有答案与没有答案的2个布局考虑
 * <p>
 * onAttach->onCreateView->onViewCreated
 * 改成适配器的页面显示，贴合项目设计，把思路再走一遍
 */
public class Stack2Fragment extends Fragment {

    private static final String TAG = "Stack2Fragment";
    @BindView(R.id.bt_back)
    Button btBack;
    @BindView(R.id.bt_article)
    Button btArticle;
    Unbinder unbinder;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    ArticleDetailAdapter articleDetailAdapter;
    List<String> data = new ArrayList<>();

    // 请求数据
    public void requestData(int value) {
        // 开始网络请求数据，本地模拟
        for (int i = 0; i < 10; i++) {
            data.add("item = " + i);
        }
    }

    //自定义接口
    public interface CallBack {
        void update1();
    }

    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_stack2, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated");

        articleDetailAdapter = new ArticleDetailAdapter(getActivity(), data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(articleDetailAdapter);
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
                if (callBack != null) {
                    callBack.update1();
//                    Toast.makeText(getActivity(), "0", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_article:
                if (callBack != null) {
                    callBack.update1();
                }
                break;
        }
    }
}
