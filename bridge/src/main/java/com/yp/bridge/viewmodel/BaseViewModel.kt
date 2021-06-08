package com.yp.bridge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author : yanpu
 * @date : 2021/5/25
 * @description:
 */
class BaseViewModel(app: Application) : AndroidViewModel(app), LifecycleObserver {

    private fun launchUI(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch { block() }

    fun launchResult(block: suspend CoroutineScope.() -> Unit){

        launchUI {
            withContext(Dispatchers.IO){
               block()
            }
        }
    }

}