package com.aya.cosmeticapplication.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aya.cosmeticapplication.R
import com.aya.cosmeticapplication.databinding.ItemAllProductsBinding
import com.aya.cosmeticapplication.datasource.beans.ProductDetailsBeans
import com.aya.cosmeticapplication.datasource.beans.toProductDetailsModel
import com.aya.cosmeticapplication.datasource.models.ProductDetailsModel
import com.bumptech.glide.Glide


class AllProductsAdapter(var allProductList: ArrayList<ProductDetailsBeans>, val context: Context) :
    RecyclerView.Adapter<AllProductsAdapter.ListHolder>() {

    fun setData(allProductList: ArrayList<ProductDetailsBeans>) {
        this.allProductList = allProductList
        this.notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_all_products,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val product = allProductList.get(position).toProductDetailsModel()
        setProductDataToViews(holder,product)
        holder.itemView.setOnClickListener {
        }
    }

    private fun setProductDataToViews(holder: ListHolder, product:ProductDetailsModel){
        holder.itemBinding.tvProductName.text = product.name

        Glide.with(context)
            .load(product.image_link)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemBinding.imgProduct);



    }


    override fun getItemCount(): Int {
        return allProductList!!.size
    }

    class ListHolder(itemBinding: ItemAllProductsBinding) :
        RecyclerView.ViewHolder(itemBinding.getRoot()) {
        var itemBinding: ItemAllProductsBinding

        init {
            this.itemBinding = itemBinding
        }
    }


}