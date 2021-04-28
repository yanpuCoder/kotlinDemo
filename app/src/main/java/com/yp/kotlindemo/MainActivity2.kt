package com.yp.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yp.bridge.frame.AutoMarginUtils
import com.yp.bridge.log.Logger
import com.yp.bridge.util.ScreenUtils

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Logger.e("MainActivity2: ScreenHeight: ${ScreenUtils.getScreenHeight(this)}")
        Logger.e("MainActivity2: ScreenWidth: ${ScreenUtils.getScreenWidth(this)}")
        Logger.e("MainActivity2: ScreenRealHeight: ${ScreenUtils.getScreenRealHeight(this)}")
        Logger.e("MainActivity2: ScreenRealWidth: ${ScreenUtils.getScreenRealWidth(this)}")
        Logger.e("MainActivity2: getStatusBarHeight: ${ScreenUtils.getStatusBarHeight(this)}")
        Logger.e("MainActivity2: getNavigationBarHeight: ${ScreenUtils.getNavigationBarHeight(this)}")
        Logger.e("MainActivity2: isAllScreenDevice: ${ScreenUtils.isAllScreenDevice(this)}")
        AutoMarginUtils.displayWidth
    }
}