package com.molang.talk.ui.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext



abstract class BaseFragment<V: ViewDataBinding>: Fragment(), CoroutineScope {

    protected var job: Job = Job()

    // 기본 Main Thread 정의와 job을 함께 초기화
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    abstract fun getLayoutId(): Int
    abstract fun initView()

    protected lateinit var binding: V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancelChildren()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initView()
    }
}