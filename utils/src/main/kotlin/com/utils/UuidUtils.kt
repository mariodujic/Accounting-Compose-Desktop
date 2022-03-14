package com.utils

import java.util.*

class UuidUtils {

    fun getUuid(): String {
        return UUID.randomUUID().toString()
    }
}