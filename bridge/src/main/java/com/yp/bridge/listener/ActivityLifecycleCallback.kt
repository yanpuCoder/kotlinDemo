package com.yp.bridge.listener

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.yp.bridge.manager.ActivityManager

/**
 * @author : yanpu
 * @date : 2021/5/20
 * @description: 监控activity的生命周期
 */
class ActivityLifecycleCallback : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.e("TAG", "onActivityCreated: ${activity::class.java.simpleName}" )
        ActivityManager.instant.push(activity)
    }

    override fun onActivityStarted(activity: Activity) {
        Log.e("TAG", "onActivityStarted: ${activity::class.java.simpleName}" )
    }

    override fun onActivityResumed(activity: Activity) {
        Log.e("TAG", "onActivityResumed: ${activity::class.java.simpleName}" )
    }

    override fun onActivityPaused(activity: Activity) {
        Log.e("TAG", "onActivityPaused: ${activity::class.java.simpleName}" )
    }

    override fun onActivityStopped(activity: Activity) {
        Log.e("TAG", "onActivityStopped: ${activity::class.java.simpleName}" )
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.e("TAG", "onActivitySaveInstanceState: ${activity::class.java.simpleName}" )
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.e("TAG", "onActivityDestroyed: ${activity::class.java.simpleName}" )
        ActivityManager.instant.remove(activity)
    }
}