package com.vpexit.mybank.kmm.android.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.vpexit.mybank.kmm.android.ui.navigation.BottomNavigationBar
import com.vpexit.mybank.kmm.android.ui.navigation.NavGraph


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        })
    { paddingValues ->
        NavGraph(
            navController = navController,
            paddingValues = paddingValues
        )
    }
}