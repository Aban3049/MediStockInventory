package com.pandaapps.medicalstoremangementsystem.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pandaapps.medicalstoremangementsystem.DataStore.getUserCredentials
import com.pandaapps.medicalstoremangementsystem.DataStore.saveUserCredentials
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val _userCredentials = MutableStateFlow<Pair<String?, String?>>(Pair(null, null))
    val userCredentials: StateFlow<Pair<String?, String?>> = _userCredentials

    val viewModel = ViewModel()

    init {
        viewModelScope.launch {
            getApplication<Application>().getUserCredentials().collect { credentials ->
                _userCredentials.value = credentials
                viewModel.logInUser(credentials.first.toString(), credentials.second.toString())
            }
        }
    }

    fun saveUserCredentials(userEmail: String, password: String) {
        viewModelScope.launch {
            getApplication<Application>().saveUserCredentials(userEmail, password)
        }
    }
}
