package com.yp.kotlindemo.scheme

import com.yp.kotlindemo.MainActivity

/**
 * @date: 2021/4/21 23:22
 * @author: yp
 * @description:
 */
class TargetImpl: IJumperTarget {


    override fun startMainActivity() {
        MainActivity.start()
    }


}