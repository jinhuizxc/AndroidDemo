package com.example.jinhui.androiddemo.recyclerview.summary

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager

import com.example.jinhui.androiddemo.R
import com.recycleview.smartrefresh.layout.footer.ClassicsFooter
import com.recycleview.smartrefresh.layout.header.ClassicsHeader
import kotlinx.android.synthetic.main.activity_daicehua_recycle.*

/**
 * Created by jh on 2018/9/16.
 * Email: 1004260403@qq.com
 */
class DaicehuaRecycleActivity : AppCompatActivity() {

    var list: MutableList<Int> = ArrayList()
    var adapter: MyAdapter? = null
    var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daicehua_recycle)

        for (i in 1..20) {
            list.add(i)
        }
        adapter = MyAdapter(list,this)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleview.layoutManager = linearLayoutManager
        recycleview.adapter = adapter

        refreshlayout.setRefreshHeader(ClassicsHeader(this))
        refreshlayout.setRefreshFooter(ClassicsFooter(this))

        refreshlayout.setOnRefreshListener {
            handler.postDelayed({
                list.clear()
                for (i in 1..10){
                    list.add(i)
                }
                adapter?.update(list)
                it.finishRefresh()

            },2000)

        }
        refreshlayout.setOnLoadMoreListener {
            handler.postDelayed({

                for (i in 101..121){
                    list.add(i)
                }
                adapter?.update(list)
                it.finishLoadMore()

            },2000)
        }
    }

}
