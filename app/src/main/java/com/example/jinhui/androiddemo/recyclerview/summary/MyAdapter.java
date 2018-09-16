package com.example.jinhui.androiddemo.recyclerview.summary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.recycleview.swipemenu.SwipeItemLayout;

import java.util.List;

/**
 * Created by jh on 2018/9/16.
 * Email: 1004260403@qq.com
 */
public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder>{

    List<Integer> list;
    Context context;

    public MyAdapter(List<Integer> list,  Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_summary, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.ViewHolder holder, int position) {
        // 绑定数据
        holder.title.setText("title:" + list.get(position));
        holder.content.setText("content:" + list.get(position));
        holder.swipe_layout.setSwipeEnable(true);

        holder.left_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了左边",Toast.LENGTH_LONG).show();
                holder.swipe_layout.close();
            }
        });

        holder.right_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了右边",Toast.LENGTH_LONG).show();
                holder.swipe_layout.close();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(List<Integer> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, content;
        SwipeItemLayout swipe_layout;
        TextView left_menu, right_menu;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            left_menu = itemView.findViewById(R.id.left_menu);
            right_menu = itemView.findViewById(R.id.right_menu);
            swipe_layout = itemView.findViewById(R.id.swipe_layout);
        }
    }
}
