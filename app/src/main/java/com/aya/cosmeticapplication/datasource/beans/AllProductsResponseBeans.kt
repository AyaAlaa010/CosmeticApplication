package com.aya.cosmeticapplication.datasource.beans

import android.os.Parcelable
import com.aya.cosmeticapplication.datasource.models.AllProductsResponseModel
import com.aya.cosmeticapplication.datasource.models.ProductDetailsModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllProductsResponseBeans(val allProductlist: ArrayList<ProductDetailsBeans>) : Parcelable


@Parcelize
data class ProductDetailsBeans(
    val api_featured_image: String,
    val brand: String,
    val category: String,
    val created_at: String,
    val currency: String,
    val description: String,
    val id: Int,
    val image_link: String,
    val name: String,
    val price: String,
    val price_sign: String,
    val product_api_url: String,
    val product_colors: List<ProductColorBeans>,
    val product_link: String,
    val product_type: String,
    val rating: Double,
    val tag_list: List<String>,
    val updated_at: String,
    val website_link: String,
) : Parcelable

@Parcelize
data class ProductColorBeans(
    val colour_name: String,
    val hex_value: String,
) : Parcelable

@kotlinx.parcelize.Parcelize
data class NullResponseBean(
    val data: String? = null
) : Parcelable
fun ProductDetailsBeans.toProductDetailsModel(): ProductDetailsModel {
    return ProductDetailsModel(
        brand = brand,
        description = description,
        id = id,
        image_link = image_link,
        name = name,
        price = price,
        price_sign = price_sign
    )
}

//fun AllProductsResponseBeans.toAllProductResponseModel(): AllProductsResponseModel {
//    return AllProductsResponseModel(
//        allProductlist=allProductlist
//    )
//}


