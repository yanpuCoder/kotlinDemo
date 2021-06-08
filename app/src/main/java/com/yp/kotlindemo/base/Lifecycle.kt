package com.yp.kotlindemo.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.yp.net.bean.BaseBean
import com.yp.net.bean.BaseDataBean

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
        liveData.observe(this, Observer(body))

fun <L : LiveData<BaseBean>> LifecycleOwner.failure(liveData: L, body: (BaseBean?) -> Unit) =
        liveData.observe(this, Observer(body))