package com.freddy.movieapi.data.remote

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Header("Authorization") apiKey: String,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Header("Authorization") apiKey: String,
        @Query("page") page: Int = 1
    ): MovieResponse
}
