package dev.yahyrparedes.metaltools

import android.app.Application

import android.content.Context

lateinit var appContext: Context

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}
