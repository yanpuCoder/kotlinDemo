package com.yp.commonlib.util

import android.content.Context
import com.yp.commonlib.log.Logger
import java.lang.Exception

/**
 * @date: 2021/4/22 20:57
 * @author: yp
 * @description: 单位转换
 */
object UnitUtils {

    fun dpToPx(context: Context, dpValue: Float): Int {
        try {
            val scale = context.resources.displayMetrics.density
            return (dpValue * scale + 0.5f * (if (dpValue >= 0) 1 else -1)).toInt()
        } catch (e: Exception) {
            Logger.e(e.toString())
        }
        return 0
    }

    fun pxToDp(context: Context, pxValue: Float): Int {
        try {
            val scale = context.resources.displayMetrics.density
            return (pxValue / scale + 0.5f * (if (pxValue >= 0) 1 else -1)).toInt()
        } catch (e: Exception) {
            Logger.e(e.toString())
        }
        return 0
    }
}