package com.molang.talk

import android.annotation.SuppressLint
import android.app.Application
import android.os.Build
import android.webkit.WebView
import org.koin.android.ext.android.startKoin

class MolangApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this,
            listOf(
                AppModules.viewModelModule,
                AppModules.repositoryModule
            )
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
    }
}