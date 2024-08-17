package com.pandaapps.medicalstoremangementsystem.Screens.SignUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.pandaapps.medicalstoremangementsystem.Navigation.Routes
import com.pandaapps.medicalstoremangementsystem.R
import com.pandaapps.medicalstoremangementsystem.Screens.DialogBoxWithProgressIndicator
import com.pandaapps.medicalstoremangementsystem.Screens.DialogWithImage
import com.pandaapps.medicalstoremangementsystem.States.State
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelApp



@Composable
fun SignUp(viewModelApp: ViewModelApp, navHostController: NavHostController) {


    when (viewModelApp.state.value) {

        State.Default.stateType -> {
            SignUpScreen(viewModelApp = viewModelApp, navController = navHostController)

        }

        State.LOADING.stateType -> {


            SignUpScreen(viewModelApp = viewModelApp, navController = navHostController)



            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DialogBoxWithProgressIndicator(text = "Creating Account")
            }


        }

        State.FAILED.stateType -> {


            SignUpScreen(viewModelApp = viewModelApp, navController = navHostController)



            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DialogWithImage(
                    onDismissRequest = { viewModelApp.failedOrSuccessSetToDefault() },
                    onConfirmation = { viewModelApp.state.value = State.Default.stateType },
                    painter = painterResource(id = R.drawable.angry),
                    imageDescription = "angryEmoji",
                    "Failed to Create Account",
                )
            }


        }

        State.SUCESS.stateType -> {
            navHostController.navigate(Routes.HomeHolder)

        }


    }


}








