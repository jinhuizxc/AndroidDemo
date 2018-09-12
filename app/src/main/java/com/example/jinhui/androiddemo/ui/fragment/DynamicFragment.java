package com.example.jinhui.androiddemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.base.LazyFragment;
import com.example.jinhui.androiddemo.bean.MineDynamicBean;
import com.example.jinhui.androiddemo.ui.adapter.MineDynamicAdapter;
import com.example.jinhui.androiddemo.widget.recyclerview.NormalDecoration;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jh on 2018/9/10.
 * Email: 1004260403@qq.com
 */
public class DynamicFragment extends LazyFragment {

    private static final String TAG = "DynamicFragment";
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private MineDynamicAdapter adapter;

    public static DynamicFragment getInstance() {
        return new DynamicFragment();
    }

    @Override
    public void lazyInitView(View view, Bundle savedInstanceState) {
        final List<MineDynamicBean> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            final MineDynamicBean questionBean = new MineDynamicBean();
            questionBean.setContent("使用NestedScrollView+ViewPager+RecyclerView+SmartRefreshLayout打造酷炫下拉视差效果并解决各种滑动冲突" + i);
            if (i == 0) {
                questionBean.setType(0);
            } else {
                if (i % 2 == 0) {
                    questionBean.setType(1);
                }
                if (i % 3 == 0) {
                    questionBean.setType(2);
                }
            }
            data.add(questionBean);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        // 添加分割线
        recyclerView.addItemDecoration(new NormalDecoration(ContextCompat.getColor(mActivity, R.color.mainGrayF8), (int) mActivity.getResources().getDimension(R.dimen.one)));

        adapter = new MineDynamicAdapter(mActivity);
        recyclerView.setAdapter(adapter);
        adapter.addAll(data);

        adapter.setNoMore(R.layout.view_no_more);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(mActivity, "---position---" + position, Toast.LENGTH_SHORT).show();
            }
        });

        // 加载更多
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                Log.d(TAG, "----onMoreShow");
                adapter.addAll(data);
            }

            @Override
            public void onMoreClick() {

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_dynamic;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
