package com.yp.bridge.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author : yanpu
 * @date : 2021/4/23
 * @description:
 */
abstract class BridgeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    abstract fun getLayoutId():Int

}