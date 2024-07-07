package com.pandaapps.medicalstoremangementsystem.Navigation

import kotlinx.serialization.Serializable

sealed class NavScreens {

    @Serializable
    object SignUpHolder

    @Serializable
    object LoginPageHolder

    @Serializable
    object HomeHolder

    @Serializable
    object PlaceOrder

}