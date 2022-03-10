package com.acc.utils

import java.util.*

class UuidUtils {

    fun getUuid(): String {
        return UUID.randomUUID().toString()
    }
}