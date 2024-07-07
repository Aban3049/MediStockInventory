package com.pandaapps.medicalstoremangementsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pandaapps.medicalstoremangementsystem.Navigation.Navigation
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelSignupScreen
import com.pandaapps.medicalstoremangementsystem.ui.theme.MedicalStoreMangementSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val viewModel: ViewModelSignupScreen by viewModels()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MedicalStoreMangementSystemTheme {


                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    Box(modifier = Modifier.padding(innerPadding)) {

                        Navigation(viewModel = viewModel)
                    }

                }


            }


        }
    }


}



