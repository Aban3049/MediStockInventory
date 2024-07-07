package com.pandaapps.medicalstoremangementsystem.Screens.SignUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.pandaapps.medicalstoremangementsystem.Screens.DialogBoxWithProgressIndicator
import com.pandaapps.medicalstoremangementsystem.Screens.DialogWithImage
import com.pandaapps.medicalstoremangementsystem.Navigation.NavScreens
import com.pandaapps.medicalstoremangementsystem.R
import com.pandaapps.medicalstoremangementsystem.States.State
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelSignupScreen


@Composable
fun SignUp(viewModel: ViewModelSignupScreen, navController: NavHostController) {


    when (viewModel.state.value) {

        State.Default.stateType -> {
            SignUpScreen(viewModel = viewModel, navController = navController)

        }

        State.LOADING.stateType -> {


            SignUpScreen(viewModel = viewModel, navController = navController)



            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DialogBoxWithProgressIndicator(text = "Creating Account")
            }


        }

        State.FAILED.stateType -> {


            SignUpScreen(viewModel = viewModel, navController = navController)



            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DialogWithImage(
                    onDismissRequest = { viewModel.failedSetToDefault() },
                    onConfirmation = { viewModel.state.value = State.Default.stateType },
                    painter = painterResource(id = R.drawable.angry),
                    imageDescription = "angryEmoji"
                )
            }


        }

        State.SUCESS.stateType -> {
            navController.navigate(NavScreens.HomeHolder)

        }


    }


}


