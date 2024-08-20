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
import com.pandaapps.medicalstoremangementsystem.Screens.SignUp.SignUpScreen
import com.pandaapps.medicalstoremangementsystem.ViewModel.UserViewModel
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelApp
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

@Composable
fun Navigation(userViewModel: UserViewModel,viewModelApp: ViewModelApp) {

    val navController = rememberNavController()

   val startDestination =  if (areCredentialsStored(LocalContext.current)){
      Routes.HomeHolder
    }else{
        Routes.LoginPageHolder
   }
    NavHost(navController = navController, startDestination = startDestination) {

        composable<Routes.SignUpHolder> {
            SignUp(viewModelApp = viewModelApp,navController)
        }

        composable<Routes.LoginPageHolder> {
            LogIn(navController,viewModelApp,userViewModel)
        }

        composable<Routes.HomeHolder> {
            Dashboard(userViewModel,navController)
        }

        composable<Routes.PlaceOrder> {
            PlaceOrder(viewModelApp,userViewModel)
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

