package com.example.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.presentation.models.OfferButtonUi
import com.example.presentation.models.OfferUi
import com.example.presentation.models.SalaryUi
import com.example.presentation.models.VacancyAddressUi
import com.example.presentation.models.VacancyExperienceUi
import com.example.presentation.models.VacancyUi
import com.example.presentation.navigation.BottomTabDestinations
import com.example.presentation.navigation.Screens
import com.example.presentation.screen.favorite.FavoriteScreenContent
import com.example.presentation.screen.main.MainScreenContent
import com.example.presentation.screen.StubScreen
import com.example.presentation.screen.favorite.FavoriteScreen
import com.example.presentation.screen.main.MainScreen
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography
import com.example.presentation.uikit.IconType

@Composable
fun EffectiveMobileTestTaskApp() {
    val navController = rememberNavController()
    var favoriteCount by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Colors.black,
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            var navigationSelectedItem by rememberSaveable {
                mutableStateOf(0)
            }
            val bottomTabDestinations = listOf(
                BottomBarItem(
                    destination = BottomTabDestinations.Search,
                    icon = R.drawable.icon_search,
                    label = stringResource(R.string.search_label)
                ),
                BottomBarItem(
                    destination = BottomTabDestinations.Favorite,
                    icon = R.drawable.icon_favorite,
                    label = stringResource(R.string.favorite)
                ),
                BottomBarItem(
                    destination = BottomTabDestinations.Responses,
                    icon = R.drawable.icon_responses,
                    label = stringResource(R.string.responses)
                ),
                BottomBarItem(
                    destination = BottomTabDestinations.Messages,
                    icon = R.drawable.icon_messages,
                    label = stringResource(R.string.messages)
                ),
                BottomBarItem(
                    destination = BottomTabDestinations.Profile,
                    icon = R.drawable.icon_profile,
                    label = stringResource(R.string.profile)
                )
            )

            LaunchedEffect(navBackStackEntry) {
                navBackStackEntry?.destination?.route?.let { destination ->
                    navigationSelectedItem =
                        bottomTabDestinations.indexOfFirst { it.destination::class.qualifiedName == destination }
                }
            }

            NavigationBar(
                containerColor = Colors.black,
            ) {
                bottomTabDestinations.forEachIndexed { index, bottomTabItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(bottomTabItem.destination) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = {
                            Text(text = bottomTabItem.label, style = Typography.tabText)
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (needToShowBubble(bottomTabItem, favoriteCount)) {
                                        Badge(
                                            modifier = Modifier.size(13.dp).offset(x = 3.dp, y = (-1).dp),
                                            containerColor = Colors.red,
                                            contentColor = Colors.white
                                        ) {
                                            Text("$favoriteCount", style = Typography.number)
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = bottomTabItem.icon),
                                    contentDescription = bottomTabItem.label
                                )
                            }
                        },
                        colors = NavigationBarItemColors(
                            selectedIconColor = Colors.blue,
                            selectedTextColor = Colors.blue,
                            selectedIndicatorColor = Color.Transparent,
                            unselectedIconColor = Colors.grey4,
                            unselectedTextColor = Colors.grey4,
                            disabledIconColor = Colors.grey4,
                            disabledTextColor = Colors.grey4
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
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
                            changeFavoriteCount = { newFavoriteCountValue ->
                                favoriteCount = newFavoriteCountValue
                            }
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
                            changeFavoriteCount = { newFavoriteCountValue ->
                                favoriteCount = newFavoriteCountValue
                            }
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
}

@Composable
private fun needToShowBubble(
    bottomTabItem: BottomBarItem,
    favoriteCount: Int
) = bottomTabItem.destination is BottomTabDestinations.Favorite && favoriteCount > 0

internal data class BottomBarItem(
    val destination: BottomTabDestinations,
    val icon: Int,
    val label: String
)

@Composable
private fun StubNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Stub) {
        composable<Screens.Stub> {
            StubScreen()
        }
    }
}