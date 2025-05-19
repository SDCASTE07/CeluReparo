package com.example.celureparoapp.Navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.celureparoapp.screens.NextScreen // Asegúrate de importar tus pantallas
import com.example.celureparoapp.screens.UserTypeScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "user_type_screen"
    ) {
        composable("user_type_screen") {
            UserTypeScreen(navController)
        }
        composable("next_screen") {
            NextScreen(navController)
        }
    }
}