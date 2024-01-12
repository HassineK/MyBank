package com.vpexit.mybank.kmm.android.ui.navigation

import android.net.Uri
import com.google.gson.Gson
import com.vpexit.mybank.kmm.data.model.banks.Account

sealed class Screens(val route: String) {
    data object MyAccounts : Screens(route = "my_accounts_route")
    data object Simulation : Screens(route = "simulation_route")
    data object Others : Screens(route = "others_route")

    data object AccountDetails : Screens(route = "my_accounts_route") {
        const val key = "ACCOUNT"

        val routeWithKey: String
            get() = "$route/{$key}"

        fun addValue(account: Account): String {
            val value = Uri.encode(Gson().toJson(account))
            return "$route/$value"
        }
    }
}