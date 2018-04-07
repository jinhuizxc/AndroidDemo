package com.example.jinhui.androiddemo.day23_fragment.send_data.fragment_fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/4/7.
 * Email:1004260403@qq.com
 *
 * fragment向fragmetn传值
 *
 */
public class LeftFragment extends Fragment {

    private EditText editText;
    private Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_left, container, false);
       button = view.findViewById(R.id.button);
       editText = view.findViewById(R.id.et);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String str = editText.getText().toString().trim();
               // 方式一：可以调用findFragmentById方法根据id获得fragment的对象，调用fragment的方法赋值
//               RightFragment rightFragment = (RightFragment) getFragmentManager().findFragmentById(R.id.rightfragment);
//               rightFragment.setText(str);

               // 方式二：通过getView()进一步获取view
//               TextView tv = getFragmentManager().findFragmentById(R.id.rightfragment)
//                       .getView().findViewById(R.id.textView);
//               tv.setText(str);

               // 方式三：先调用getactivity()方法获取所属activity对象，然后调用findviewbyid获取目标控件
               TextView tv = getActivity().findViewById(R.id.textView);
               tv.setText(str);

           }
       });

       return view;
    }
}
