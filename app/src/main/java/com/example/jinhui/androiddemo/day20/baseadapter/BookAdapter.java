package com.example.jinhui.androiddemo.day20.baseadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 * <p>
 * 继承BaseAdapter 重写4个方法
 */

public class BookAdapter extends BaseAdapter {

    ArrayList<Book> data;
    LayoutInflater inflater;

    public BookAdapter(Context context, ArrayList<Book> data) {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    // 得到item项的数量 （ListView长度）
    @Override
    public int getCount() {
        Log.e("Test", "getCount");
        return data.size();
    }

    // 得到第position的item项上的数据对象
    @Override
    public Object getItem(int position) {
        Log.e("Test", "getItem");
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.e("Test", "getItemId");
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("Test", "getView");

        ViewHolder holder = null;
        //数据对象
        final Book book = data.get(position);
        if (convertView == null) {
            //item的视图对象
            convertView = inflater.inflate(R.layout.base_item, null);

            //创建holder对象
            holder = new ViewHolder();

            ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
            TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
            TextView tvPrice = (TextView) convertView.findViewById(R.id.textView2);
            final TextView tvNumber = (TextView) convertView.findViewById(R.id.textView3);
            Button btnSub = (Button) convertView.findViewById(R.id.button1);
            Button btnAdd = (Button) convertView.findViewById(R.id.button2);

            //将找到的控件引用记录到holder中
            holder.iv = iv;
            holder.tvName = tvName;
            holder.tvPrice = tvPrice;
            holder.tvNumber = tvNumber;
            holder.btnSub = btnSub;
            holder.btnAdd = btnAdd;

            //将holder记录到convertView中
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //设置数据
        holder.iv.setImageResource(book.getImageId());
        holder.tvName.setText(book.getName());
        holder.tvPrice.setText(String.valueOf(book.getPrice()));
        holder.tvNumber.setText(String.valueOf(book.getNumber()));

        final TextView tvBtnNumber = holder.tvNumber;

        holder.btnSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //更新数据
                book.subNumber();
                //更新视图
                tvBtnNumber.setText(String.valueOf(book.getNumber()));
            }
        });

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                book.addNumber();
                tvBtnNumber.setText(String.valueOf(book.getNumber()));
            }
        });

        return convertView;
    }

    /**
     * @author Administrator
     *         记录View中的控件对象的引用
     */
    class ViewHolder {

        ImageView iv;
        TextView tvName;
        TextView tvPrice;
        TextView tvNumber;
        Button btnSub;
        Button btnAdd;
    }
}
