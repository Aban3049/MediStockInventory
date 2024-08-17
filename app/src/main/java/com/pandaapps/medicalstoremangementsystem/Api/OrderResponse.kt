package com.pandaapps.medicalstoremangementsystem.Api


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderResponse(
    @SerialName("message")
    val message: String?,
    @SerialName("status")
    val status: Int?
)