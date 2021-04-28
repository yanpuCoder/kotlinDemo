package com.yp.bridge.frame

import android.app.Activity
import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yp.bridge.BridgeContext
import com.yp.bridge.log.Logger
import com.yp.bridge.util.ScreenUtils
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * @author : yanpu
 * @date : 2021/4/21
 * @description:使用margin定位控件位置
 */
object AutoMarginUtils {

    var displayWidth: Int = 0
    var displayHeight: Int = 0

    private var designWidth: Int = 0
    private var designHeight: Int = 0

    private var textPixelsRate: Double = 0.0

    fun setSize(context: Context, hasStatusBar: Boolean, designW: Int, designH: Int) {
        if (designHeight < 1 || designWidth < 1) return
        val point = ScreenUtils.getScreenRealPoint(context)
        point?.also {
            val width = it.x
            var height = it.y
            Logger.e("width: $width   height:$height")
            if (hasStatusBar) {
                height -= ScreenUtils.getStatusBarHeight(context)
            }
            displayWidth = width
            displayHeight = height

            designWidth = designW
            designHeight = designH

            val displayDiagonal =
                sqrt(displayWidth.toDouble().pow(2.0) + displayHeight.toDouble().pow(2.0))
            val designDiagonal =
                sqrt(designWidth.toDouble().pow(2.0) + designHeight.toDouble().pow(2.0))
            textPixelsRate = displayDiagonal / designDiagonal
        }
    }

    fun auto(activity: Activity) {
        if (displayHeight < 1 || displayWidth < 1) return
        var view = activity.window.decorView
        auto(view)
    }

    fun auto(view: View) {
        if (displayHeight < 1 || displayWidth < 1) return
        autoTextSize(view)
        autoSize(view)
        autoPadding(view)
        autoMargin(view)

        if (view is ViewGroup) {
            auto(view)
        }
    }

    private fun auto(viewGroup: ViewGroup) {
        val count = viewGroup.childCount
        for (i in 0 until count) {
            val childAt = viewGroup.getChildAt(i)
            childAt?.let {
                auto(it)
            }
        }
    }

    fun autoMargin(view: View) {
        if (view.layoutParams is ViewGroup.MarginLayoutParams) {
            val lp = view.layoutParams as ViewGroup.MarginLayoutParams
            lp.leftMargin = getDisplayWidthValue(lp.leftMargin)
            lp.topMargin = getDisplayHeightValue(lp.topMargin)
            lp.rightMargin = getDisplayWidthValue(lp.rightMargin)
            lp.bottomMargin = getDisplayHeightValue(lp.bottomMargin)
        }
    }

    fun autoPadding(view: View) {
        var l = view.paddingLeft
        var t = view.paddingTop
        var r = view.paddingRight
        var b = view.paddingBottom

        l = getDisplayWidthValue(l)
        t = getDisplayHeightValue(t)
        r = getDisplayWidthValue(r)
        b = getDisplayHeightValue(b)

        view.setPadding(l, t, r, b)
    }

    fun autoSize(view: View) {
        var layoutParams = view.layoutParams
        layoutParams?.let { lp ->

            var isSquare = false
            if (lp.width == lp.height) {
                isSquare = true
            }

            if (lp.width > 0) {
                lp.width = getDisplayWidthValue(lp.width)
            }

            if (lp.height > 0) {
                lp.height = getDisplayHeightValue(lp.height)
            }

            if (isSquare) {
                if (lp.width > lp.height) {
                    lp.width = lp.height
                } else {
                    lp.height = lp.width
                }
            }
        }
    }

    fun autoTextSize(view: View) {
        if (view is TextView) {
            val designPixels = view.textSize
            val displayPixels = textPixelsRate * designPixels
            view.includeFontPadding = false
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, displayPixels.toFloat())
        }
    }

    fun getDisplayWidthValue(designWidthValue: Int): Int {
        if (abs(designWidthValue) < 2) {
            return designWidthValue
        } else if (designWidth == 0) {
            designWidth = BridgeContext.DESIGN_WIDTH
        }
        return designWidthValue * displayWidth / designWidth
    }

    fun getDisplayHeightValue(designHeightValue: Int): Int {
        if (abs(designHeightValue) < 2) {
            return designHeightValue
        } else if (designHeight == 0) {
            designHeight = BridgeContext.DESIGN_HEIGHT
        }
        return designHeightValue * displayHeight / designHeight
    }

    fun getDisplayTextSize(designTextSize: Float): Float {
        return (textPixelsRate * designTextSize).toFloat()
    }

    fun getTextPixelsRate(): Double {
        return if (textPixelsRate == 0.0) 1.0 else textPixelsRate
    }
}