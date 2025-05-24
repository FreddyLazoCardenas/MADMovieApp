package com.freddy.movieapi.domain.usecase

import com.freddy.movieapi.domain.model.MovieDomain
import com.freddy.movieapi.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): Result<MovieDomain> {
        return repository.getMovieDetail(movieId)
    }
}