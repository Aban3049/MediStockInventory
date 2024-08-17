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

    var state = mutableStateOf("")


    private val _allProducts =
        MutableStateFlow<List<ProductResponse.ProductResponseItem>>(emptyList())
    val allProducts: StateFlow<List<ProductResponse.ProductResponseItem>> =
        _allProducts.asStateFlow()

    val id = MutableStateFlow<Int>(0)


    init {
        state.value = State.Default.stateType
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
        state.value = State.LOADING.stateType


        viewModelScope.launch {
            val result = RetrofitInstance.api.createUser(
                name = name,
                password = password,
                email = email,
                address = address,
                phone = phoneNo,
                pinCode = pinCode
            )

            if (result.isSuccessful == true) {

                if (result.body()?.success == 200) {
                    state.value = State.SUCESS.stateType
                }


            } else {
                state.value = State.FAILED.stateType
            }

        }

    }

    fun getId(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val result = RetrofitInstance.api.getId(email = email, password = password)

            if (result.isSuccessful) {

                if (result.body()?.id != null) {
                    state.value = State.SUCESS.stateType
                    id.value = result.body()!!.id!!
                    UserViewModel(application = application).saveUserId(id.value)
                    Log.d("ID", "getId: ${id.value}")
                }

            } else {

                state.value = State.FAILED.stateType

                Log.d(
                    "LogIn",
                    "logInUser: ${result.body()?.id} message :${result.body()?.id} "
                )

            }

        }

    }

    fun placeOrder(
        productId: Int,
        productQuantity: Int,
        vendorId: Int
    ) {
        state.value = State.LOADING.stateType

        viewModelScope.launch {

            val result = RetrofitInstance.api.placeOrder(
                productId = productId,
                productQuantity = productQuantity,
                vendorId = vendorId
            )

            if (result.isSuccessful == true) {

                if (result.body()?.status == 200) {
                    state.value = State.SUCESS.stateType
                    Log.d("LogIn", "logInUser: ${result.body()?.message} ")

                } else {
                    state.value = State.FAILED.stateType
                    Log.d("LogIn", "logInUser: ${result.body()?.message} ")

                }
            }

        }

    }

    fun logInUser(
        email: String,
        password: String
    ) {
        state.value = State.LOADING.stateType

        viewModelScope.launch {
            val result = RetrofitInstance.api.loginUser(email = email, password = password)

            if (result.isSuccessful == true) {

                if (result.body()?.status == 200) {
                    state.value = State.SUCESS.stateType
                    Log.d("LogIn", "logInUser: ${result.body()?.message} ")

                }
            } else {

                state.value = State.FAILED.stateType

                Log.d(
                    "LogIn",
                    "logInUser: ${result.body()?.status} message :${result.body()?.message} "
                )

            }

        }

    }


    fun failedOrSuccessSetToDefault() {
        state.value = State.Default.stateType
    }


}