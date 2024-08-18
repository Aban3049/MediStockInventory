package com.pandaapps.medicalstoremangementsystem.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pandaapps.medicalstoremangementsystem.Api.GetOrdersResponseItem
import com.pandaapps.medicalstoremangementsystem.Api.RetrofitInstance
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

    private val _orders = MutableLiveData<List<GetOrdersResponseItem>>()
    val orders: LiveData<List<GetOrdersResponseItem>> get() = _orders

    val viewModelApp = ViewModelApp(application)

    init {
        viewModelScope.launch {
            getApplication<Application>().getUserCredentials().collect { credentials ->
                _userCredentials.value = credentials
                viewModelApp.logInUser(credentials.first.toString(), credentials.second.toString())
            }
        }

        viewModelScope.launch {
            getApplication<Application>().getId().collect {id ->
                id?.let {
                    _userId.value = it
                    fetchVendorOrders(it)
                    Log.d("Orders", "${fetchVendorOrders(it)}: ")
                } ?: run {
                    // Handle the case where `id` is null
                    _userId.value = 0
                    // Optionally, handle the scenario where id is null (e.g., log an error or notify the user)
                }
//                _userId.value = it!!
//                fetchVendorOrders(_userId.value ?: 0)
            }
        }

    }

    fun fetchVendorOrders(vendorId: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getVendorOrders(vendorId)
                if (response.isSuccessful) {
                    _orders.value = response.body() ?: emptyList()
                } else {
                    _orders.value = emptyList()
                }
            } catch (e: Exception) {
                _orders.value = emptyList()
            }
        }
    }

    fun saveUserCredentials(userEmail: String, password: String) {
        viewModelScope.launch {
            getApplication<Application>().saveUserCredentials(userEmail, password)
        }
    }

    fun saveUserId(userId: Int) {
        viewModelScope.launch {
            getApplication<Application>().saveId(userId)
        }
    }

}
