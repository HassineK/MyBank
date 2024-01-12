package com.vpexit.mybank.kmm.android.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.vpexit.mybank.kmm.android.ui.accounts.MyAccountsScreen
import com.vpexit.mybank.kmm.android.ui.accounts.details.AccountDetailsScreen
import com.vpexit.mybank.kmm.android.ui.others.OthersScreen
import com.vpexit.mybank.kmm.android.ui.simulation.SimulationScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screens.MyAccounts.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = Screens.MyAccounts.route) {
            MyAccountsScreen(
                navController = navController
            )
        }
        composable(
            route = Screens.AccountDetails.routeWithKey,
            arguments = listOf(navArgument(Screens.AccountDetails.key) {
                type = AccountArgType()
            })
        ) { navBackStackEntry ->
            val json = navBackStackEntry.arguments?.getString(Screens.AccountDetails.key)
            val account = json?.let { AccountArgType().fromJsonParse(it) }
            AccountDetailsScreen(
                navController = navController,
                account = account
            )
        }
        composable(route = Screens.Simulation.route) {
            SimulationScreen()
        }
        composable(route = Screens.Others.route) {
            OthersScreen()
        }
    }
}
