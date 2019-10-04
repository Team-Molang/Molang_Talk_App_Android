package com.molang.talk

import android.annotation.SuppressLint
import android.app.Application
import android.os.Build
import android.webkit.WebView
import com.facebook.stetho.Stetho
import org.koin.android.ext.android.startKoin

class MolangApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(
            this,
            listOf(
                AppModules.viewModelModule,
                AppModules.repositoryModule,
                AppModules.networkModules
            )
        )
        Stetho.initializeWithDefaults(this)
        WebView.setWebContentsDebuggingEnabled(true)
    }
}