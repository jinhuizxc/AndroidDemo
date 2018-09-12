package com.example.jinhui.androiddemo.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.bean.MineArticleBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by jh on 2018/9/10.
 * Email: 1004260403@qq.com
 */
public class MineArticleAdapter  extends RecyclerArrayAdapter<MineArticleBean> {
    public MineArticleAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new QuestionViewHolder(parent);
    }

    public class QuestionViewHolder extends BaseViewHolder<MineArticleBean> {

        TextView textView;

        public QuestionViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_mine_article);
            textView = $(R.id.tv_title);
        }

        @Override
        public void setData(MineArticleBean data) {
            super.setData(data);
            textView.setText(data.getContent());
        }
    }
}
