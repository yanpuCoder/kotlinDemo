package com.yp.kotlindemo.home.api

import com.yp.kotlindemo.home.bean.ArticleBean
import com.yp.net.IService
import com.yp.net.bean.BaseDataBean
import retrofit2.Call
import retrofit2.http.*

/**
 * @author : yanpu
 * @date : 2021/6/4
 * @description:
 */
interface HomeApi : IService {

    @GET("wxarticle/chapters/json")
    fun queryArticle(): Call<BaseDataBean<List<ArticleBean>>>

}