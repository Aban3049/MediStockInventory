package com.pandaapps.medicalstoremangementsystem.ViewModel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pandaapps.medicalstoremangementsystem.Api.ProductResponse
import com.pandaapps.medicalstoremangementsystem.Api.RetrofitInstance
import com.pandaapps.medicalstoremangementsystem.States.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelApp(private val application: Application) : ViewModel() {

    private val _state = MutableStateFlow(State.Default.stateType)
    val state: StateFlow<String> = _state

    private val _allProducts = MutableStateFlow<List<ProductResponse.ProductResponseItem>>(emptyList())
    val allProducts: StateFlow<List<ProductResponse.ProductResponseItem>> = _allProducts.asStateFlow()

    val id = MutableStateFlow(0)

    init {
        _state.value = State.Default.stateType
        viewModelScope.launch {
            val response = RetrofitInstance.api.getAllProducts()
            _allProducts.value = response
        }
    }

    fun createUser(
        name: String,
        password: String,
        email: String,
        phoneNo: String,
        address: String,
        pinCode: String
    ) {
        _state.value = State.LOADING.stateType

        viewModelScope.launch {
            val result = RetrofitInstance.api.createUser(
                name = name,
                password = password,
                email = email,
                address = address,
                phone = phoneNo,
                pinCode = pinCode
            )

            if (result.isSuccessful && result.body()?.success == 200) {
                _state.value = State.SUCESS.stateType
            } else {
                _state.value = State.FAILED.stateType
            }
        }
    }

    fun getId(email: String, password: String) {
        viewModelScope.launch {
            val result = RetrofitInstance.api.getId(email = email, password = password)

            if (result.isSuccessful && result.body()?.id != null) {
                id.value = result.body()!!.id!!
                UserViewModel(application = application).saveUserId(id.value)
                Log.d("ID", "getId: ${id.value}")
                _state.value = State.SUCESS.stateType
            } else {
                _state.value = State.FAILED.stateType
                Log.d("LogIn", "logInUser: ${result.body()?.id} message :${result.body()?.id}")
            }
        }
    }

    fun logInUser(email: String, password: String) {
        _state.value = State.LOADING.stateType

        viewModelScope.launch {
            val result = RetrofitInstance.api.loginUser(email = email, password = password)

            if (result.isSuccessful && result.body()?.status == 200) {
                _state.value = State.SUCESS.stateType
                Log.d("LogIn", "logInUser: ${result.body()?.message}")
            } else {
                _state.value = State.FAILED.stateType
                Log.d("LogIn", "logInUser: ${result.body()?.status} message :${result.body()?.message}")
            }
        }
    }

    fun placeOrder(productId: Int, productQuantity: Int, vendorId: Int) {
        _state.value = State.LOADING.stateType

        viewModelScope.launch {
            val result = RetrofitInstance.api.placeOrder(
                productId = productId,
                productQuantity = productQuantity,
                vendorId = vendorId
            )

            if (result.isSuccessful && result.body()?.status == 200) {
                _state.value = State.SUCESS.stateType
                Log.d("LogIn", "logInUser: ${result.body()?.message}")
            } else {
                _state.value = State.FAILED.stateType
                Log.d("LogIn", "logInUser: ${result.body()?.message}")
            }
        }
    }

    fun failedOrSuccessSetToDefault() {
        _state.value = State.Default.stateType
    }
}



