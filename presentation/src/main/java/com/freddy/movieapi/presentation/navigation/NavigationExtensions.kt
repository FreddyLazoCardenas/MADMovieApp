package com.freddy.movieapi.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder

fun NavController.navigateToMovieDetail(
    movieId: Int,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(MovieRoute.MovieDetail.createRoute(movieId)) {
        builder()
    }
}

fun NavController.navigateToPopularMovies(
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(MovieRoute.PopularMovies.route) {
        builder()
    }
}

fun NavController.popBackStackSafely(): Boolean {
    return if (previousBackStackEntry != null) {
        popBackStack()
    } else {
        false
    }
}