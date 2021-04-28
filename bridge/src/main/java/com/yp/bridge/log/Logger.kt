package com.yp.bridge.log

import android.util.Log
import com.yp.commonlib.BuildConfig

/**
 * @author : yanpu
 * @date : 2021/4/21
 * @description:
 */
object Logger {

    private const val TAG = "Test"
    const val V = Log.VERBOSE
    const val D = Log.DEBUG
    const val I = Log.INFO
    const val W = Log.WARN
    const val E = Log.ERROR
    const val A = Log.ASSERT

    fun e(vararg content: String){
        if (BuildConfig.DEBUG) {
            val sb = StringBuffer()
            for (element in content){
                sb.append("\n\t")
                sb.append(element)
            }
            Log.e(TAG, "e: ${sb.toString()}")
        }
    }
}