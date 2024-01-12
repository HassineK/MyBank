package com.vpexit.mybank.kmm.android.ui.navigation

import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.vpexit.mybank.kmm.android.theme.Bright_blue
import com.vpexit.mybank.kmm.android.theme.Gray
import com.vpexit.mybank.kmm.android.utils.Utils

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    CompositionLocalProvider(LocalRippleTheme provides Utils.NoRippleTheme) {
        NavigationBar(
            containerColor = Gray,
            tonalElevation = 10.dp
        ) {
            BottomNavigationItem().bottomNavigationItems()
                .forEachIndexed { _, navigationItem ->
                    NavigationBarItem(
                        selected = currentDestination?.route?.contains(navigationItem.route)
                            ?: false,
                        label = {
                            Text(stringResource(id = navigationItem.label))
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = stringResource(id = navigationItem.label)
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Bright_blue,
                            selectedTextColor = Bright_blue,
                            indicatorColor = Gray
                        ),
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
        }
    }
}