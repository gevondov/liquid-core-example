package com.gevondov.liquidcoreexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gevondov.liquidcoreexample.javascript.client.JavascriptClient
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val jsClient by inject<JavascriptClient>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jsClient.readFile("main.js")
        jsClient.callFunction("onCreate")
    }

    override fun onStart() {
        super.onStart()
        jsClient.callFunction("onStart")
    }

    override fun onResume() {
        super.onResume()
        jsClient.callFunction("onResume")
    }

    override fun onPause() {
        super.onPause()
        jsClient.callFunction("onPause")
    }

    override fun onStop() {
        super.onStop()
        jsClient.callFunction("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        jsClient.callFunction("onDestroy")
    }

    companion object {
        private const val TAG = "MainActivityLogTag"
    }
}