package com.yp.bridge

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.ReportFragment
import com.yp.bridge.listener.ActivityLifecycleCallback
import com.yp.bridge.listener.AppForeBackListener

/**
 * @author : yanpu
 * @date : 2021/4/23
 * @description:
 */
open class BridgeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // 应用进入前后台
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())

        registerActivityLifecycleCallbacks(ActivityLifecycleCallback())

    }
}