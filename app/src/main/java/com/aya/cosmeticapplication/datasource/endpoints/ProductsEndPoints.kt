package com.aya.cosmeticapplication.datasource.endpoints

import co.trevanta.ticksntravel.datasource.constants.HttpResult
import com.aya.cosmeticapplication.datasource.beans.AllProductsResponseBeans
import retrofit2.Response
import retrofit2.http.GET

interface ProductsEndPoints {
    // http://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline&product_type=lipstick

    @GET("/api/v1/products.json")
    suspend fun getProducts(): Response<AllProductsResponseBeans>


}