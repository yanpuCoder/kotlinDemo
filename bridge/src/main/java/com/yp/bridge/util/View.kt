package com.yp.bridge.util

import android.view.View

/**
 * @author : yanpu
 * @date : 2021/6/4
 * @description:
 */

fun View?.setVisibility(){
    this?.visibility = View.VISIBLE
}

fun View?.setGone(){
    this?.visibility = View.GONE
}

fun View?.setInVisibility(){
    this?.visibility = View.INVISIBLE
}