package com.pandaapps.medicalstoremangementsystem.Api


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class getIdResponse(
    @SerialName("id")
    val id: Int?
)