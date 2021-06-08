package com.yp.bridge.manager

import android.app.Activity
import java.io.Serializable
import java.lang.ref.WeakReference
import java.util.*

/**
 * @author : yanpu
 * @date : 2021/5/19
 * @description:
 */
class ActivityManager private constructor() : Serializable {

    private var activities = Stack<WeakReference<Activity>>()

    companion object {
        @JvmStatic
        val instant: ActivityManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { ActivityManager() }
    }

    // 防止单例对象在反序列化时重新生成对象
    private fun readResolve(): Any {
        return instant
    }

    /**
     * 压栈
     */
    fun push(activity: Activity) {
        activities.push(WeakReference(activity))
    }

    /**
     * 出栈
     */
    fun pop(): Activity? {
        return if (activities.isEmpty()) {
            null
        } else {
            activities.pop().get()
        }
    }

    /**
     * 移除
     */
    fun remove(activity: Activity) {
        if (!activities.isEmpty() && activity == activities.peek()) {
            activities.pop()
        } else {
            val iterator = activities.iterator()
            while (iterator.hasNext()){
                val next = iterator.next()
                next?.get()?.let {
                    if (it == activity){
                        iterator.remove()
                    }
                }
                break
            }
        }
    }

    fun finishActivity(activity: Activity) {
        activity.finish()
        remove(activity)
    }

    fun finishAllActivity() {
        while (!activities.isEmpty()) {
            val activity = activities.pop()
            activity?.get()?.let {
                finishActivity(it)
            }
        }
    }
}