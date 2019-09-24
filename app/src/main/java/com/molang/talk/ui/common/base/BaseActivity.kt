package com.molang.talk.ui.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

/**
 *
 *   Created by mickey on 31/08/2019.
 **/

abstract class BaseActivity<V: ViewDataBinding>: AppCompatActivity(), CoroutineScope {

    protected var job: Job = Job()

    // 기본 Main Thread 정의와 job을 함께 초기화
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    abstract fun getLayoutId(): Int

    protected lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancelChildren()
    }
}