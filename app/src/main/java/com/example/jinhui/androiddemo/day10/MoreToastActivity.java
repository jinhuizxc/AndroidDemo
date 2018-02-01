package com.example.jinhui.androiddemo.day10;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/1.
 * Email:1004260403@qq.com
 */

public class MoreToastActivity extends AppCompatActivity {

    @BindView(R.id.btnSimpleToast)
    Button btnSimpleToast;
    @BindView(R.id.btnSimpleToastWithCustomPosition)
    Button btnSimpleToastWithCustomPosition;
    @BindView(R.id.btnSimpleToastWithImage)
    Button btnSimpleToastWithImage;
    @BindView(R.id.btnCustomToast)
    Button btnCustomToast;
    @BindView(R.id.btnRunToastFromOtherThread)
    Button btnRunToastFromOtherThread;

    Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moretoast);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSimpleToast, R.id.btnSimpleToastWithCustomPosition, R.id.btnSimpleToastWithImage, R.id.btnCustomToast, R.id.btnRunToastFromOtherThread})
    public void onViewClicked(View view) {
        Toast toast;
        switch (view.getId()) {
            case R.id.btnSimpleToast:
                // 两种样式不同：getApplicationContext()、this
                Toast.makeText(getApplicationContext(), "默认Toast样式", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "默认Toast样式", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSimpleToastWithCustomPosition:
                toast = Toast.makeText(getApplicationContext(), "自定义位置Toast", Toast.LENGTH_LONG);
                // 设置toast显示位置、以及偏移量
                toast.setGravity(Gravity.START | Gravity.BOTTOM, 30, 30);
                toast.show();
                break;
            case R.id.btnSimpleToastWithImage:
                toast = Toast.makeText(getApplicationContext(), "带图片的Toast", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);

                LinearLayout linearLayout = (LinearLayout) toast.getView();
                // 自定义图片
                ImageView image = new ImageView(getApplicationContext());
                image.setImageResource(R.drawable.ic_launcher);

                linearLayout.addView(image, 0);
                toast.show();
                break;
            case R.id.btnCustomToast:
//                LayoutInflater inflater = this.getLayoutInflater();
//                View layout = inflater.inflate(R.layout.custom, (ViewGroup) findViewById(R.id.llToast));
                View layout = LayoutInflater.from(this).inflate(R.layout.custom, null);

                ImageView image1 = (ImageView) layout.findViewById(R.id.tvImageToast);
                image1.setImageResource(R.drawable.ic_launcher);

                TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
                title.setText("Attention");

                TextView text = (TextView) layout.findViewById(R.id.tvTextToast);
                text.setText("完全自定义Toast");

                toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.RIGHT | Gravity.TOP, 12, 40);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
                break;
            case R.id.btnRunToastFromOtherThread:
                new Thread(new Runnable() {
                    public void run() {
                        showToast();
                        // 报错：java.lang.RuntimeException: Can't create handler inside thread that has not called Looper.prepare()
//                        Toast.makeText(getApplicationContext(), "我来自其他线程！", Toast.LENGTH_SHORT).show();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MoreToastActivity.this, "我来自其他线程!", Toast.LENGTH_SHORT).show();
                            }
                        }, 5000);
                    }
                }).start();
                break;
        }
    }

    private void showToast() {
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(getApplicationContext(), "我来自其他线程！", Toast.LENGTH_SHORT).show();
//            }
//        });
    }


}
