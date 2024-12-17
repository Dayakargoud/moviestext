package com.app.moviesapp.di

import com.app.moviesapp.data.remote.service.MovieApiService
import com.app.moviesapp.data.repository.MovieRepositoryImpl
import com.app.moviesapp.domain.repository.MoviesRepository
import com.app.moviesapp.domain.useCases.GetMovieDetailsUseCase
import com.app.moviesapp.domain.useCases.GetMovieListUseCase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {


    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(MovieApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit):MovieApiService{
        return retrofit.create(MovieApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: MovieApiService):MoviesRepository{
        return MovieRepositoryImpl(apiService)
    }


    @Provides
    fun provideGetMoviesListUseCase(moviesRepository: MoviesRepository):GetMovieListUseCase{
        return GetMovieListUseCase(moviesRepository)
    }

    @Provides
    fun provideGetMoviesDetailstUseCase(moviesRepository: MoviesRepository):GetMovieDetailsUseCase{
        return GetMovieDetailsUseCase(moviesRepository)
    }

}