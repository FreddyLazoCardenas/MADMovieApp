package com.freddy.movieapi.presentation.navigation

object MovieDestinations {
    const val POPULAR_MOVIES = "popular_movies"
    const val MOVIE_DETAIL = "movie_detail"
}

sealed class MovieRoute(val route: String) {
    data object PopularMovies : MovieRoute(MovieDestinations.POPULAR_MOVIES)
    data object MovieDetail : MovieRoute("${MovieDestinations.MOVIE_DETAIL}/{movieId}") {
        fun createRoute(movieId: Int) = "${MovieDestinations.MOVIE_DETAIL}/$movieId"
    }
}