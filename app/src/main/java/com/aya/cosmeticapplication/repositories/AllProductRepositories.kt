package com.aya.cosmeticapplication.repositories

import co.trevanta.ticksntravel.datasource.constants.DataState
import com.aya.cosmeticapplication.datasource.endpoints.ProductsEndPoints
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllProductRepositories @Inject constructor(val productsEndPoints: ProductsEndPoints) {


    fun getAllProducts(  )= flow{
        emit(DataState.Loading())
        try{
            val response=productsEndPoints.getProducts()
            if (response.isSuccessful&& response.code()==200){
                emit(DataState.Success(response.body()))
            }
            else{
                emit(DataState.Error(response.message(),null))
            }
        }
        catch (e:Exception){
            emit(DataState.Error(e.message?:"Something went wrong!!", null))
            e.printStackTrace()

        }
    }


}
