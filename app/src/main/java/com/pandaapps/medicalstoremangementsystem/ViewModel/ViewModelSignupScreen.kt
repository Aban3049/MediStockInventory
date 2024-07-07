package com.pandaapps.medicalstoremangementsystem.ViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pandaapps.medicalstoremangementsystem.Api.ProductResponse
import com.pandaapps.medicalstoremangementsystem.Api.RetrofitInstance
import com.pandaapps.medicalstoremangementsystem.States.State
import kotlinx.coroutines.launch


class ViewModelSignupScreen : ViewModel() {

    var state = mutableStateOf("")

    var allProducts = mutableStateOf<ProductResponse?>(null)

    init {
        state.value = State.Default.stateType
        viewModelScope.launch {
            allProducts.value = RetrofitInstance.api.getAllProducts()
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
                Log.d("LogIn", "logInUser: ${result.body()?.status} message :${result.body()?.message} ")
            }

        }

    }


    fun failedSetToDefault() {
        state.value = State.Default.stateType
    }


}