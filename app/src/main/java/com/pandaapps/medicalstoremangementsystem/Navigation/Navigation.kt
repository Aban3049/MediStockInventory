package com.pandaapps.medicalstoremangementsystem.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pandaapps.medicalstoremangementsystem.Screens.Dashboard.Dashboard
import com.pandaapps.medicalstoremangementsystem.Screens.LogIn.LogIn
import com.pandaapps.medicalstoremangementsystem.Screens.OrderPlace.PlaceOrder
import com.pandaapps.medicalstoremangementsystem.Screens.SignUp.SignUp
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelSignupScreen

@Composable
fun Navigation(viewModel: ViewModelSignupScreen) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreens.SignUpHolder) {

        composable<NavScreens.SignUpHolder> {
            SignUp(viewModel = viewModel,navController)
        }

        composable<NavScreens.LoginPageHolder> {
            LogIn(navController,viewModel)
        }

        composable<NavScreens.HomeHolder> {
            Dashboard(navController)
        }

        composable<NavScreens.PlaceOrder> {
            PlaceOrder(viewModel)
        }



    }

}