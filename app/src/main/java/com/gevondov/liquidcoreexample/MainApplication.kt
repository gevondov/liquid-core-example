package com.gevondov.liquidcoreexample

import android.app.Application
import com.gevondov.liquidcoreexample.di.JavascriptClientModule
import com.gevondov.liquidcoreexample.di.JavascriptSdkModule
import com.gevondov.liquidcoreexample.di.LoggerModule
import com.gevondov.liquidcoreexample.javascript.sdk.JavascriptLogger
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                LoggerModule.createModule(),
                JavascriptClientModule.createModule(),
                JavascriptSdkModule.createModule()
            )
        }

        get<JavascriptLogger>().registerFunctions()
    }
}