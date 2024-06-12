package com.pandaapps.medicalstoremangementsystem.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pandaapps.medicalstoremangementsystem.Api.Api_Builder
import com.pandaapps.medicalstoremangementsystem.Api.RetrofitInstance
import com.pandaapps.medicalstoremangementsystem.States.State
import kotlinx.coroutines.launch


class ViewModelSignupScreen : ViewModel() {

    var state = mutableStateOf("")

    init {
        state.value = State.Default.stateType
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


    fun failedSetToDefault() {
        state.value = State.Default.stateType
    }


}