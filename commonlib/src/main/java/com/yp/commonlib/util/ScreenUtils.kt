package com.yp.commonlib.util

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager
import com.yp.commonlib.log.Logger

/**
 * @author : yanpu
 * @date : 2021/4/21
 * @description: 屏幕工具类
 */
object ScreenUtils {

    fun getScreenWidth(context: Activity): Int {
        try {
            return context.resources?.displayMetrics?.widthPixels ?: 0
        } catch (e: Exception) {
            Logger.e("getScreenWidth: 获取屏幕宽失败")
        }
        return 0
    }

    fun getScreenHeight(context: Activity): Int {
        try {
            return context.resources?.displayMetrics?.heightPixels ?: 0
        } catch (e: Exception) {
            Logger.e("getScreenHeight: 获取屏幕高失败")
        }
        return 0
    }

    fun getScreenRealPoint(context: Context): Point? {
        val sRealSize = arrayOfNulls<Point>(2)
        val point = Point()
        try {
            var orientation = context.resources?.configuration?.orientation ?: 1
            Logger.e("屏幕方向：$orientation")
            orientation = if (orientation == 1) 0 else 1
            if (sRealSize[orientation] == null) {
                val windowManager =
                    context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
                val display = windowManager.defaultDisplay

                display.getRealSize(point)
                sRealSize[orientation] = point
            }
            return sRealSize[orientation]
        } catch (e: Exception) {
            Logger.e("获取屏幕宽高失败")
        }
        return null
    }

    fun getScreenRealWidth(context: Activity): Int {
        return getScreenRealPoint(context)?.x ?: getScreenRealHeight(context)
    }

    fun getScreenRealHeight(context: Activity): Int {
        return getScreenRealPoint(context)?.y ?: getScreenRealHeight(context)
    }

    /**
     * 获取状态栏高度
     */
    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        try {
            val resourceId =
                context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (0 < resourceId) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
            Logger.e("status_bar_height：状态栏高度: $result")
        } catch (e: Exception) {
            Logger.e("status_bar_height： 获取状态栏高度失败")
        }
        return result
    }

    /**
     * 获取导航栏高度
     */
    fun getNavigationBarHeight(context: Context): Int {
        var result = 0
        try {
            val resourceId =
                context.resources.getIdentifier("navigation_bar_height", "dimen", "android")
            if (0 < resourceId){
                result = context.resources.getDimensionPixelSize(resourceId)
            }
            Logger.e("navigation_bar：导航栏高度: $result")
        } catch (e: Exception) {
            Logger.e("navigation_bar： 获取导航栏高度失败")
        }
        return result
    }

    /**
     * 是否是全面屏
     */
    fun isAllScreenDevice(context: Context): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return false
        } else {
            val point = getScreenRealPoint(context)
            point?.let {
                val width: Float
                val height: Float
                if (it.x < it.y) {
                    width = point.x.toFloat()
                    height = point.y.toFloat()
                } else {
                    width = point.y.toFloat()
                    height = point.x.toFloat()
                }

                if (height / width >= 1.97f) {
                    return true
                }
            }
        }
        return false
    }
}