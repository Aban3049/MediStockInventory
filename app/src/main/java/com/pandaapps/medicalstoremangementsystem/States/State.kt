package com.pandaapps.medicalstoremangementsystem.States

sealed class State(var stateType: String) {

    data object Default : State("Default")
    data object LOADING : State("LOADING")
    data object SUCESS : State("SUCESS")
    data object FAILED : State("FAILED")

}