package com.example.jinhui.androiddemo.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.bean.MineQuestionBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by jh on 2018/9/10.
 * Email: 1004260403@qq.com
 */
public class MineQuestionAdapter extends RecyclerArrayAdapter<MineQuestionBean> {
    public MineQuestionAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new QuestionViewHolder(parent);
    }

    public class QuestionViewHolder extends BaseViewHolder<MineQuestionBean> {

        TextView textView;

        public QuestionViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_mine_question);
            textView = $(R.id.tv_title);
        }

        @Override
        public void setData(MineQuestionBean data) {
            super.setData(data);
            textView.setText(data.getContent());
        }
    }
}

