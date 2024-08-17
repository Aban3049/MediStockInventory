package com.pandaapps.medicalstoremangementsystem.Api


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

class ProductResponse : ArrayList<ProductResponse.ProductResponseItem>() {

    @Parcelize
    data class ProductResponseItem(
        @SerializedName("category")
        val category: String?,
        @SerializedName("isActive")
        val isActive: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("price")
        val price: Double?,
        @SerializedName("Product_id")
        val productId: Int?,
        @SerializedName("stock")
        val stock: Int?
    ): Parcelable

}