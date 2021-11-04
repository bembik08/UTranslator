package com.professional.schedulers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class SchedulersImpl : Schedulers {
    override fun io(): CoroutineDispatcher = Dispatchers.IO

    override fun main(): CoroutineDispatcher = Dispatchers.Main
}