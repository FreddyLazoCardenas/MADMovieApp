package com.freddy.movieapi.data.mapper

import com.freddy.movieapi.data.remote.MovieDto
import com.freddy.movieapi.domain.model.MovieDomain

fun MovieDto.toDomain(): MovieDomain {
    return MovieDomain(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage
    )
}
