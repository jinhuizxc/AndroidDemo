package com.example.jinhui.androiddemo.day22.spinner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<HashMap<String, Object>> data;
    @BindView(R.id.spinner1)
    Spinner spinner1;
    @BindView(R.id.spinner2)
    Spinner spinner2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);

        // 图片数据
        int imageIds[] = { R.drawable.a01, R.drawable.a02, R.drawable.a03,
                R.drawable.a04, R.drawable.a05 };

        // 文字
        String texts[] = { "aa", "bb", "cc", "dd", "ee" };

        // 录入到数据源中
        data = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < texts.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("imageId", imageIds[i]);
            map.put("text", texts[i]);

            data.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.spinner_item,
                new String[] { "imageId", "text" }, new int[] {
                R.id.imageView1, R.id.textView1 });

        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, data.get(position).get("text")+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
