package com.example.jinhui.androiddemo.day23_fragment.stack.stack2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.util.List;

import butterknife.BindView;

/**
 * Created by jinhui on 2018/4/7.
 * Email:1004260403@qq.com
 */
public class ArticleDetailAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<String> datas;

    public ArticleDetailAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.datas = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_articledetail, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((MyViewHolder)holder).textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.checkBox);
            textView = itemView.findViewById(R.id.textView);
        }
    }


}
