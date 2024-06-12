package com.pandaapps.medicalstoremangementsystem.States

sealed class State(var stateType: String) {

    object Default : State("Default")
    object LOADING : State("LOADING")
    object SUCESS : State("SUCESS")
    object FAILED : State("FAILED")

}