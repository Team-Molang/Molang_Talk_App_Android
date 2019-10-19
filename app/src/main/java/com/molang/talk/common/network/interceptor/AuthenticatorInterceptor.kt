package com.molang.talk.common.network.interceptor

import com.molang.talk.common.util.PreferencesManager
import com.molang.talk.common.util.UserManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticatorInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        UserManager.UDID()?.let { udid ->
            val request = chain.request()
            val authenticatedRequest = request.newBuilder()
                .header("Authorization", udid).build()
            return chain.proceed(authenticatedRequest)
        }

        return chain.proceed(chain.request())
    }
}