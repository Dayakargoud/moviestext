package com.app.moviesapp.presentation.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import com.app.moviesapp.domain.model.Movie
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@Composable
fun MoviesContent(modifier: Modifier = Modifier, viewModel: MoviesViewModel, onItemClick: () -> Unit){

    var searchKey by remember { mutableStateOf("") }
    val movies by viewModel.movies.collectAsStateWithLifecycle()

  Box(modifier = modifier.fillMaxSize()) {


      LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {

          item {
              TextField(
                  modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                  value = searchKey,
                  singleLine = true,
                  placeholder = {
                      Text(text = "Search Movie")
                  },
                  onValueChange = {
                  searchKey = it
              },
                  trailingIcon = {
                      IconButton(onClick = {
                          if (searchKey.isNotEmpty()){

                              viewModel.getMovies(searchKey.trim())
                          }

                      }) {

                          Icon(Icons.Default.Search, contentDescription = "Search Movie")
                      }
                  }
                  )
          }

          items(movies){
              MovieRowItem(movie = it){
                  viewModel.selectMovie(it.imdbID)
                  onItemClick()
              }
          }

      }

  }

}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieRowItem(modifier: Modifier =Modifier, movie: Movie, onItemClick:()->Unit){


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
        .clickable {
        onItemClick()
    }) {

        GlideImage(model = movie.poster, contentDescription = "", modifier=Modifier.size(100.dp).padding(horizontal = 4.dp))


        Column() {
            Text(text = movie.title)
            Text(text = movie.year)
        }


    }
}