package com.freddy.movieapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.freddy.movieapi.presentation.screens.PopularMoviesScreen
import com.freddy.movieapi.presentation.theme.MovieApiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Use your API key here
                    val apiKey = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1NzI1ODVjZmRlYzYyNzZkM2Y2OWI4ZDVhNzUzZDY5MSIsIm5iZiI6MTU3OTE1NTQ0MC40OTQwMDAyLCJzdWIiOiI1ZTFmZmZmMDAxMDJjOTAwMTYzYjhhOWIiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.MscjSs_sPx7OCo2iR1C8TDzsn7kOYUbQWMy1lFB3KSg"
                    PopularMoviesScreen(apiKey = apiKey)
                }
            }
        }
    }
}
