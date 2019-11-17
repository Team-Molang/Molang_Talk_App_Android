package com.molang.talk

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.molang.talk.common.RetrofitService
import com.molang.talk.common.constants.NetworkConstants
import com.molang.talk.common.network.interceptor.AuthenticatorInterceptor
import com.molang.talk.common.network.repository.*
import com.molang.talk.viewmodel.SplashViewModel
import com.molang.talk.viewmodel.HomeViewModel
import com.molang.talk.viewmodel.PointViewModel
import com.molang.talk.viewmodel.ProfileSettingViewModel
import com.molang.talk.viewmodel.SignUpViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppModules {
    companion object {
        val viewModelModule = module {
            viewModel { SignUpViewModel(
                userRepository = get()
            ) }
            viewModel { HomeViewModel(
                userRepository = get(),
                matchingRepository = get()
            ) }
            viewModel { ProfileSettingViewModel(
                fileRepository = get(),
                userRepository = get()
            ) }
            viewModel { PointViewModel(
                pointRepository = get()
            ) }
            viewModel {
                SplashViewModel(
                    appRepository = get()
                )
            }

        }

        val repositoryModule = module {
            factory { UserRepository(
                service = get()
            ) }

            factory { FileRepository(
                service = get()
            ) }

            factory { PointRepository(
                service = get()
            ) }

            factory { MatchingRepository(
                service = get()
            ) }

            factory { AppRepository(
                service = get()
            ) }
        }
        val networkModules = module {
            single {
                val loggingInterceptor = HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                }
                val client = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(AuthenticatorInterceptor())
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)

                if (BuildConfig.DEBUG) client.addNetworkInterceptor(StethoInterceptor())

                Retrofit.Builder()
                    .baseUrl(NetworkConstants.BASE_URL)
                    .client(client.build())
                    .addConverterFactory(
                        GsonConverterFactory.create(
                            GsonBuilder()
                                .setLenient()
                                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                                .create()
                        ))
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
                    .create(RetrofitService::class.java)
            }
        }
    }
}