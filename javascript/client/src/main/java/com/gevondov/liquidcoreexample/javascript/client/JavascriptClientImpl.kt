package com.gevondov.liquidcoreexample.javascript.client

import android.content.Context
import org.liquidplayer.javascript.JSContext
import java.io.File

class JavascriptClientImpl(
    private val jsContext: JSContext,
    private val context: Context
) : JavascriptClient {

    override fun readFile(fileName: String) {
        val file = File(context.filesDir, fileName)
        val content = file.readText()
        jsContext.evaluateScript(content)
    }

    override fun callFunction(name: String) {
        val liquidCoreExample = jsContext.property("liquidCoreExample").toObject()
        val liquidCoreExampleClient = liquidCoreExample.property("client").toObject()
        val function = liquidCoreExampleClient.property(name).toFunction()
        function.call()
    }
}