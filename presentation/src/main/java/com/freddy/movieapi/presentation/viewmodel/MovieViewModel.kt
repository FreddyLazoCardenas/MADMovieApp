package com.freddy.movieapi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freddy.movieapi.domain.model.MovieDomain
import com.freddy.movieapi.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MovieUiState>(MovieUiState.Loading)
    val uiState: StateFlow<MovieUiState> = _uiState.asStateFlow()

    fun getPopularMovies() {
        viewModelScope.launch {
            _uiState.value = MovieUiState.Loading
            getPopularMoviesUseCase().fold(
                onSuccess = { movies ->
                    _uiState.value = MovieUiState.Success(movies)
                },
                onFailure = { exception ->
                    _uiState.value = MovieUiState.Error(exception.message ?: "Unknown error")
                }
            )
        }
    }

    fun clearError() {
        _uiState.value = MovieUiState.Loading
    }
}

sealed class MovieUiState {
    data object Loading : MovieUiState()
    data class Success(val movies: List<MovieDomain>) : MovieUiState()
    data class Error(val errorMessage: String) : MovieUiState()
}
