package com.example.presentation.navigation

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
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
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.presentation.R
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography

@Composable
internal fun NavigationBottomBar(
    navController: NavHostController,
    favoriteCount: Int
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var navigationSelectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    val bottomTabDestinations = getBottomTabDestinations()

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
                    navigateToDestination(navController, bottomTabItem)
                },
                label = {
                    Text(text = bottomTabItem.label, style = Typography.tabText)
                },
                icon = {
                    BottomBarItemIcon(bottomTabItem, favoriteCount)
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

@Composable
private fun BottomBarItemIcon(
    bottomTabItem: BottomBarItem,
    favoriteCount: Int
) {
    BadgedBox(
        badge = {
            if (needToShowBubble(bottomTabItem, favoriteCount)) {
                Badge(
                    modifier = Modifier
                        .size(13.dp)
                        .offset(x = 3.dp, y = (-1).dp),
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
}

@Composable
private fun needToShowBubble(
    bottomTabItem: BottomBarItem,
    favoriteCount: Int
) = bottomTabItem.destination is BottomTabDestinations.Favorite && favoriteCount > 0

@Composable
private fun getBottomTabDestinations() = listOf(
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

private fun navigateToDestination(
    navController: NavHostController,
    bottomTabItem: BottomBarItem
) {
    navController.navigate(bottomTabItem.destination) {
        popUpTo(navController.graph.startDestinationId) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}