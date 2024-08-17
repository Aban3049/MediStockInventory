package com.pandaapps.medicalstoremangementsystem.Navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object SignUpHolder : Routes()

    @Serializable
    data object LoginPageHolder : Routes()

    @Serializable
    data object HomeHolder : Routes()

    @Serializable
    data object PlaceOrder : Routes()

    @Serializable
    data object HomeContent : Routes()

    @Serializable
    data object Orders: Routes()

    @Serializable
    data object Profile:Routes()

}