package com.pathak.dogs.ui.features.breedDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pathak.dogs.data.base.Result
import com.pathak.dogs.data.base.ScreenState
import com.pathak.dogs.domain.GetBreedsDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedDetailViewModel @Inject constructor(val getBreedsDetailsUseCase: GetBreedsDetailsUseCase) :
    ViewModel() {

    private val _viewModelState = MutableStateFlow(BreedDetailsScreenState.Empty)
    val uiState = _viewModelState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        BreedDetailsScreenState.Empty
    )

    fun getBreedDetails(breedId: String) {
        viewModelScope.launch {
            when (val result = getBreedsDetailsUseCase(breedId = breedId)) {
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
                            screenState = ScreenState.Success,
                            breeds = null,
                            error = result.exception.localizedMessage
                        )
                    }
                }
            }
        }
    }
}