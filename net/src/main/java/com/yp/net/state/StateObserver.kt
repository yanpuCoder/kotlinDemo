package com.yp.net.state

import android.view.View
import androidx.lifecycle.Observer
import com.yp.net.bean.BaseBean
import com.yp.net.bean.BaseDataState.STATE_EMPTY
import com.yp.net.bean.BaseDataState.STATE_ERROR
import com.yp.net.bean.BaseDataState.STATE_FAILED
import com.yp.net.bean.BaseDataState.STATE_SUCCESS

/**
 * @author : yanpu
 * @date : 2021/6/4
 * @description:
 */
open class StateObserver<T : BaseBean>(view: View?) : Observer<T> {

    override fun onChanged(bean: T) {

        when (bean.dataState) {
            STATE_SUCCESS -> {
                onSuccess(bean)
            }
            STATE_EMPTY -> {
                onDataEmpty()
            }
            STATE_FAILED, STATE_ERROR -> {
                onError()
            }
            else -> {

            }
        }
    }


   open fun onSuccess(bean: T) {

    }

    open   fun onDataEmpty() {

    }

    open  fun onError() {

    }
}