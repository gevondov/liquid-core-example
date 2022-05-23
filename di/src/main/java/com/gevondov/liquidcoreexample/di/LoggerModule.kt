package com.gevondov.liquidcoreexample.di

import com.gevondov.liquidcoreexample.logger.Logger
import com.gevondov.liquidcoreexample.logger.LoggerImpl
import org.koin.dsl.module

object LoggerModule {

    fun createModule() = module {

        single<Logger> {
            LoggerImpl()
        }
    }
}