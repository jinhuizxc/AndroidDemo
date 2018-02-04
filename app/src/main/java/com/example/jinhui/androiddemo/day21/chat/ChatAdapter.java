package com.example.jinhui.androiddemo.day21.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class ChatAdapter extends BaseAdapter {

    private ArrayList<Msg> data;
    LayoutInflater inflater;

    public ChatAdapter(Context context, ArrayList<Msg> data) {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.chat_item, null);
            holder = new ViewHolder();

            holder.tvLeft = (TextView) convertView.findViewById(R.id.textView1);
            holder.tvRight = (TextView) convertView.findViewById(R.id.textView2);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Msg msg = data.get(position);

        if(msg.isLeft()){
            holder.tvRight.setVisibility(View.GONE);
            holder.tvLeft.setVisibility(View.VISIBLE);
            holder.tvLeft.setText(msg.getMessage());
        }else{
            holder.tvLeft.setVisibility(View.GONE);
            holder.tvRight.setVisibility(View.VISIBLE);
            holder.tvRight.setText(msg.getMessage());
        }

        return convertView;
    }

    // 添加数据
    public void add(Msg msg) {
        data.add(msg);
        this.notifyDataSetChanged();
    }

    class ViewHolder{
        TextView tvLeft;
        TextView tvRight;

    }

}
