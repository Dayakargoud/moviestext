package com.app.moviesapp.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.moviesapp.domain.model.Movie
import com.app.moviesapp.domain.model.MovieDetails
import com.app.moviesapp.domain.model.MoviesList
import com.app.moviesapp.domain.model.Result
import com.app.moviesapp.domain.useCases.GetMovieDetailsUseCase
import com.app.moviesapp.domain.useCases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesUseCase: GetMovieListUseCase,
    private val movieDetailsUseCase: GetMovieDetailsUseCase
)

    :ViewModel() {

   private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val  movies = _movies.asStateFlow()

    private val _movieDetails = MutableStateFlow<MovieDetails?>(null)
    val  movieDetails = _movieDetails.asStateFlow()

    private val selectedMovieId = MutableStateFlow<String?>(null)



    fun selectMovie(id:String){
        viewModelScope.launch {
            selectedMovieId.emit(id)
        }
    }
    fun getMovies(searchKey:String, page:Int= 1){
        viewModelScope.launch {
          val result =  moviesUseCase(searchKey, page )
              when(result){
                  is Result.Error -> {

                  }
                  Result.Loading -> {

                  }
                  is Result.Success -> {
                      _movies.emit(result.data)
                  }
              }


        }
    }

    fun getMovieDetails(){
        viewModelScope.launch {
            selectedMovieId.value.let {
                val result =  movieDetailsUseCase(it.orEmpty())
                when(result){
                    is Result.Error -> {

                    }
                    Result.Loading -> {

                    }
                    is Result.Success -> {
                        _movieDetails.emit(result.data)
                    }
                }
            }


        }
    }
}