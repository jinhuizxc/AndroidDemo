package com.example.jinhui.androiddemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.base.LazyFragment;
import com.example.jinhui.androiddemo.bean.MineArticleBean;
import com.example.jinhui.androiddemo.ui.adapter.MineArticleAdapter;
import com.example.jinhui.androiddemo.widget.recyclerview.NormalDecoration;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by jh on 2018/9/10.
 * Email: 1004260403@qq.com
 */
public class ArticleFragment extends LazyFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private MineArticleAdapter adapter;

    @Override
    public void lazyInitView(View view, Bundle savedInstanceState) {
        final List<MineArticleBean> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            final MineArticleBean articleBean = new MineArticleBean();
            articleBean.setContent("使用NestedScrollView+ViewPager+RecyclerView+SmartRefreshLayout打造酷炫下拉视差效果并解决各种滑动冲突" + i);
            data.add(articleBean);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.addItemDecoration(new NormalDecoration(ContextCompat.getColor(mActivity, R.color.mainGrayF8), (int) mActivity.getResources().getDimension(R.dimen.one)));

        adapter = new MineArticleAdapter(mActivity);
        recyclerView.setAdapter(adapter);
        adapter.addAll(data);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(mActivity, "---position---" + position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setNoMore(R.layout.view_no_more);
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
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
        return R.layout.fragment_article;
    }

    public static Fragment getInstance() {
        return new ArticleFragment();
    }
}
