package com.example.jinhui.androiddemo.day21.pulltorefresh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class Footer extends LinearLayout {

    private Button btn;
    private ProgressBar pb;

    public Footer(Context context) {
        super(context);

        LinearLayout child = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.footer2, null);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        btn = (Button) child.findViewById(R.id.button1);
        pb = (ProgressBar) child.findViewById(R.id.progressBar1);

        this.addView(child, params);
    }

    public Footer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Footer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtnVisible(boolean is) {
        if (is) {
            btn.setVisibility(View.VISIBLE);
            pb.setVisibility(View.GONE);
        } else {
            btn.setVisibility(View.GONE);
            pb.setVisibility(View.VISIBLE);
        }
    }
}
