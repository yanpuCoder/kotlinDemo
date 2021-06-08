package com.yp.net.common

/**
 * @author : yanpu
 * @date : 2021/5/21
 * @description:
 */
object NetRetCode {

    const val HTTP_401 = 401
    const val HTTP_200 = 200

    const val OPEN_SUSS = 0
    const val OPEN_ERR = 1

    const val THROWABLE_ERR = -1

    const val SUSS = 2000
    const val FAIL = 3100


    const val FAIL_NET_CONNECTION = -3100
    const val FAIL_JSON_EXCEPTION = -3200
    const val FAIL_JSON_SYNTAX = -3300
    const val FAIL_ILLEGAL_ARGUMENT = -3400
    const val FAIL_SOCKET_TIMEOUT = -3500
    const val FAIL_UNKNOWN = -3600


}