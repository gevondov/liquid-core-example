package com.gevondov.liquidcoreexample.di

import com.gevondov.liquidcoreexample.javascript.sdk.JavascriptLogger
import org.koin.dsl.module

object JavascriptSdkModule {

    fun createModule() = module {

        single {
            JavascriptLogger(
                jsContext = get(),
                logger = get()
            )
        }
    }
}