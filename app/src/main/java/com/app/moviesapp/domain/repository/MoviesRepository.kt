package com.app.moviesapp.domain.repository

import com.app.moviesapp.domain.model.Movie
import com.app.moviesapp.domain.model.MovieDetails
import com.app.moviesapp.domain.model.MoviesList
import com.app.moviesapp.domain.model.Result

interface MoviesRepository {

    suspend fun getMovies(searchQuery:String, page:Int):Result<List<Movie>>

    suspend fun getMovieDetails(id:String):Result<MovieDetails>
}