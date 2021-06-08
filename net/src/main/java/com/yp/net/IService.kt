package com.yp.net

import retrofit2.Call
import retrofit2.http.*

/**
 * @author : yanpu
 * @date : 2021/4/29
 * @description:
 */
interface IService {

    @GET
    suspend fun get(@Url url: String, @QueryMap map: Map<String, Any>): Call<String>

    @FormUrlEncoded
    @POST
    suspend fun post(@Url url: String, @FieldMap map: Map<String, Any>): Call<String>
}