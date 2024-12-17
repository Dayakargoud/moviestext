package com.app.moviesapp.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<MovieResponse>,
    @SerializedName("totalResults")
    val totalResults: String
) {
    data class MovieResponse(
        @SerializedName("imdbID")
        val imdbID: String,
        @SerializedName("Poster")
        val poster: String,
        @SerializedName("Title")
        val title: String,
        @SerializedName("Type")
        val type: String,
        @SerializedName("Year")
        val year: String
    )
}