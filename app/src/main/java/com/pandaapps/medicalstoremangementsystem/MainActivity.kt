package com.pandaapps.medicalstoremangementsystem

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pandaapps.medicalstoremangementsystem.Navigation.Navigation
import com.pandaapps.medicalstoremangementsystem.ViewModel.UserViewModel
import com.pandaapps.medicalstoremangementsystem.ViewModel.ViewModelApp
import com.pandaapps.medicalstoremangementsystem.ui.theme.MedicalStoreMangementSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MedicalStoreMangementSystemTheme {

                val viewModelApp: ViewModelApp =
                    viewModel(factory = MyViewModelFactory(application))

                val userViewModel: UserViewModel =
                    viewModel(factory = MyViewModelFactory2(application))

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    Box(modifier = Modifier.padding(innerPadding)) {

                        Navigation(viewModelApp = viewModelApp, userViewModel = userViewModel)
                    }

                }


            }


        }
    }


}

class MyViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val savedStateHandle = extras.createSavedStateHandle()
        if (modelClass.isAssignableFrom(ViewModelApp::class.java)) {
            return ViewModelApp(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class MyViewModelFactory2(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val savedStateHandle = extras.createSavedStateHandle()
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}