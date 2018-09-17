package com.example.jinhui.androiddemo.record.weixin;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.bean.Record;
import com.example.jinhui.androiddemo.widget.AudioRecordButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jh on 2018/9/16.
 * Email: 1004260403@qq.com
 *
 * 微信录音demo: https://github.com/scsfwgy/WeixinRecord
 */
public class WeiXinRecordActivity extends AppCompatActivity {

    private ListView mEmLvRecodeList;
    private AudioRecordButton mEmTvBtn;
    List<Record> mRecords;
    ExampleAdapter mExampleAdapter;
    PermissionHelper mHelper;
    //db
    private DBManager mgr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin_record);

        initView();
        initData();
        initAdapter();
        initListener();


    }

    private void initListener() {
        mEmTvBtn.setHasRecordPromission(false);
        //        授权处理
        mHelper = new PermissionHelper(this);

        mHelper.requestPermissions("请授予[录音]，[读写]权限，否则无法录音",
                new PermissionHelper.PermissionListener() {
                    @Override
                    public void doAfterGrand(String... permission) {
                        mEmTvBtn.setHasRecordPromission(true);
                        mEmTvBtn.setAudioFinishRecorderListener(new AudioRecordButton.AudioFinishRecorderListener() {
                            @Override
                            public void onFinished(float seconds, String filePath) {
                                Record recordModel = new Record();
                                recordModel.setSecond((int) seconds <= 0 ? 1 : (int) seconds);
                                recordModel.setPath(filePath);
                                recordModel.setPlayed(false);
                                mRecords.add(recordModel);
                                mExampleAdapter.notifyDataSetChanged();
                                mEmLvRecodeList.setSelection(mRecords.size() - 1);

                                //添加到数据库
                                mgr.add(recordModel);
                            }
                        });
//                        mEmTvBtn.setAudioFinishRecorderListener((seconds, filePath) -> {
//                            Record recordModel = new Record();
//                            recordModel.setSecond((int) seconds <= 0 ? 1 : (int) seconds);
//                            recordModel.setPath(filePath);
//                            recordModel.setPlayed(false);
//                            mRecords.add(recordModel);
//                            mExampleAdapter.notifyDataSetChanged();
//                            mEmLvRecodeList.setSelection(mRecords.size() - 1);
//
//                            //添加到数据库
//                            mgr.add(recordModel);
//                        });
                    }

                    @Override
                    public void doAfterDenied(String... permission) {
                        mEmTvBtn.setHasRecordPromission(false);
                        Toast.makeText(WeiXinRecordActivity.this, "请授权,否则无法录音", Toast.LENGTH_SHORT).show();
                    }
                }, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private void initAdapter() {
        mExampleAdapter = new ExampleAdapter(this, mRecords);
        mEmLvRecodeList.setAdapter(mExampleAdapter);

        // 开始获取数据库数据
        List<Record> records = mgr.query();
        if (records == null || records.isEmpty()) return;
        for (Record record : records) {
            Log.e("wgy", "initAdapter: " + record.toString());
        }
        mRecords.addAll(records);
        mExampleAdapter.notifyDataSetChanged();
        mEmLvRecodeList.setSelection(mRecords.size() - 1);
    }

    private void initData() {
        mRecords = new ArrayList<>();
        //初始化DBManager
        mgr = new DBManager(this);
    }

    private void initView() {
        mEmLvRecodeList = (ListView) findViewById(R.id.em_lv_recodeList);
        mEmTvBtn = (AudioRecordButton) findViewById(R.id.em_tv_btn);
        //设置不想要可见或者不想被点击
        // mEmTvBtn.setVisibility(View.GONE);//隐藏
        // mEmTvBtn.setCanRecord(false);//重写该方法，设置为不可点击
    }

    public DBManager getMgr() {
        return mgr;
    }
    public void setMgr(DBManager mgr) {
        this.mgr = mgr;
    }
}
