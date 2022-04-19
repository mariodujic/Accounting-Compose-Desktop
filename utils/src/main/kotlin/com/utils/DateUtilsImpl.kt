package com.utils

import java.util.*

class DateUtilsImpl : DateUtils {

    override fun getCurrentTime(): Long {
        return Date().time
    }
}