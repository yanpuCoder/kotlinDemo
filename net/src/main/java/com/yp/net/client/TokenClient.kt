package com.yp.net.client

import com.yp.net.client.interceptor.HeaderInterceptor
import com.yp.net.client.interceptor.LoggerInterceptor
import com.yp.net.client.interceptor.TokenInterceptor
import com.yp.net.common.NetContext
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * @author : yanpu
 * @date : 2021/6/7
 * @description:
 */
open class TokenClient {

    fun getTokenClient(): OkHttpClient {
        return customBuilder(getBuilder()).build()
    }

    open fun customBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        return builder
    }

    fun getBuilder(): OkHttpClient.Builder {
        val builder =
            OkHttpClient.Builder().connectTimeout(NetContext.TIMEOUT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(NetContext.TIMEOUT_READ, TimeUnit.SECONDS)
                .writeTimeout(NetContext.TIMEOUT_WRITE, TimeUnit.SECONDS)
                .addInterceptor(LoggerInterceptor())
                .addInterceptor(HeaderInterceptor())
                .addInterceptor(TokenInterceptor())
//        builder.proxy(Proxy.NO_PROXY)

        return builder
    }
}