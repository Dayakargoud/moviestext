package com.app.moviesapp.data.remote.model.response


import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse(
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("Awards")
    val awards: String,
    @SerializedName("Country")
    val country: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Genre")
    val genre: String,
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("imdbRating")
    val imdbRating: String,
    @SerializedName("imdbVotes")
    val imdbVotes: String,
    @SerializedName("Language")
    val language: String,
    @SerializedName("Metascore")
    val metascore: String,
    @SerializedName("Plot")
    val plot: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Rated")
    val rated: String,
    @SerializedName("Ratings")
    val ratings: List<Rating>,
    @SerializedName("Released")
    val released: String,
    @SerializedName("Response")
    val response: String,
    @SerializedName("Runtime")
    val runtime: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("totalSeasons")
    val totalSeasons: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Writer")
    val writer: String,
    @SerializedName("Year")
    val year: String
) {
    data class Rating(
        @SerializedName("Source")
        val source: String,
        @SerializedName("Value")
        val value: String
    )
}