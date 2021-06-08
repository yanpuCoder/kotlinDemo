package com.yp.kotlindemo.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yp.net.bean.BaseBean
import kotlinx.coroutines.*

/**
 * @author : yanpu
 * @date : 2021/5/25
 * @description:
 */
open class BaseViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {

    var failure = MutableLiveData<BaseBean>()

    private fun launchUI(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch { block() }

    fun launchResult(block: suspend CoroutineScope.() -> Unit) {
        launchUI {
            withContext(Dispatchers.IO) {
                block()
            }
        }
    }

    fun launchAsyncResult(block: suspend CoroutineScope.() -> Unit) {
        launchUI {
            block()

        }
    }

    fun handleFailure(errorBean: BaseBean) {
        failure.postValue(errorBean)

        handleError(errorBean.code)
    }

    private fun handleError(code: Int) {
        when(code){
        }
    }
}