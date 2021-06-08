package com.yp.net

import com.google.gson.GsonBuilder
import com.yp.net.client.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.Serializable

/**
 * @author : yanpu
 * @date : 2021/4/29
 * @description:
 */
class RetrofitInstance : Serializable {

    companion object {
        // @JvmStatic通过@JvmStatic注解，使得在Java中调用instance直接是像调用静态函数一样，
        //类似RetrofitInstance.getInstance(),如果不加注解，在Java中必须这样调用: RetrofitInstance.Companion.getInstance().
        @JvmStatic
        //使用lazy属性代理，并指定LazyThreadSafetyMode为SYNCHRONIZED模式保证线程安全
        val instance: RetrofitInstance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { RetrofitInstance() }
    }

    // 防止单例对象在反序列化时重新生成对象
    private fun readResolve(): Any {
        return instance
    }

    private var retrofit: Retrofit? = null

    fun init(baseUrl: String, client: OkHttpClient) {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
//            .addConverterFactory(ScalarsConverterFactory.create())
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    fun getRetrofit(): Retrofit {
        return retrofit!!
    }
}