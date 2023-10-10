package com.aya.cosmeticapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aya.cosmeticapplication.R
import com.aya.cosmeticapplication.common.LoadingScreen
import com.aya.cosmeticapplication.common.showSnackBar
import com.aya.cosmeticapplication.databinding.FragmentAllProductsBinding
import com.aya.cosmeticapplication.datasource.beans.ProductDetailsBeans
import com.aya.cosmeticapplication.datasource.beans.toProductDetailsModel
import com.aya.cosmeticapplication.states.AllProductScreenStates
import com.aya.cosmeticapplication.viewmodels.AllProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class AllProductsFragment : Fragment() {
    lateinit var  binding:FragmentAllProductsBinding
    private val viewModel by viewModels<AllProductsViewModel>()
    lateinit var mView: View
    lateinit var loading: LoadingScreen
    lateinit var adapterAllProducts:AllProductsAdapter
    lateinit var  allProductList:ArrayList<ProductDetailsBeans>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_all_products, container, false)
        mView = binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setAdapterToRec()
        attachViewModel()
        getAllProducts()


    }

    private fun init(){
        loading = LoadingScreen
        allProductList=  ArrayList<ProductDetailsBeans>()
        adapterAllProducts= AllProductsAdapter(allProductList,requireContext())
    }


    private fun getAllProducts(){
        viewModel.changeScreenState(
            AllProductScreenStates.AllProductInRequestSend()
        )
    }


    private fun attachViewModel() {
        viewModel.allProductScreenStateObserver
            .observe(viewLifecycleOwner) { handleState(it) }
    }

    private fun clearState() {
        viewModel.changeScreenState(
            AllProductScreenStates.Idle
        )
    }

    private fun handleState(state: AllProductScreenStates?) {
        when (state) {
            AllProductScreenStates.Idle -> {

            }

            AllProductScreenStates.AllProductInProgress -> {
                loading.displayLoadingWithText(requireContext(), "loading", false)
            }

            is AllProductScreenStates.AllProductInSuccessfulSend -> {
                loading.hideLoading()
                println("data======================${state.allProductsResponseBeans?.size}")
                println("nameeeeeeeeeeeeee:  "+state.allProductsResponseBeans?.get(0)?.toProductDetailsModel()?.name)


                if(this::adapterAllProducts.isInitialized)
                adapterAllProducts.setData(state.allProductsResponseBeans!!)

                clearState()

            }

            is AllProductScreenStates.AllProductInFailedSend -> {
                loading.hideLoading()
                clearState()
                if (this::mView.isInitialized)

                    showSnackBar(mView, state.message!!)
            }

            else -> {}
        }
    }

    private fun setAdapterToRec() {
        val layoutManager = GridLayoutManager(requireContext(),2,RecyclerView.VERTICAL, false)
        binding.recAllProducts.adapter = adapterAllProducts
        binding.recAllProducts.layoutManager = layoutManager
    }


}