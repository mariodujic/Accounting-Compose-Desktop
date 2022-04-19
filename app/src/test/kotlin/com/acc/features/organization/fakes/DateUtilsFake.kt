package com.acc.features.organization.fakes

import com.utils.DateUtils

class DateUtilsFake: DateUtils {

    override fun getCurrentTime(): Long {
        return 101
    }
}