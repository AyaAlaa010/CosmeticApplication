package com.aya.cosmeticapplication.datasource.moduls

import com.aya.cosmeticapplication.datasource.endpoints.ProductsEndPoints
import com.aya.cosmeticapplication.datasource.retrofit.RetrofitDi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [RetrofitDi::class])
@InstallIn(SingletonComponent::class)
class AllProductsModule {
    @Singleton
    @Provides
    fun provideRegistrationApi (retrofit: Retrofit): ProductsEndPoints {
        return retrofit.create(ProductsEndPoints::class.java)
    }
}