package com.pandaapps.medicalstoremangementsystem.Api


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetOrdersResponseItem(
    @SerialName("dateOfOrder")
    val dateOfOrder: String?,
    @SerialName("isApproved")
    val isApproved: Int?,
    @SerialName("Order_id")
    val orderId: Int?,
    @SerialName("productId")
    val productId: Int?,
    @SerialName("productQuantity")
    val productQuantity: Int?,
    @SerialName("vendorId")
    val vendorId: String?
)