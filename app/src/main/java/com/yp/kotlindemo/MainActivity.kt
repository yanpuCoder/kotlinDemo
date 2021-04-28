package com.yp.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yp.bridge.log.Logger
import com.yp.bridge.util.ScreenUtils

class MainActivity : AppCompatActivity() {

    companion object {
        fun start() {
            val intent = Intent()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Logger.e("ScreenHeight: ${ScreenUtils.getScreenHeight(this)}")
        Logger.e("ScreenWidth: ${ScreenUtils.getScreenWidth(this)}")
        Logger.e("ScreenRealHeight: ${ScreenUtils.getScreenRealHeight(this)}")
        Logger.e("ScreenRealWidth: ${ScreenUtils.getScreenRealWidth(this)}")
        var statusBarHeight = ScreenUtils.getStatusBarHeight(this)
        Logger.e("getStatusBarHeight: $statusBarHeight")
        Logger.e("getNavigationBarHeight: ${ScreenUtils.getNavigationBarHeight(this)}")
        Logger.e("isAllScreenDevice: ${ScreenUtils.isAllScreenDevice(this)}")

    }

    fun onClick(view: View) {
        startActivity(Intent(this, MainActivity2::class.java))
    }
}