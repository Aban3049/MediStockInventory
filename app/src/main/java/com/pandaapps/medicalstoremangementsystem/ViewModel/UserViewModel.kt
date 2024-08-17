package com.pandaapps.medicalstoremangementsystem.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.pandaapps.medicalstoremangementsystem.DataStore.getId
import com.pandaapps.medicalstoremangementsystem.DataStore.getUserCredentials
import com.pandaapps.medicalstoremangementsystem.DataStore.saveId
import com.pandaapps.medicalstoremangementsystem.DataStore.saveUserCredentials
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val _userCredentials = MutableStateFlow<Pair<String?, String?>>(Pair(null, null))
    val userCredentials: StateFlow<Pair<String?, String?>> = _userCredentials

    private val _userId = MutableStateFlow<Int>(0)
    val userId = _userId

    val viewModelApp = ViewModelApp(application)

    init {
        viewModelScope.launch {
            getApplication<Application>().getUserCredentials().collect { credentials ->
                _userCredentials.value = credentials
                viewModelApp.logInUser(credentials.first.toString(), credentials.second.toString())
            }
        }

        viewModelScope.launch {
            getApplication<Application>().getId().collect{
                _userId.value = it!!
            }
        }

    }

    fun saveUserCredentials(userEmail: String, password: String) {
        viewModelScope.launch {
            getApplication<Application>().saveUserCredentials(userEmail, password)
        }
    }

    fun saveUserId(userId:Int){
        viewModelScope.launch {
            getApplication<Application>().saveId(userId)
        }
    }

}
