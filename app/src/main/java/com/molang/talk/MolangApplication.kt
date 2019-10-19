package com.molang.talk

import android.annotation.SuppressLint
import android.app.Application
import android.os.Build
import android.webkit.WebView
import com.facebook.stetho.Stetho
import com.molang.talk.common.util.UserData
import org.koin.android.ext.android.startKoin

class MolangApplication : Application() {
    companion object {
        var INSTANCE: MolangApplication? = null
        var userData: UserData? = null
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

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