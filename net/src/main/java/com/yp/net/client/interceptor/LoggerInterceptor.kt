package com.yp.net.client.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author : yanpu
 * @date : 2021/6/7
 * @description: 日志抓取
 */
class LoggerInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.e("Interceptor", "intercept: ${request.url} , ${chain.connection()}, ${request.headers}" )
        return chain.proceed(request)
    }
}