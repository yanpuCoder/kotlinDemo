package com.yp.commonlib.util

import android.app.Activity
import android.graphics.Point
import android.os.Build
import android.util.DisplayMetrics
import android.view.Display

/**
 * @author : yanpu
 * @date : 2021/4/21
 * @description: 屏幕工具类
 */
object ScreenUtils {


    fun getDisplayPoint(context: Activity): Point {
        try {

        }catch (e:Exception){

        }
        val point = Point()
        val display = context.windowManager.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)
        when {
            Build.VERSION.SDK_INT >= 17 -> {
                display.getRealSize(point)
            }
            Build.VERSION.SDK_INT in 14..16 -> {
                val mGetRawW = Display::class.java.getMethod("getRawWidth")
                val mGetRawH = Display::class.java.getMethod("getRawHeight")
                point.x = mGetRawW.invoke(display) as Int
                point.y = mGetRawH.invoke(display) as Int
            }
            else -> {
                point.x = metrics.widthPixels
                point.y = metrics.heightPixels
            }
        }
        return point
    }


}