package com.freddy.movieapi.data.repository

import com.freddy.movieapi.data.mapper.toDomain
import com.freddy.movieapi.data.remote.MovieApiService
import com.freddy.movieapi.domain.model.MovieDomain
import com.freddy.movieapi.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: MovieApiService
) : MovieRepository {

    override suspend fun getPopularMovies(apiKey: String): Result<List<MovieDomain>> {
        return try {
            val response = apiService.getPopularMovies(apiKey)
            val movies = response.results.map { it.toDomain() }
            Result.success(movies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTopRatedMovies(apiKey: String): Result<List<MovieDomain>> {
        return try {
            val response = apiService.getTopRatedMovies(apiKey)
            val movies = response.results.map { it.toDomain() }
            Result.success(movies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
