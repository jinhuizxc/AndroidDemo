package com.example.jinhui.androiddemo.day25.mvvm.retrofitinterface;



import com.example.jinhui.androiddemo.day25.mvvm.bean.NewsBean;
import com.example.jinhui.androiddemo.day25.mvvm.constant.URLConstant;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 作者： 周旭 on 2017年10月17日 0017.
 * 邮箱：374952705@qq.com
 * 博客：http://www.jianshu.com/u/56db5d78044d
 */

public interface RetrofitInterface {

    //获取“分类中搜索商品”的数据
    @GET(URLConstant.URL_PATH)
    Observable<NewsBean> getNewsData();
}
