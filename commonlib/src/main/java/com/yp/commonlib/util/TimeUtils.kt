package com.yp.commonlib.util

import com.yp.commonlib.log.Logger
import java.text.SimpleDateFormat
import java.util.*

/**
 * @date: 2021/4/22 21:13
 * @author: yp
 * @description: 时间转换
 */
object TimeUtils {

    const val ONE_SECOND: Long = 1000 // 一秒的毫秒值

    const val ONE_MINUTE = 60 * ONE_SECOND // 一分钟的毫秒值

    const val ONE_HOUR = 60 * ONE_MINUTE // 一小时的毫秒值

    const val ONE_DAY = 24 * ONE_HOUR // 一天的毫秒值

    const val ONE_MONTH = 30 * ONE_DAY // 一月的毫秒值

    const val ONE_YEAR = 12 * ONE_MONTH // 一年的毫秒值

    /**
     * 日期格式（yyyy-MM-dd）
     */
    const val DATE_TEMPLATE_DATE = "yyyy-MM-dd"

    /**
     * 日期格式（yyyy.MM.dd）
     */
    const val DATE_TEMPLATE_DATE_TWO = "yyyy.MM.dd"

    /**
     * 日期格式（yyyyMMdd）
     */
    const val DATE_TEMPLATE_DATE_THREE = "yyyyMMdd"

    /**
     * 日期格式（yyyy年MM月dd日）
     */
    const val DATE_TEMPLATE_DATE_FOUR = "yyyy年MM月dd日"

    /**
     * 日期格式（yyyy-MM-dd HH:mm:ss）
     */
    const val DATE_TEMPLATE_DATE_YMDHMS = "yyyy-MM-dd HH:mm:ss"

    const val DATE_TEMPLATE_DATE_M_Y = "MM月    yyyy年"

    /**
     * 日期格式（yyyy）
     */
    const val DATE_TEMPLATE_DATE_Y = "yyyy"

    /**
     * 日期格式（yyyy年MM月）
     */
    const val DATE_TEMPLATE_DATE_Y_M = "yyyy年MM月"

    /**
     * 日期格式（yyyy-MM）
     */
    const val DATE_TEMPLATE_DATE_Y_M_TWO = "yyyy-MM"

    /**
     * 日期格式（MM-dd）
     */
    const val DATE_TEMPLATE_DATE_M_D = "MM-dd"

    /**
     * 日期格式（MM月dd日）
     */
    const val DATE_TEMPLATE_DATE_M_D_TWO = "MM月dd日"

    /**
     * 日期格式（MM）
     */
    const val DATE_TEMPLATE_DATE_D = "dd"

    /**
     * @param template 时间格式
     */
    fun getCurrentDate(template: String?): String {
        val tem = if (template.isNullOrEmpty()) DATE_TEMPLATE_DATE else template
        try {
            val dateFormat = SimpleDateFormat(tem, Locale.CHINESE)
            return dateFormat.format(Date())
        } catch (e: Exception) {
            Logger.e(e.toString())
        }
        return "null"
    }

    /**
     * 获取当前日期时间戳
     * @param template 时间格式
     */
    fun getCurrentTimestamp(template: String?): Long {
        val tem = if (template.isNullOrEmpty()) DATE_TEMPLATE_DATE else template
        try {
            val dateFormat = SimpleDateFormat(tem, Locale.CHINESE)
            val date = dateFormat.parse(getCurrentDate(tem))
            return date?.time ?: 0
        } catch (e: Exception) {
            Logger.e(e.toString())
        }
        return 0
    }

    /**
     * 日期转时间戳
     * @param dateString 日期
     * @param template 时间格式
     */
    fun getTimestamp(dateString: String, template: String?): Long {
        val tem = if (template.isNullOrEmpty()) DATE_TEMPLATE_DATE else template
        try {
            val dateFormat = SimpleDateFormat(tem, Locale.CHINESE)
            val date = dateFormat.parse(dateString)
            return date?.time ?: 0
        } catch (e: Exception) {
            Logger.e(e.toString())
        }
        return 0
    }

    /**
     * 时间戳转日期
     * @param millisecond 时间戳
     * @param template 时间格式
     */
    fun getDate(millisecond: String?, template: String?): String {
        if (!millisecond.isNullOrEmpty()) {
            return getDate(millisecond.toLong(), template)
        }
        return ""
    }

    /**
     * 时间戳转日期
     * @param millisecond 时间戳
     * @param template 时间格式
     */
    fun getDate(millisecond: Long, template: String?): String {
        val tem = if (template.isNullOrEmpty()) DATE_TEMPLATE_DATE else template
        try {
            val date = SimpleDateFormat(tem, Locale.CHINESE)
            return date.format(Date(millisecond))
        } catch (e: Exception) {
            Logger.e(e.toString())
        }
        return ""
    }
}