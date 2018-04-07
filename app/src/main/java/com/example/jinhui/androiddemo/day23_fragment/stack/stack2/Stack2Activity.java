package com.example.jinhui.androiddemo.day23_fragment.stack.stack2;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 *
 * 关于后台栈，以及根据现在项目需要进行测试！
 * 传值，2个fragment：文章页，答案页面，
 *
 * 需求：来回切换，答案页有答案的话再次打开页面显示答案
 */

public class Stack2Activity extends AppCompatActivity implements Stack1Fragment.MyListener, Stack2Fragment.CallBack {

    private int stageId = 123;
    boolean isRequest = true;

    Stack1Fragment stackFragment1;
    Stack2Fragment stackFragment2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack2);

        //添加Fragment01
        stackFragment1 = new Stack1Fragment();
        stackFragment2 = new Stack2Fragment();

        FragmentTransaction tran = this.getFragmentManager().beginTransaction();
        tran.add(R.id.rr, stackFragment1);
        tran.addToBackStack(null);
        tran.add(R.id.rr, stackFragment2);
//        tran.addToBackStack(null);

        Bundle bundle = new Bundle();
        bundle.putInt("stageId", stageId);
        stackFragment1.setArguments(bundle);
        // 设置监听
        stackFragment1.setListener(this);
        stackFragment2.setCallBack(this);

        tran.show(stackFragment1);
        tran.hide(stackFragment2);

//        tran.addToBackStack(null);
        tran.commit();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
//            Toast.makeText(this, "点击物理返回键", Toast.LENGTH_SHORT).show();
            if (stackFragment1.isVisible()){
                this.finish();
            }
            if (stackFragment2.isVisible()){
                FragmentTransaction tran = this.getFragmentManager().beginTransaction();
                tran.show(stackFragment1);
                tran.hide(stackFragment2);
                tran.commit();
            }
        }
        return true;
    }

    /**
     * 点击去挑战
     */
    @Override
    public void update() {
        // 加载文章
        FragmentTransaction tran = this.getFragmentManager().beginTransaction();
//        tran.replace(R.id.rr, stack2Fragment); // replace会将当前fragment remove再add添加，不用？。
        tran.hide(stackFragment1);
        if (stackFragment2 != null){
            tran.show(stackFragment2);
            Toast.makeText(this, "有文章", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "没文章", Toast.LENGTH_SHORT).show();
        }
//        tran.addToBackStack(null);
        tran.commit();
    }

    /**
     * 点击返回
     */
    @Override
    public void update1() {
        //替换碎片, 不要new
        FragmentTransaction tran = this.getFragmentManager().beginTransaction();
        tran.show(stackFragment1);
        tran.hide(stackFragment2);
        tran.commit();
//        Toast.makeText(this, "update1", Toast.LENGTH_SHORT).show();
    }

    // value = 234;
    @Override
    public void sendValue(int value) {
//        Toast.makeText(this, value + "", Toast.LENGTH_SHORT).show();
        // 有个文章id第一次加载答题，后面就不用在加载答题了
        if (value != 0 && isRequest){
            isRequest = false;
            stackFragment2.requestData(value);
            Toast.makeText(this,  "网络请求数据", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,  "本地", Toast.LENGTH_SHORT).show();
            FragmentTransaction tran = this.getFragmentManager().beginTransaction();
            tran.hide(stackFragment1);
            tran.show(stackFragment2);
            tran.commit();
        }
    }


}
