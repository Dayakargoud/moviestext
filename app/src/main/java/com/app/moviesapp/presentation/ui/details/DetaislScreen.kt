package com.app.moviesapp.presentation.ui.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.app.moviesapp.presentation.ui.home.MoviesViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsScreen(modifier: Modifier = Modifier,viewModel: MoviesViewModel) {

    val movieDetails by viewModel.movieDetails.collectAsState()


    LaunchedEffect(Unit) {
        viewModel.getMovieDetails()
    }

    Box(modifier = modifier.fillMaxSize()){

        Column {
            GlideImage(
                model = movieDetails?.Poster,
                contentScale = ContentScale.Crop,
                contentDescription = "Movie Poster", modifier = Modifier.size(200.dp)
            )

            Spacer(Modifier.height(8.dp))
            Column(Modifier.fillMaxWidth()) {
                Text(text = movieDetails?.Title.orEmpty())
                Text(text = movieDetails?.Year.orEmpty())
                Text(text = movieDetails?.Runtime.orEmpty())
            }
        }

    }
}