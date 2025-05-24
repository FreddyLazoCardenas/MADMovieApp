package com.freddy.movieapi.data.repository

import com.freddy.movieapi.data.mapper.toDomain
import com.freddy.movieapi.data.remote.MovieApiService
import com.freddy.movieapi.domain.model.MovieDomain
import com.freddy.movieapi.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: MovieApiService
) : MovieRepository {

    override suspend fun getPopularMovies(): Result<List<MovieDomain>> {
        return try {
            val response = apiService.getPopularMovies()
            val movies = response.results.map { it.toDomain() }
            Result.success(movies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTopRatedMovies(): Result<List<MovieDomain>> {
        return try {
            val response = apiService.getTopRatedMovies()
            val movies = response.results.map { it.toDomain() }
            Result.success(movies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getMovieDetail(movieId: Int): Result<MovieDomain> {
        return try {
            val response = apiService.getMovieDetail(movieId)
            val movie = response.toDomain()
            Result.success(movie)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
