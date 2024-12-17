package com.app.moviesapp.domain.useCases

import com.app.moviesapp.domain.repository.MoviesRepository

class GetMovieDetailsUseCase (private val moviesRepository: MoviesRepository){

    suspend operator fun invoke(imdbId:String) = moviesRepository.getMovieDetails(id = imdbId)
}