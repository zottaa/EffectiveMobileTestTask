package com.example.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.screen.StubScreen
import com.example.presentation.screen.favorite.FavoriteScreen
import com.example.presentation.screen.main.MainScreen

@Composable
internal fun RootNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues,
    changeFavoriteCount: (Int) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = BottomTabDestinations.Search,
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        composable<BottomTabDestinations.Search> {
            val searchNavController = rememberNavController()
            NavHost(navController = searchNavController, startDestination = Screens.Main) {
                composable<Screens.Main> {
                    MainScreen(
                        changeFavoriteCount = changeFavoriteCount
                    ) {
                        searchNavController.navigate(Screens.Stub)
                    }
                }
                composable<Screens.Stub> {
                    StubScreen()
                }
            }
        }
        composable<BottomTabDestinations.Favorite> {
            val favoriteNavController = rememberNavController()
            NavHost(
                navController = favoriteNavController,
                startDestination = Screens.Favorite
            ) {
                composable<Screens.Favorite> {
                    FavoriteScreen(
                        changeFavoriteCount = changeFavoriteCount
                    ) {
                        favoriteNavController.navigate(Screens.Stub)
                    }
                }
                composable<Screens.Stub> {
                    StubScreen()
                }
            }
        }
        composable<BottomTabDestinations.Profile> {
            val profileNavController = rememberNavController()
            StubNavHost(navController = profileNavController)
        }
        composable<BottomTabDestinations.Messages> {
            val messagesNavController = rememberNavController()
            StubNavHost(navController = messagesNavController)
        }
        composable<BottomTabDestinations.Responses> {
            val responsesNavController = rememberNavController()
            StubNavHost(navController = responsesNavController)
        }
    }
}

@Composable
private fun StubNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Stub) {
        composable<Screens.Stub> {
            StubScreen()
        }
    }
}