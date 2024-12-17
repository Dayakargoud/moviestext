package com.app.moviesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.moviesapp.presentation.ui.details.DetailsScreen
import com.app.moviesapp.presentation.ui.home.MoviesContent
import com.app.moviesapp.presentation.ui.home.MoviesViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
                  viewModel: MoviesViewModel

) {


    NavHost(navController, startDestination = Destinations.home){

        composable(route = Destinations.home) {
            MoviesContent(modifier = modifier, viewModel = viewModel){
                navController.navigate(Destinations.deatils)
            }
        }
        composable(route = Destinations.deatils) {

            DetailsScreen(modifier = modifier, viewModel = viewModel)
        }
    }


}