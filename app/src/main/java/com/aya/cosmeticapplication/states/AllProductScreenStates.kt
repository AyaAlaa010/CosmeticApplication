package com.aya.cosmeticapplication.states

import com.aya.cosmeticapplication.datasource.beans.AllProductsResponseBeans
import com.aya.cosmeticapplication.datasource.beans.ProductDetailsBeans


sealed class AllProductScreenStates(


    val message: String? = "",
    val allProductsResponseBeans: ArrayList<ProductDetailsBeans>?=null


) {
    object Idle : AllProductScreenStates()

    //------------------------All Products Screen States-----------------------------
    object AllProductInProgress : AllProductScreenStates()

    class AllProductInRequestSend() : AllProductScreenStates()

    class AllProductInSuccessfulSend(allProductsResponseBeans: ArrayList<ProductDetailsBeans>) :
        AllProductScreenStates(allProductsResponseBeans = allProductsResponseBeans)

    class AllProductInFailedSend(message: String) : AllProductScreenStates(message = message)

}