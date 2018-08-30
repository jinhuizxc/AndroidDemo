package com.example.jinhui.androiddemo.recyclerview.doublerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jh on 2018/8/31.
 * Email: 1004260403@qq.com
 */
public abstract class RvHolder <T> extends RecyclerView.ViewHolder {

    protected RvListener mListener;

    public RvHolder(View itemView, int type, RvListener listener) {
        super(itemView);
        this.mListener = listener;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(v.getId(), getAdapterPosition());
            }
        });
    }

    public abstract void bindHolder(T t, int position);

}
