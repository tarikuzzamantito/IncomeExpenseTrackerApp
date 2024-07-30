package com.tarikuzzamantito.apps.incomeexpensetrackerapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * Created by Tarikuzzaman Tito on 7/31/2024 12:31 AM
 */

@Composable
fun NavHostScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "/home") {
        composable(route = "/home") {
            HomeScreen(navController)
        }

        composable(route = "/add") {
            AddExpense(navController)
        }
    }
}