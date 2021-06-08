package com.yp.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.yp.bridge.log.Logger
import com.yp.bridge.util.ScreenUtils
import com.yp.kotlindemo.base.BaseActivity
import com.yp.kotlindemo.base.failure
import com.yp.kotlindemo.base.observe

import com.yp.kotlindemo.home.model.HomeViewModel
import java.io.IOException
import java.util.concurrent.TimeUnit

class MainActivity :BaseActivity() {

    private val viewModel:HomeViewModel by viewModels()

    companion object {
        fun start() {
            val intent = Intent()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.articleData()

        failure(viewModel.failure, {
            Log.e("TAG", "onCreate: ${it?.message}")
        })

        observe(viewModel.list, {
            it?.let {
                Log.e("TAG", "onCreate: $it")
                Log.e("TAG", "onCreate: ${it[0].name}")
            }
        })




        Logger.e("ScreenHeight: ${ScreenUtils.getScreenHeight(this)}")
        Logger.e("ScreenWidth: ${ScreenUtils.getScreenWidth(this)}")
        Logger.e("ScreenRealHeight: ${ScreenUtils.getScreenRealHeight(this)}")
        Logger.e("ScreenRealWidth: ${ScreenUtils.getScreenRealWidth(this)}")
        var statusBarHeight = ScreenUtils.getStatusBarHeight(this)
        Logger.e("getStatusBarHeight: $statusBarHeight")
        Logger.e("getNavigationBarHeight: ${ScreenUtils.getNavigationBarHeight(this)}")
        Logger.e("isAllScreenDevice: ${ScreenUtils.isAllScreenDevice(this)}")

        Log.e("TAG", "onCreate: $string")
        string = "呵呵"

    }



    fun onClick(view: View) {

        startActivity(Intent(this, MainActivity2::class.java))
    }

    private fun show(s: String) {
        Log.e("TAG", "show: $s" )
    }

    var string: String? = null
        get() = main2(this::show)

    private fun main2(a: (s: String) -> Unit): String {
        a("哈哈")
        return "aa"
    }

}

