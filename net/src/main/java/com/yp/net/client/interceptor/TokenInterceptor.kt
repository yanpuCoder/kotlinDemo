package com.yp.net.client.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.net.HttpURLConnection

/**
 * @author : yanpu
 * @date : 2021/6/7
 * @description:
 */
open class TokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        if (response.code == HttpURLConnection.HTTP_UNAUTHORIZED){
            unauthorized()
        }
        return response
    }

    protected fun unauthorized(){

    }

}