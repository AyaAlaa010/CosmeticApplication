package com.aya.cosmeticapplication.viewmodels

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.trevanta.ticksntravel.datasource.constants.DataState
import com.aya.cosmeticapplication.common.handleErrors
import com.aya.cosmeticapplication.repositories.AllProductRepositories
import com.aya.cosmeticapplication.states.AllProductScreenStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class AllProductsViewModel @Inject constructor(
    private val application: Application,
    private val repository: AllProductRepositories
) : ViewModel(), LifecycleObserver {

    private val allProductScreenState: MutableLiveData<AllProductScreenStates> =
        MutableLiveData<AllProductScreenStates>(AllProductScreenStates.Idle)

    val allProductScreenStateObserver: LiveData<AllProductScreenStates>
        get() = allProductScreenState


    fun changeScreenState(newState: AllProductScreenStates) {
        when (newState) {
            is AllProductScreenStates.AllProductInRequestSend -> {
                viewModelScope.launch {
                    repository.getAllProducts(

                    ).onEach {
                        when (it) {
                            is DataState.Loading -> {
                                this@AllProductsViewModel.allProductScreenState.value =
                                    AllProductScreenStates.AllProductInProgress
                            }

                            is DataState.Success -> {
                                this@AllProductsViewModel.allProductScreenState.value =
                                    AllProductScreenStates.AllProductInSuccessfulSend(it.data!!)
                            }

                            is DataState.Error -> {
                                this@AllProductsViewModel.allProductScreenState.value =
                                    AllProductScreenStates.AllProductInFailedSend(it.message!!)
                            }


                        }
                    }.handleErrors(application.applicationContext).launchIn(viewModelScope)
                }
            }


            else -> {
                return
            }}}}