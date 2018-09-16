package com.example.jinhui.androiddemo.recyclerview.summary

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

import com.example.jinhui.androiddemo.R

import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_rvsummary.*

/**
 * Created by jh on 2018/9/16.
 * Email: 1004260403@qq.com
 *
 *
 * 上拉加载下拉刷新自定义，左右侧滑自定义
 * https://github.com/LuckyCode1992/recycleviewsummary
 */
class RvSummaryActivity : AppCompatActivity() {

    @BindView(R.id.nor_recycle)
    internal var norRecycle: Button? = null
    @BindView(R.id.zidingyi_recycle)
    internal var zidingyiRecycle: Button? = null
    @BindView(R.id.daicehua_recycle)
    internal var daicehuaRecycle: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvsummary)
        ButterKnife.bind(this)

        nor_recycle.setOnClickListener {
            startActivity(Intent(this,NormalRecycleActivity::class.java))
        }
        zidingyi_recycle.setOnClickListener {
            startActivity(Intent(this, ZhiDingRecycleActivity::class.java))
        }
        daicehua_recycle.setOnClickListener {
            startActivity(Intent(this,DaicehuaRecycleActivity::class.java))
        }

    }

//    @OnClick(R.id.nor_recycle, R.id.zidingyi_recycle, R.id.daicehua_recycle)
//    fun onViewClicked(view: View) {
//        when (view.id) {
//            R.id.nor_recycle -> startActivity(Intent(this, NormalRecycleActivity::class.java))
//            R.id.zidingyi_recycle -> startActivity(Intent(this, ZhiDingRecycleActivity::class.java))
//            R.id.daicehua_recycle -> startActivity(Intent(this, DaicehuaRecycleActivity::class.java))
//        }
//    }

}
