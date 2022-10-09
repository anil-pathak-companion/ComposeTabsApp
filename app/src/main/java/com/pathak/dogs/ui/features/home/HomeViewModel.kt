package com.pathak.dogs.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pathak.dogs.data.base.Result
import com.pathak.dogs.data.base.ScreenState
import com.pathak.dogs.domain.GetBreedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getBreedsUseCase: GetBreedsUseCase) :
    ViewModel() {

    private val _viewModelState = MutableStateFlow(HomeScreenState.Empty)
    val uiState = _viewModelState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        HomeScreenState.Empty
    )

    init {
        viewModelScope.launch {
            when (val result = getBreedsUseCase()) {
                is Result.Success -> {
                    _viewModelState.update {
                        it.copy(
                            screenState = ScreenState.Success,
                            breeds = result.data,
                            error = null
                        )
                    }
                }
                is Result.Error -> {
                    _viewModelState.update {
                        it.copy(
                            screenState = ScreenState.Error,
                            breeds = null,
                            error = result.exception.localizedMessage
                        )
                    }
                }
            }
        }
    }
}