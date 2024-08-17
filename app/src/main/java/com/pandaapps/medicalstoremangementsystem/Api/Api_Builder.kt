package com.pandaapps.medicalstoremangementsystem.Api

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api_Builder {


    @FormUrlEncoded
    @POST("/createUser")
    suspend fun createUser(

        @Field("name") name: String,
        @Field("password") password: String,
        @Field("email") email: String,
        @Field("address") address: String,
        @Field("phone") phone: String,
        @Field("pincode") pinCode: String

    ): Response<UserCreateResponse>

    @GET("/getAllProducts")
    suspend fun getAllProducts(): ProductResponse

    @FormUrlEncoded
    @POST("/login")
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<loginResponse>

    @FormUrlEncoded
    @POST("/getId")
    suspend fun getId(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<getIdResponse>

    @FormUrlEncoded
    @POST("/addOrder")
    suspend fun placeOrder(
        @Field("productId") productId: Int,
        @Field("productQuantity") productQuantity: Int,
        @Field("vendorId") vendorId: Int
    ): Response<OrderResponse>


    companion object {
        const val BASE_URL = "http://muhammadaban.pythonanywhere.com"
    }


}