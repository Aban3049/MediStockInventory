package com.pandaapps.medicalstoremangementsystem.Navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pandaapps.medicalstoremangementsystem.DataStore.UserPreferencesKeys
import com.pandaapps.medicalstoremangementsystem.DataStore.dataStore
import com.pandaapps.medicalstoremangementsystem.Screens.Dashboard.Dashboard
import com.pandaapps.medicalstoremangementsystem.Screens.LogIn.LogIn
import com.pandaapps.medicalstoremangementsystem.Screens.OrderPlace.PlaceOrder
import com.pandaapps.medicalstoremangementsystem.Screens.SignUp.SignUp
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

@Composable
fun Navigation(viewModel: ViewModel) {

    val navController = rememberNavController()

   val startDestination =  if (areCredentialsStored(LocalContext.current)){
      NavScreens.HomeHolder
    }else{
        NavScreens.LoginPageHolder
   }
    NavHost(navController = navController, startDestination = startDestination) {

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

fun areCredentialsStored(context: Context): Boolean {
    val dataStore = context.dataStore
    return runBlocking {
        val prefs = dataStore.data.first()
        val username = prefs[UserPreferencesKeys.USER_EMAIL]
        val password = prefs[UserPreferencesKeys.USER_PASSWORD]
        !username.isNullOrEmpty() && !password.isNullOrEmpty()
    }
}

