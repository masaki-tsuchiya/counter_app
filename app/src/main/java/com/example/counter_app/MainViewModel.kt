package com.example.counter_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository = MainRepository(),
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            mainRepository.counter.collect { counter ->
                _uiState.update {
                    it.copy(
                        counter = counter,
                    )
                }
            }
        }
    }

    fun updateCounter() {
        mainRepository.updateCounter(
            counter = 1,
        )
    }
}
