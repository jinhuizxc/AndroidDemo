package com.example.jinhui.androiddemo.recyclerview.summary

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.jinhui.androiddemo.R
import com.recycleview.smartrefresh.layout.SmartRefreshLayout
import com.recycleview.smartrefresh.layout.api.RefreshLayout
import com.recycleview.smartrefresh.layout.footer.ClassicsFooter
import com.recycleview.smartrefresh.layout.header.ClassicsHeader
import com.recycleview.smartrefresh.layout.listener.OnLoadMoreListener
import com.recycleview.smartrefresh.layout.listener.OnRefreshListener

import java.util.ArrayList

import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.normal_recyclerview.*


/**
 * Created by jh on 2018/9/16.
 * Email: 1004260403@qq.com
 *
 * kotlin 与 ButterKnife运行会存在一定的空指针异常，注意栏一些变量是否空指针
 *
 *  解决kotlin.KotlinNullPointerException以及问题分析 https://blog.csdn.net/BigBoySunshine/article/details/79299065
 */
class NormalRecycleActivity : AppCompatActivity() {

//    @BindView(R.id.recycleview)
//    internal var recycleview: RecyclerView? = null
//    @BindView(R.id.refreshlayout)
//    internal var refreshlayout: SmartRefreshLayout? = null

    internal var list: MutableList<Int> = ArrayList()
    internal lateinit var adapter: MyAdapter
    internal var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_recyclerview)
//        ButterKnife.bind(this)

        for (i in 0..19) {
            list.add(i)
        }

        adapter = MyAdapter(list, this)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL //加上这句 就可以设置方向
        recycleview!!.layoutManager = layoutManager
        recycleview!!.adapter = adapter

        refreshlayout!!.setRefreshHeader(ClassicsHeader(this))
        refreshlayout!!.setRefreshFooter(ClassicsFooter(this))

        refreshlayout!!.setOnRefreshListener { refreshLayout ->
            handler.postDelayed({
                list.clear()
                for (i in 0..19) {
                    list.add(i)
                }
                adapter.update(list)
                refreshLayout.finishRefresh()
            }, 2000)
        }

        refreshlayout!!.setOnLoadMoreListener { refreshLayout ->
            handler.postDelayed({
                // java代码——>这里运行出现卡死现象，为何？
                //  for (int i = list.size() - 1; i < list.size() - 1 + 20; i++) {
                //      list.add(i);
                //      }
                for (i in list.size..list.size + 20){
                    list.add(i)
                }
//                for (i in 10..19) {
//                    list.add(i)
//                }
                adapter.update(list)
                refreshLayout.finishLoadMore()
            }, 2000)
        }


    }
}
