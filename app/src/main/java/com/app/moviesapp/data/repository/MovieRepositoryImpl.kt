package com.app.moviesapp.data.repository

import com.app.moviesapp.data.mappers.asDomain
import com.app.moviesapp.data.remote.service.MovieApiService
import com.app.moviesapp.domain.model.Movie
import com.app.moviesapp.domain.model.MovieDetails
import com.app.moviesapp.domain.model.MoviesList
import com.app.moviesapp.domain.model.Result
import com.app.moviesapp.domain.repository.MoviesRepository

class MovieRepositoryImpl(private val apiService: MovieApiService): MoviesRepository {
    override suspend fun getMovies(searchQuery: String, page:Int): Result<List<Movie>> {
        val movieResponse =  apiService.getMovies(searchQuery,page)

        return if (movieResponse.isSuccessful && movieResponse.body() != null){
            Result.Success(movieResponse.body()!!.asDomain())
        }else{

            Result.Error("Unable to Search")
        }

    }

    override suspend fun getMovieDetails(id: String): Result<MovieDetails> {
        val movieDetailsResponse =  apiService.getMovieDetails(id)
        return if (movieDetailsResponse.isSuccessful && movieDetailsResponse.body() != null){
            val movieDetails = movieDetailsResponse.body()!!.asDomain()
            Result.Success(movieDetails)
        }else{
            Result.Error("Unable to Search")
        }


    }

}