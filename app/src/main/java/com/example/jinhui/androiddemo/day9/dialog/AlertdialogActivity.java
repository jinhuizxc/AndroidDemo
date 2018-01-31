package com.example.jinhui.androiddemo.day9.dialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 * <p>
 * 对话框
 * 对话框是在当前界面弹出的一个小窗口，用于显示重要提示信息，
 * 提示用户输入信息，确认信息，或者显示某种状态，如下载进度，退出提示等等。
 * 一般情况下，用户要与对话框进行交互，然后返回到被遮盖的界面以继续运行当前的应用程序。
 * <p>
 * AlertDialog常用方法
 * 要创建一个AlertDialog，就要用到AlertDialog.Builder中的create()方法
 * 1. setTitle:为对话框设置标题
 * 2. setIcon:为对话框设置图标
 * 3. setMessage:为对话框设置内容
 * 4. setView:为对话框设置自定义样式
 * 5. setItems:设置对话框要显示的一个list
 * 6. setMutiChoiceItems:设置对话框显示一系列的复选框
 * 7. setSingleChoiceItems:设置单选按钮
 * 8. setNeutralButton:普通按钮
 * 9. setPositiveButton:确认按钮
 * 10. setNegativeButton:取消按钮
 */

public class AlertdialogActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.textView1)
    TextView textView1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                doNormalDialog();
                break;
            case R.id.button2:
                doSingleButtonDialog();
                break;
            case R.id.button3:
                doMutiCheckDialog();
                break;
            case R.id.button4:
                doItemDialog();
                break;
            case R.id.button5:
                doCustomDialog();
                break;
            case R.id.button6:
                doProgressDialog();
                break;
        }
    }

    /**
     * 进度条对话框
     */
    private void doProgressDialog() {

        final ProgressDialog pd = ProgressDialog.show(this, "搜索网络", "请耐心等待...");
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);  // 执行5秒后对话框消失
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //取消对话框
                pd.dismiss();

            }
        }).start();
    }

    /**
     * 自定义对话框
     */
    private void doCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("注册");

        View view = LayoutInflater.from(this).inflate(R.layout.register, null);
        builder.setView(view);

        final EditText etName = (EditText) view.findViewById(R.id.editText1);
        final EditText etPass = (EditText) view.findViewById(R.id.editText2);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = etName.getText().toString();
                String pass = etPass.getText().toString();
                textView1.setText(name + " " + pass);
            }
        });
        builder.setNegativeButton("取消", null);

        builder.create();
        builder.show();
    }

    /**
     * 列表对话框
     */
    private void doItemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("部门成员");

        String items[] = {"项目经理", "美术", "策划", "测试", "程序员"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertdialogActivity.this, "which = " + which, Toast.LENGTH_SHORT).show();
            }
        });

        builder.create();
        builder.show();
    }

    /**
     * 多选对话框
     */
    private void doMutiCheckDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("爱好");
        String items[] = {"篮球", "足球", "男", "女"};
        boolean isCheck[] = {false, false, false, false};
        builder.setMultiChoiceItems(items, isCheck,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        Toast.makeText(AlertdialogActivity.this, "which = " + which + " " + isChecked, Toast.LENGTH_SHORT).show();
                    }
                });

        builder.create();
        builder.show();
    }

    /**
     * 单选按钮对话框
     */
    private void doSingleButtonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择性别");
        String items[] = {"男", "女", "程序员"};
        builder.setSingleChoiceItems(items, 2,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertdialogActivity.this, "which = " + which, Toast.LENGTH_SHORT).show();
                    }
                });

        builder.create();
        builder.show();
    }

    /**
     * 普通对话框
     */
    private void doNormalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 设置对话框标题栏
        builder.setTitle("标题");
        // 对话框正文
        builder.setMessage("是否退出应用程序");
        builder.setIcon(R.drawable.ic_launcher);
        // 设置对话框按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("取消", null);
        builder.setNeutralButton("中间", null);
        // 创建对话框
        builder.create();
        // 显示对话框
        builder.show();
    }
}
