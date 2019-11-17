package com.molang.talk.common.push

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.molang.talk.common.network.repository.AppRepository
import com.molang.talk.viewmodel.SplashViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.core.KoinContext
import org.koin.standalone.KoinComponent
import kotlin.coroutines.CoroutineContext
import android.content.Context.NOTIFICATION_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.app.NotificationManager
import android.R.id.message
import android.R
import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.molang.talk.common.constants.NotificationConstants



class MolangMessageService: FirebaseMessagingService(), CoroutineScope  {

    protected var job: Job = Job()

    // 기본 Main Thread 정의와 job을 함께 초기화
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    private val appRepository: AppRepository by inject()

    override fun onNewToken(pushKey: String) {
        super.onNewToken(pushKey)

        launch(coroutineContext) {
            appRepository.putPushKey(pushKey)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        val notificationBuilder = NotificationCompat.Builder(this, NotificationConstants.CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_btn_speak_now)
            .setContentTitle("몰랑톡")
            .setContentText("테스트메세지")
            .setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(1, notificationBuilder.build())
    }
}