package com.aya.cosmeticapplication.states

import com.aya.cosmeticapplication.datasource.beans.AllProductsResponseBeans


sealed class AllProductScreenStates(


    val message: String? = "",
    val allProductsResponseBeans: AllProductsResponseBeans?=null


) {
    object Idle : AllProductScreenStates()

    //------------------------All Products Screen States-----------------------------
    object AllProductInProgress : AllProductScreenStates()

    class AllProductInRequestSend() : AllProductScreenStates()

    class AllProductInSuccessfulSend(allProductsResponseBeans: AllProductsResponseBeans) :
        AllProductScreenStates(allProductsResponseBeans = allProductsResponseBeans)

    class AllProductInFailedSend(message: String) : AllProductScreenStates(message = message)

}