package com.yp.kotlindemo.net

import com.yp.net.client.TokenClient

/**
 * @author : yanpu
 * @date : 2021/6/7
 * @description: 处理自己的业务
 */
class OkHttpClient : TokenClient() {

    override fun customBuilder(builder: okhttp3.OkHttpClient.Builder): okhttp3.OkHttpClient.Builder {

        return super.customBuilder(builder)
    }

}