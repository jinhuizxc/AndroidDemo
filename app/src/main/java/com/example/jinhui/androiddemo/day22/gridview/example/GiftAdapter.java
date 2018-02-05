package com.example.jinhui.androiddemo.day22.gridview.example;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class GiftAdapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<ItemData> data;

    public GiftAdapter(Context context, ArrayList<ItemData> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
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
        if(convertView == null){
            convertView = inflater.inflate(R.layout.gift_item, parent, false);
        }
        TextView tv = (TextView) convertView;
        ItemData itemData = data.get(position);
        tv.setText(itemData.getName());

        if(itemData.isWhite()){
            tv.setTextColor(Color.WHITE);
        }else{
            tv.setTextColor(Color.BLACK);
        }

        return convertView;
    }
}
