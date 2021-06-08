package com.yp.bridge

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author : yanpu
 * @date : 2021/5/19
 * @description: 监听程序进入前后台
 *
 * Application生命周期观察，提供整个应用进程的生命周期
 * Lifecycle.Event.ON_CREATE只会分发一次，Lifecycle.Event.ON_DESTROY不会被分发。
 * 第一个Activity进入时，ProcessLifecycleOwner将分派Lifecycle.Event.ON_START, Lifecycle.Event.ON_RESUME。
 * 而Lifecycle.Event.ON_PAUSE, Lifecycle.Event.ON_STOP，将在最后一个Activity退出后后延迟分发。
 * 如果由于配置更改而销毁并重新创建活动，则此延迟足以保证ProcessLifecycleOwner不会发送任何事件。
 */
class ApplicationLifecycleObserver() : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onAppForeground() {
        Log.e("TAG", "onAppForeground: 进入前台")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onAppBackground() {
        Log.e("TAG", "onAppForeground: 进入后台")
    }
}