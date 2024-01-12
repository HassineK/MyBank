package com.vpexit.mybank.kmm.android.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.vpexit.mybank.kmm.android.R

data class BottomNavigationItem(
    @StringRes val label: Int = -1,
    val icon: ImageVector = Icons.Filled.AttachMoney,
    val route: String = ""
) {
    fun bottomNavigationItems(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = R.string.my_accounts_label,
                icon = Icons.Filled.AttachMoney,
                route = Screens.MyAccounts.route
            ),
            BottomNavigationItem(
                label = R.string.simulation_label,
                icon = Icons.Filled.Star,
                route = Screens.Simulation.route
            ),
            BottomNavigationItem(
                label = R.string.others_label,
                icon = Icons.Filled.AccountCircle,
                route = Screens.Others.route
            ),
        )
    }
}