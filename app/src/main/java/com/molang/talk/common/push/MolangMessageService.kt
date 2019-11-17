package com.molang.talk.common.push

import com.google.firebase.messaging.FirebaseMessagingService
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
}