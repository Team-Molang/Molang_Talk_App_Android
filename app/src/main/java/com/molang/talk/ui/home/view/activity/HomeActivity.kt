package com.molang.talk.ui.home.view.activity

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.molang.talk.R
import com.molang.talk.common.extension.observe
import com.molang.talk.common.extension.to
import com.molang.talk.databinding.ActivityHomeBinding
import com.molang.talk.ui.common.base.BaseActivity
import com.molang.talk.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    private val viewModel: HomeViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initView() {
        viewModel.getUser { setFirebaseInstanceIdListener() }
    }

    override fun onSupportNavigateUp(): Boolean {
        return true
    }

    override fun setUp() {
        viewModel.run {
            observe(matchingStatus, Observer { result ->
                val navController = findNavController(R.id.nav_host_fragment)

                when (result) {
                    HomeViewModel.MatchingStatus.Find -> {
                        val isFindMatching = navController.currentDestination?.id == R.id.fragment_find_matching
                        if(!isFindMatching) navController to R.id.action_matching_to_find
                    }
                    HomeViewModel.MatchingStatus.Normal -> {
                        navController to R.id.fragment_matching
                        val isNormalMatching = navController.currentDestination?.id == R.id.fragment_matching
                        if(!isNormalMatching) navController to R.id.fragment_matching
                    }
                }
            })
        }
    }

    override fun initListener() {
        binding.run {
            bottomNavigation.setOnNavigationItemSelectedListener {
                val navController = findNavController(R.id.nav_host_fragment)
                when(it.itemId) {
                    R.id.fragment_matching -> {
                        if(viewModel.matchingStatus.value == HomeViewModel.MatchingStatus.Find) {
                            navController to R.id.fragment_find_matching
                        } else {
                            navController to R.id.fragment_matching
                        }
                    }
                    else -> {
                        navController to it.itemId
                    }
                }
                true
            }
        }
    }

    private fun setFirebaseInstanceIdListener() {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                task.result?.token?.let { token ->
                    viewModel.putPushKey(token)
                }
            })
    }
}