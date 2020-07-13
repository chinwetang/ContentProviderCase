package com.example.myapplication

import android.app.Application
import android.content.Context
import android.util.Log

class App:Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.d("contentprovidercase",":App:attachBaseContext")
    }
    override fun onCreate() {
        super.onCreate()
        Log.d("contentprovidercase",":App:onCreate")
    }
}