package com.example.counter_app

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainRepository {

    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    fun updateCounter(counter: Int) {
        _counter.value += counter
    }
}
