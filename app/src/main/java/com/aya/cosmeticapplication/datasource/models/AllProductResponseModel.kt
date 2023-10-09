package com.aya.cosmeticapplication.datasource.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllProductsResponseModel(val allProductlist: ArrayList<ProductDetailsModel>): Parcelable



@Parcelize
data class ProductDetailsModel(
    val brand: String,
    val description: String,
    val id: Int,
    val image_link: String,
    val name: String,
    val price: String,
    val price_sign: String
): Parcelable

@Parcelize
data class ProductColorModel(
    val colour_name: String,
    val hex_value: String
): Parcelable


