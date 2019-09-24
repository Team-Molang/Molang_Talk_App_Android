package com.molang.talk

import com.molang.talk.viewmodel.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class AppModules {
    companion object {
        val viewModelModule = module {
            viewModel { BaseViewModel() }
        }

        val repositoryModule = module {
            factory {  }
        }
    }
}