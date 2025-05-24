package com.freddy.movieapi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freddy.movieapi.domain.model.MovieDomain
import com.freddy.movieapi.domain.usecase.GetMovieDetailUseCase
import com.freddy.movieapi.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MovieUiState>(MovieUiState.Loading)
    val uiState: StateFlow<MovieUiState> = _uiState.asStateFlow()

    private val _detailUiState = MutableStateFlow<MovieDetailUiState>(MovieDetailUiState.Loading)
    val detailUiState: StateFlow<MovieDetailUiState> = _detailUiState.asStateFlow()

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

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _detailUiState.value = MovieDetailUiState.Loading
            getMovieDetailUseCase(movieId).fold(
                onSuccess = { movie ->
                    _detailUiState.value = MovieDetailUiState.Success(movie)
                },
                onFailure = { exception ->
                    _detailUiState.value = MovieDetailUiState.Error(exception.message ?: "Unknown error")
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

sealed class MovieDetailUiState {
    data object Loading : MovieDetailUiState()
    data class Success(val movie: MovieDomain) : MovieDetailUiState()
    data class Error(val errorMessage: String) : MovieDetailUiState()
}
