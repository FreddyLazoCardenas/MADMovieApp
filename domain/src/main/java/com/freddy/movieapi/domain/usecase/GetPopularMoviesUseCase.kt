package com.freddy.movieapi.domain.usecase

import com.freddy.movieapi.domain.model.MovieDomain
import com.freddy.movieapi.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(apiKey: String): Result<List<MovieDomain>> {
        return repository.getPopularMovies(apiKey)
    }
}
