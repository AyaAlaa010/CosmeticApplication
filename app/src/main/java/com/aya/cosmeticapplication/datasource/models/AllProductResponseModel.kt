package com.aya.cosmeticapplication.datasource.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllProductsResponseModel(val allProductlist: ArrayList<ProductDetailsModel>): Parcelable



@Parcelize
data class ProductDetailsModel(
    val brand: String?=null,
    val description: String?=null,
    val id: Int,
    val image_link: String?=null,
    val name: String?=null,
    val price: String?=null,
    val price_sign: String?=null
): Parcelable

@Parcelize
data class ProductColorModel(
    val colour_name: String,
    val hex_value: String
): Parcelable


