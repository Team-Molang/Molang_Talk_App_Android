package com.molang.talk

import android.annotation.SuppressLint
import android.app.Application
import android.os.Build
import android.webkit.WebView
import com.facebook.stetho.Stetho
import com.molang.talk.common.util.UserData
import org.koin.android.ext.android.startKoin
import android.app.NotificationChannel
import android.content.Context.NOTIFICATION_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.app.NotificationManager
import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.molang.talk.common.constants.NotificationConstants


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
        setNotificationChannel()
    }

    private fun setNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channelMessage = NotificationChannel(
                NotificationConstants.CHANNEL_ID,
                NotificationConstants.CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = NotificationConstants.CHANNEL_DESCRIPTION
                enableLights(true)
                enableVibration(true)
                setShowBadge(false)
            }

            channel.createNotificationChannel(channelMessage)

        }
    }
}