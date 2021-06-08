package com.yp.net.manager

import com.google.gson.JsonSyntaxException
import com.yp.net.RetrofitInstance
import com.yp.net.bean.BaseBean
import com.yp.net.bean.BaseDataState
import com.yp.net.bean.ExtData
import com.yp.net.common.NetRetCode
import org.json.JSONException
import retrofit2.Call
import retrofit2.awaitResponse
import java.net.SocketTimeoutException


/**
 * @author : yanpu
 * @date : 2021/6/2
 * @description:
 */
open class BaseManager {

    fun <T> getService(cls: Class<T>): T {
        return RetrofitInstance.instance.getRetrofit().create(cls)
    }

    suspend fun <T : BaseBean> request(
        block: Call<T>

    ): ExtData<T, BaseBean> {

        val baseBean = BaseBean()
        return try {
            baseBean.dataState = BaseDataState.STATE_LOADING
            val response = block.awaitResponse()
            val bean = response.body()
            baseBean.code = bean?.code ?: NetRetCode.FAIL
            baseBean.message = bean?.message
            when (response.isSuccessful && null != bean && response.body()?.errorCode == 0) {
                true -> ExtData.Left(response.body() as T)
                false -> ExtData.Right(baseBean)
            }

        } catch (t: Throwable) {
            baseBean.dataState = BaseDataState.STATE_ERROR
            baseBean.message = t.message
            baseBean.code = when (t) {
                is JSONException -> NetRetCode.FAIL_JSON_EXCEPTION
                is JsonSyntaxException -> NetRetCode.FAIL_JSON_SYNTAX
                is IllegalArgumentException -> NetRetCode.FAIL_ILLEGAL_ARGUMENT
                is SocketTimeoutException -> NetRetCode.FAIL_SOCKET_TIMEOUT
                else -> NetRetCode.FAIL_UNKNOWN
            }
            ExtData.Right(baseBean)
        }
    }
}