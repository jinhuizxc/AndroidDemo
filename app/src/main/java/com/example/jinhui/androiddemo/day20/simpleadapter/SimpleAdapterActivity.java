package com.example.jinhui.androiddemo.day20.simpleadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class SimpleAdapterActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<HashMap<String, Object>> data;
    @BindView(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleadapter);
        ButterKnife.bind(this);

        //图片数据
        int imageIds[] = {R.drawable.a01, R.drawable.a02, R.drawable.a03,
                R.drawable.a04, R.drawable.a05};

        //文字
        String texts[] = {"aa", "bb", "cc", "dd", "ee"};


        //录入到数据源中
        data = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < texts.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("imageId", imageIds[i]);
            map.put("text", texts[i]);

            data.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.simple_item,
                new String[]{"imageId", "text"}, new int[]{R.id.imageView1, R.id.textView1});

        listview.setAdapter(adapter);

        //设置ListView的监听
        listview.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("Test", "item click " + view);
        Log.e("Test", "parent = " + parent);
        Log.e("Test", "position = " + position);
        Log.e("Test", "id = " + id);

        //获取用户点击的item项上的数据对象
        HashMap<String, Object> map = data.get(position);
        int imageId = (Integer) map.get("imageId");
        String text = (String) map.get("text");


        //自定义Toast
        Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        //自定义视图
        View tView = LayoutInflater.from(this).inflate(R.layout.toast_view, null);

        //设置数据
        TextView tv = (TextView) tView.findViewById(R.id.textView1);
        ImageView iv = (ImageView) tView.findViewById(R.id.imageView1);

        tv.setText(text);
        iv.setImageResource(imageId);


        toast.setView(tView);
//		toast.setGravity(Gravity.CENTER, 0, 100);
        toast.show();
    }
}
