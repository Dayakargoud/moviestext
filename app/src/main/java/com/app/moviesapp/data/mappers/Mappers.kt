package com.app.moviesapp.data.mappers

import com.app.moviesapp.data.remote.model.response.MovieDetailsResponse
import com.app.moviesapp.data.remote.model.response.MoviesListResponse
import com.app.moviesapp.domain.model.Movie
import com.app.moviesapp.domain.model.MovieDetails


fun MoviesListResponse.asDomain(): List<Movie>{
    return this.search.map { it.asDomain() }
}

fun MoviesListResponse.MovieResponse.asDomain(): Movie{
    return Movie(
        imdbID = imdbID,
        poster=poster,
        title = title,
        type = type,
        year=year
    )
}

fun MovieDetailsResponse.asDomain():MovieDetails{
    return MovieDetails(
       Actors = actors,
        Awards = awards,
        Country = country,
        Director = director,
       Genre = genre,
        Language = language,
        Metascore = metascore,
        Plot = plot,
        Poster = poster,
        Rated = rated,
         Runtime =    runtime,
        Title = title,
       Type =  type,
       Writer =  writer,
       Year =  year,
        imdbID =imdbID,
        imdbRating = imdbRating,
        imdbVotes = imdbVotes,
        totalSeasons = totalSeasons,
        Released = released,
        Response = response,
        Ratings = this.ratings.map {
            MovieDetails.Rating(Source = it.source, Value = it.value)
        }


    )
}