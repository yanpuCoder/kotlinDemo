package com.yp.net.client.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author : yanpu
 * @date : 2021/6/7
 * @description: 通用heater
 */
class HeaderInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}