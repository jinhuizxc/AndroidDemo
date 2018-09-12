package com.example.jinhui.androiddemo.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.bean.MineDynamicBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by jh on 2018/9/10.
 * Email: 1004260403@qq.com
 */
public class MineDynamicAdapter extends RecyclerArrayAdapter<MineDynamicBean>{

    public MineDynamicAdapter(Context context) {
        super(context);
    }

    @Override
    public int getViewType(int position) {
        final int type = getItem(position).getType();
        if (type == 0) {
            return 0;
        }
        if (type == 1) {
            return 1;
        }
        if (type == 2) {
            return 2;
        }
        return -1;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new DynamicArticleHolder(parent);

            case 1:
                return new DynamicCommentHolder(parent);

            case 2:
                return new DynamicFollowHolder(parent);
        }
        return new DynamicArticleHolder(parent);
    }

    private class DynamicArticleHolder extends BaseViewHolder<MineDynamicBean> {

        TextView textView;

        public DynamicArticleHolder(ViewGroup parent) {
            super(parent, R.layout.item_dynamic_article);
            textView = $(R.id.tv_title);
        }

        @Override
        public void setData(MineDynamicBean data) {
            super.setData(data);
            textView.setText(data.getContent());
        }

    }

    public class DynamicCommentHolder extends BaseViewHolder<MineDynamicBean> {

        TextView textView;

        public DynamicCommentHolder(ViewGroup parent) {
            super(parent, R.layout.item_dynamic_comment);
            textView = $(R.id.tv_title);
        }

        @Override
        public void setData(MineDynamicBean data) {
            super.setData(data);
            textView.setText(data.getContent());
        }
    }

    public class DynamicFollowHolder extends BaseViewHolder<MineDynamicBean> {

        TextView textView;

        public DynamicFollowHolder(ViewGroup parent) {
            super(parent, R.layout.item_dynamic_follow);
            textView = $(R.id.tv_name);
        }

        @Override
        public void setData(MineDynamicBean data) {
            super.setData(data);
//            textView.setText(data.getContent());
        }
    }
}
