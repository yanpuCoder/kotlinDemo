package com.yp.bridge.util

import androidx.lifecycle.AndroidViewModel
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * @author : yanpu
 * @date : 2021/6/4
 * @description:
 */
object ClassUtil {


    /**
     * 获取泛型ViewModel的class对象
     */
    fun <T> getViewModel(obj: Any): Class<T>? {
        val currentClass: Class<*> = obj.javaClass
        val tClass: Class<T>? =
            getGenericClass(
                currentClass,
                AndroidViewModel::class.java
            )
        return if (tClass == null || tClass == AndroidViewModel::class.java) {
            null
        } else tClass
    }


    private fun <T> getGenericClass(kClass: Class<*>, filterClass: Class<*>): Class<T>? {

        val type = kClass.genericSuperclass

        if (type == null || type !is ParameterizedType) return null

        val parameterizedType: ParameterizedType = type

        val types: Array<Type> = parameterizedType.actualTypeArguments
        for (t in types) {
            val tClass = t as Class<T>
            if (filterClass.isAssignableFrom(tClass)) {
                return tClass
            }
        }
        return null
    }

}