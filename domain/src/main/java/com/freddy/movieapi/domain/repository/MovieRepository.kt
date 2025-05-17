package com.freddy.movieapi.domain.repository

import com.freddy.movieapi.domain.model.MovieDomain

interface MovieRepository {
    suspend fun getPopularMovies(apiKey: String): Result<List<MovieDomain>>
    suspend fun getTopRatedMovies(apiKey: String): Result<List<MovieDomain>>
}
