package com.yp.kotlindemo.home.manager

import com.yp.kotlindemo.home.api.HomeApi
import com.yp.kotlindemo.home.bean.ArticleBean
import com.yp.net.bean.BaseBean
import com.yp.net.bean.BaseDataBean
import com.yp.net.bean.ExtData
import com.yp.net.manager.BaseManager

/**
 * @author : yanpu
 * @date : 2021/6/4
 * @description:
 */
class HomeManager : BaseManager() {


    suspend fun getArticle(): ExtData<BaseDataBean<List<ArticleBean>>, BaseBean> =
        request(getService(HomeApi::class.java).queryArticle())


}