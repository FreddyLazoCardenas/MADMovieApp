package com.freddy.movieapi.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.freddy.movieapi.presentation.screens.MovieDetailScreen
import com.freddy.movieapi.presentation.screens.PopularMoviesScreen

@Composable
fun MovieNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MovieRoute.PopularMovies.route
    ) {
        composable(route = MovieRoute.PopularMovies.route) {
            PopularMoviesScreen(
                onMovieClick = { movieId ->
                    navController.navigateToMovieDetail(movieId)
                }
            )
        }
        
        composable(
            route = MovieRoute.MovieDetail.route,
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
            MovieDetailScreen(
                movieId = movieId,
                onBackClick = {
                    navController.popBackStackSafely()
                }
            )
        }
    }
}