package com.diagnal.programming.module

import com.diagnal.programming.MainViewModel
import com.diagnal.programming.utils.Utils
import org.koin.dsl.module

var appModule = module {
    single { Utils() }
    factory { MainViewModel(get()) }
}

