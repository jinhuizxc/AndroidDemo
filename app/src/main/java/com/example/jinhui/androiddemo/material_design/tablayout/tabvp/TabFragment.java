package com.example.jinhui.androiddemo.material_design.tablayout.tabvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jh on 2018/9/4.
 * Email: 1004260403@qq.com
 */
public class TabFragment extends Fragment {

    private String mTitle;

    public void setTitle(String title) {
        this.mTitle = title;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView textView = new TextView(getContext());
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        textView.setGravity(Gravity.CENTER);
        textView.setText(mTitle);
        return textView;
    }

}
