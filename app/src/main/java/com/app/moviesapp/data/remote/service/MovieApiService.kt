package com.app.moviesapp.data.remote.service

import com.app.moviesapp.data.remote.model.response.MovieDetailsResponse
import com.app.moviesapp.data.remote.model.response.MoviesListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    companion object {
        const val BASE_URL = "http://www.omdbapi.com"
        const val API_KEY = "a499aa15"
    }


    @GET("/")
    suspend fun getMovies(@Query("s") searchQuery:String,
                          @Query("page") page:Int,
                          @Query("apikey") apiKey:String = API_KEY
    ):Response<MoviesListResponse>


    @GET("/")
    suspend fun getMovieDetails(@Query("i") imdbId:String,
                                @Query("apikey") apiKey:String = API_KEY
    ):Response<MovieDetailsResponse>


}