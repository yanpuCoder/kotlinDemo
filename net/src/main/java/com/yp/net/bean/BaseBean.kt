package com.yp.net.bean

/**
 * @author : yanpu
 * @date : 2021/6/2
 * @description:
 */
open class BaseBean {

    var code: Int = -1
    var message: String? = null

    var errorCode: Int = -1
    var errorMsg: String? = null

    var dataState: BaseDataState? = null
}