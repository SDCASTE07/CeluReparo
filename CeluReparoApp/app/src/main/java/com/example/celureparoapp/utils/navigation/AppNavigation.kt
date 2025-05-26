package com.example.celureparoapp.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.celureparoapp.screens.CelularesListScreen
import com.example.celureparoapp.Screens.CelularDetailScreen
import com.example.celureparoapp.screens.VentasListScreen
import com.example.celureparoapp.screens.RepuestosListScreen
import com.example.celureparoapp.ViewModel.CelularesViewModel
import com.example.celureparoapp.ViewModel.CelularDetailViewModel
import com.example.celureparoapp.viewmodels.VentasViewModel
import com.example.celureparoapp.viewmodels.RepuestosViewModel

object Routes {
    // Rutas principales con documentación
    const val CELULARES_LIST = "celulares"
    const val CELULAR_DETAIL = "celulares/{id}"
    const val VENTAS_LIST = "ventas"
    const val REPUESTOS_LIST = "repuestos"

    /**
     * Genera la ruta para el detalle de un celular
     * @param id ID del celular
     */
    fun celularDetail(id: Int): String = "celulares/$id"
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String = Routes.CELULARES_LIST
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Lista de Celulares
        composable(Routes.CELULARES_LIST) {
            val viewModel: CelularesViewModel = hiltViewModel()
            CelularesListScreen(
                onItemClick = { id ->
                    navController.navigate(Routes.celularDetail(id))
                },
                onNavigateToVentas = {
                    navController.navigate(Routes.VENTAS_LIST)
                },
                onNavigateToRepuestos = {
                    navController.navigate(Routes.REPUESTOS_LIST)
                },
                viewModel = viewModel
            )
        }

        // Detalle de Celular
        composable(
            route = Routes.CELULAR_DETAIL,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) { backStackEntry ->
            val viewModel: CelularDetailViewModel = hiltViewModel()
            val celularId = backStackEntry.arguments?.getInt("id") ?: 0

            CelularDetailScreen(
                celularId = celularId,
                onBack = { navController.popBackStack() },
                onEditSuccess = { navController.popBackStack() },
                viewModel = viewModel
            )
        }

        // Lista de Ventas
        composable(Routes.VENTAS_LIST) {
            val viewModel: VentasViewModel = hiltViewModel()
            VentasListScreen(
                onBack = { navController.popBackStack() },
                viewModel = viewModel
            )
        }

        // Lista de Repuestos
        composable(Routes.REPUESTOS_LIST) {
            val viewModel: RepuestosViewModel = hiltViewModel()
            RepuestosListScreen(
                onBack = { navController.popBackStack() },
                viewModel = viewModel
            )
        }
    }
}