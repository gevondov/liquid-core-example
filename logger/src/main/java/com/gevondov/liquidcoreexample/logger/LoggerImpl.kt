package com.gevondov.liquidcoreexample.logger

import android.util.Log

class LoggerImpl : Logger {

    override fun log(tag: String, message: String) {
        Log.d(tag, message)
    }
}