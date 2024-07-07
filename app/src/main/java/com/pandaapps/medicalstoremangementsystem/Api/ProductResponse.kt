package com.pandaapps.medicalstoremangementsystem.Api


import com.google.gson.annotations.SerializedName

class ProductResponse : ArrayList<ProductResponse.ProductResponseItem>() {

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
    )

}