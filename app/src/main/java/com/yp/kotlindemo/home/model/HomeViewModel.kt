package com.yp.kotlindemo.home.model

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.yp.kotlindemo.home.bean.ArticleBean
import com.yp.kotlindemo.home.manager.HomeManager
import com.yp.kotlindemo.base.BaseViewModel
import com.yp.net.bean.BaseDataBean

/**
 * @author : yanpu
 * @date : 2021/6/4
 * @description:
 */
class HomeViewModel(app: Application) : BaseViewModel(app) {
    var list = MutableLiveData<List<ArticleBean>>()

    private var manager: HomeManager = HomeManager()

    fun articleData() {
        launchResult {
            manager.getArticle().fold(::handleArticleData, ::handleFailure)
        }
    }

    private fun handleArticleData(bean: BaseDataBean<List<ArticleBean>>) {
        if (bean.data != null)
            list.postValue(bean.data)
    }
}