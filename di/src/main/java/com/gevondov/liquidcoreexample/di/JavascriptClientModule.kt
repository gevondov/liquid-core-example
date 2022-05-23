package com.gevondov.liquidcoreexample.di

import com.gevondov.liquidcoreexample.javascript.client.JavascriptClient
import com.gevondov.liquidcoreexample.javascript.client.JavascriptClientImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.liquidplayer.javascript.JSContext

object JavascriptClientModule {

    fun createModule() = module {

        single {
            JSContext()
        }

        factory<JavascriptClient> {
            JavascriptClientImpl(
                jsContext = get(),
                context = androidContext()
            )
        }
    }
}