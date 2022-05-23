package com.gevondov.liquidcoreexample.javascript.sdk

import com.gevondov.liquidcoreexample.logger.Logger
import org.liquidplayer.javascript.JSContext
import org.liquidplayer.javascript.JSFunction
import org.liquidplayer.javascript.JSObject
import org.liquidplayer.javascript.JSValue
import java.text.DecimalFormat
import kotlin.math.log
import kotlin.reflect.jvm.javaMethod


class JavascriptLogger(
    private val jsContext: JSContext,
    private val logger: Logger
) {

    fun registerFunctions() {
        jsContext.property("liquidCoreExample", JSObject(jsContext))
        val liquidCoreExample = jsContext.property("liquidCoreExample").toObject()
        liquidCoreExample.property("client", JSObject(jsContext))
        liquidCoreExample.property("sdk", JSObject(jsContext))
        val liquidCoreExampleSdk = liquidCoreExample.property("sdk").toObject()
        liquidCoreExampleSdk.property("logger", JSObject(jsContext))

        val logFunction = object : JSFunction(jsContext, "log") {
            fun log(tag: String, message: String) {
                logger.log(tag, message)
            }
        }
        val liquidCoreExampleSdkLogger = liquidCoreExampleSdk.property("logger").toObject()
        liquidCoreExampleSdkLogger.property("log", logFunction)
    }

    companion object {
        private const val NAMESPACE = "liquidCoreExample.sdk"
    }
}