package com.app.moviesapp.domain.useCases

import com.app.moviesapp.domain.repository.MoviesRepository

class GetMovieListUseCase (private val moviesRepository: MoviesRepository){

    suspend operator fun invoke(searchQuery:String, page:Int,) = moviesRepository.getMovies(searchQuery = searchQuery, page=page)
}