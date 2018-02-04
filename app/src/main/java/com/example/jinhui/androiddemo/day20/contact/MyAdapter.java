package com.example.jinhui.androiddemo.day20.contact;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class MyAdapter extends BaseAdapter {

    ArrayList<Person> data;
    LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<Person> data ) {
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

    long allTime;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        long last = System.currentTimeMillis();

        ViewHolder holder = null;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.contact_item, null);

            holder = new ViewHolder();

            TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
            TextView tvPhone = (TextView) convertView.findViewById(R.id.textView2);

            holder.tvName = tvName;
            holder.tvPhone = tvPhone;

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //设置数据
        Person person = data.get(position);
        holder.tvName.setText(person.getName());
        holder.tvPhone.setText(person.getPhone());

        long current = System.currentTimeMillis();

        allTime += (current-last);
        Log.e("Test", "allTime = " + allTime);

        return convertView;
    }

    class ViewHolder{
        TextView tvName;
        TextView tvPhone;
    }

}
