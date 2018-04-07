package com.example.jinhui.androiddemo.day23_fragment.listfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinhui on 2018/4/7.
 * Email:1004260403@qq.com
 *
 * ListFragment
 */
public class Fragment_List extends ListFragment {

    private List<String> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, list);

        setListAdapter(arrayAdapter);
        return view;
    }
    
    // 为listview绑定每一项的点击事件
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), list.get(position) + "被点击了", Toast.LENGTH_SHORT).show();
    }
}
