package com.example.jinhui.androiddemo.day23.fragment01.java;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class FragmentJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentjava);

        if (savedInstanceState == null) {
            //Fragment动态加载
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     *
     * 用的是import android.app.Fragment;
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);
            return rootView;
        }
    }
}
