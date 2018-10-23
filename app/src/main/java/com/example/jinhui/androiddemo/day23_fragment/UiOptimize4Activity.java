package com.example.jinhui.androiddemo.day23_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day23_fragment.dialogfragment.DialogFragmentActivity;
import com.example.jinhui.androiddemo.day23_fragment.example.WeixinActivity;
import com.example.jinhui.androiddemo.day23_fragment.example1.TopActivity;
import com.example.jinhui.androiddemo.day23_fragment.fragment01.java.FragmentJavaActivity;
import com.example.jinhui.androiddemo.day23_fragment.fragment01.xml.FragmentXmlActivity;
import com.example.jinhui.androiddemo.day23_fragment.fragment02.Fragment02Activity;
import com.example.jinhui.androiddemo.day23_fragment.fragment03.ShowHideActivity;
import com.example.jinhui.androiddemo.day23_fragment.fragmentanim.Fragment_animActivity;
import com.example.jinhui.androiddemo.day23_fragment.listfragment.ListFragmentActivity;
import com.example.jinhui.androiddemo.day23_fragment.send_data.activity_fragment.Activity_fragmentActivity;
import com.example.jinhui.androiddemo.day23_fragment.send_data.fragment_activity.Fragment_activityActivity;
import com.example.jinhui.androiddemo.day23_fragment.send_data.fragment_fragment.Fragment_FragmentActivity;
import com.example.jinhui.androiddemo.day23_fragment.stack.stack1.Stack1Activity;
import com.example.jinhui.androiddemo.day23_fragment.stack.stack2.Stack2Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 *
 * 界面优化4
 */

public class UiOptimize4Activity extends AppCompatActivity {

    @BindView(R.id.bt_fragment_java)
    Button btFragmentJava;
    @BindView(R.id.bt_fragment_xml)
    Button btFragmentXml;
    @BindView(R.id.bt_fragment2)
    Button btFragment2;
    @BindView(R.id.bt_show_hide)
    Button btShowHide;
    @BindView(R.id.bt_stack1)
    Button btStack1;
    @BindView(R.id.bt_stack2)
    Button btStack2;
    @BindView(R.id.bt_activity_fragment)
    Button btActivityFragment;
    @BindView(R.id.bt_fragment_activity)
    Button btFragmentActivity;
    @BindView(R.id.bt_fragment_fragment)
    Button btFragmentFragment;
    @BindView(R.id.bt_fragment_anim)
    Button btFragmentAnim;
    @BindView(R.id.bt_fragment)
    Button btFragment;
    @BindView(R.id.bt_weixin)
    Button btWeixin;
    @BindView(R.id.bt_top)
    Button btTop;
    @BindView(R.id.bt_list_fragment)
    Button btListFragment;
    @BindView(R.id.bt_dialog_fragment)
    Button btDialogFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uioptimize4);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_fragment_java, R.id.bt_fragment_xml, R.id.bt_fragment2,
            R.id.bt_show_hide, R.id.bt_stack1, R.id.bt_stack2,
            R.id.bt_activity_fragment, R.id.bt_fragment_activity,
            R.id.bt_list_fragment, R.id.bt_dialog_fragment,
            R.id.bt_fragment_fragment, R.id.bt_fragment_anim, R.id.bt_fragment, R.id.bt_weixin,
            R.id.bt_top})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_fragment_java:
                startActivity(new Intent(this, FragmentJavaActivity.class));
                break;
            case R.id.bt_fragment2:
                startActivity(new Intent(this, Fragment02Activity.class));
                break;
            case R.id.bt_fragment_xml:
                startActivity(new Intent(this, FragmentXmlActivity.class));
                break;
            case R.id.bt_show_hide:
                startActivity(new Intent(this, ShowHideActivity.class));
                break;
            case R.id.bt_stack1:
                startActivity(new Intent(this, Stack1Activity.class));
                break;
            case R.id.bt_stack2:
                startActivity(new Intent(this, Stack2Activity.class));
                break;
            case R.id.bt_activity_fragment:
                startActivity(new Intent(this, Activity_fragmentActivity.class));
                break;
            case R.id.bt_fragment_activity:
                startActivity(new Intent(this, Fragment_activityActivity.class));
                break;
            case R.id.bt_fragment_fragment:
                startActivity(new Intent(this, Fragment_FragmentActivity.class));
                break;
            case R.id.bt_list_fragment:
                startActivity(new Intent(this, ListFragmentActivity.class));
                break;
            case R.id.bt_dialog_fragment:
                startActivity(new Intent(this, DialogFragmentActivity.class));
                break;
            case R.id.bt_fragment_anim:
                startActivity(new Intent(this, Fragment_animActivity.class));
                break;
            case R.id.bt_fragment:
                doFragment();
                break;
            case R.id.bt_weixin:
                startActivity(new Intent(this, WeixinActivity.class));
                break;
            case R.id.bt_top:
                startActivity(new Intent(this, TopActivity.class));
                break;
        }
    }

    /**
     * Fragment的生命周期
     * <p>
     * Fragment必须嵌入在Acitivity中使用，所以Fragment的生命周期和它所在的Activity是密切相关的。
     * 如果Activity是暂停状态，其中所有的Fragment都是暂停状态。
     * 如果Activity是stopped状态，这个Activity中所有的Fragment都停止。
     * 如果Activity被销毁，那么它其中的所有Fragment都会被销毁。
     * Activity在活动状态时，可以独立控制Fragment的状态，可以随时添加或者移除Fragment。
     * <p>
     * Fragment生命周期方法——11个方法：
     * onAttach:当fragment和activity衔接上时被调用
     * onCreate:状态初始化
     * onCreateView：界面初始化
     * onActivityCreated：初始化工作完成
     * onStart：显示
     * onResume：获取焦点
     * onPause：失去焦点
     * onStop：不可见
     * onDestroyView：fragment中的界面被销毁
     * onDestroy：fragment被销毁
     * onDetach：和Activity断开联系
     */
    private void doFragment() {
        Toast.makeText(this, "见代码注解", Toast.LENGTH_SHORT).show();
    }


}
