package com.salbanez.books.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.salbanez.books.presentation.DetailView
import com.salbanez.books.presentation.HomeView
import com.salbanez.books.util.toId
import com.salbanez.books.viewmodel.BooksViewModel

@Composable
fun NavManager(booksViewModel: BooksViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(booksViewModel, navController)
        }
        composable("DetailView/{title}", arguments = listOf(
            navArgument("title") {
                type = NavType.StringType
            }
        )){
            DetailView(
                navController = navController,
                title = it.toId(),
                booksViewModel = booksViewModel
            )
        }
    }
}
