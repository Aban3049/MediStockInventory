package com.pandaapps.medicalstoremangementsystem.Screens.SignUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.pandaapps.medicalstoremangementsystem.Navigation.Routes
import com.pandaapps.medicalstoremangementsystem.Screens.DialogBoxWithProgressIndicator
import com.pandaapps.medicalstoremangementsystem.States.State
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelApp

@Composable
fun SignUp(viewModelApp: ViewModelApp, navController: NavHostController) {
    val state by viewModelApp.state.collectAsState()

    when (state) {
        State.Default.stateType -> {
            SignUpScreen(viewModelApp, navController)
        }

        State.LOADING.stateType -> {
            SignUpScreen(viewModelApp, navController)
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DialogBoxWithProgressIndicator(text = "Creating Account")
            }

        }

        State.FAILED.stateType -> {
            SignUpScreen(viewModelApp, navController)

        }

        State.SUCESS.stateType -> {
            LaunchedEffect(Unit) {
                navController.navigate(Routes.HomeHolder) {
                    popUpTo(Routes.SignUpHolder) { inclusive = true }
                }
            }
        }
    }
}










