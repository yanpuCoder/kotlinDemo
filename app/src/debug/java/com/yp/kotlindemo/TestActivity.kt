package com.yp.kotlindemo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * @date: 2021/4/21 22:57
 * @author: yp
 * @description:
 */
class TestActivity : Activity() {

    companion object{
        fun start(context: Context){
            val intent = Intent(context, TestActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}