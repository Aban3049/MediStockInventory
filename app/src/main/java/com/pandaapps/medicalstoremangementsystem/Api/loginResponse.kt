package com.pandaapps.medicalstoremangementsystem.Api


import com.google.gson.annotations.SerializedName

data class loginResponse(
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Int?
)