package com.freddy.movieapi.domain.repository

import com.freddy.movieapi.domain.model.MovieDomain

interface MovieRepository {
    suspend fun getPopularMovies(): Result<List<MovieDomain>>
    suspend fun getTopRatedMovies(): Result<List<MovieDomain>>
}
