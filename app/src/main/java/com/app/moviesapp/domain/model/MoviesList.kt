package com.app.moviesapp.domain.model



data class MoviesList(
    val response: String,
    val search: List<Movie>,
    val totalResults: String)

data class Movie(
    val imdbID: String,
    val poster: String,
    val title: String,
    val type: String,
    val year: String
)