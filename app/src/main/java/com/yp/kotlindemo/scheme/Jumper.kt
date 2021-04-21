package com.yp.kotlindemo.scheme

/**
 * @date: 2021/4/21 23:02
 * @author: yp
 * @description: 内部跳转配置
 */
object Jumper {

    private var target: IJumperTarget? = null

    fun setTarget(target: IJumperTarget) {
        Jumper.target = target
    }

    fun startMainActivity() {
        target?.startMainActivity()
    }


}