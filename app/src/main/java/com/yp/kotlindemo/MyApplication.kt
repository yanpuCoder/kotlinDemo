package com.yp.kotlindemo

import com.yp.bridge.BridgeApplication
import com.yp.kotlindemo.net.OkHttpClient
import com.yp.net.RetrofitInstance
import com.yp.net.common.NetContext


/**
 * @date: 2021/4/21 23:24
 * @author: yp
 * @description:
 */
class MyApplication:BridgeApplication() {

    override fun onCreate() {
        super.onCreate()
        RetrofitInstance.instance.init(NetContext.DOMAIN_BASE, OkHttpClient().getTokenClient())
    }
}