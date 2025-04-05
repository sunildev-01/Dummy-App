package com.example.dummyapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dummyapp.R
import com.example.dummyapp.data.model.ProductsDataResponse
import com.example.dummyapp.databinding.ListItemProductBinding
import androidx.core.view.isGone

class ProductsListAdapter :
    RecyclerView.Adapter<ProductsListAdapter.ProductsListViewHolder>() {

    private var mData = emptyList<ProductsDataResponse.ProductsItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(productData: List<ProductsDataResponse.ProductsItem>) {
        mData = productData
        notifyDataSetChanged()
    }

    inner class ProductsListViewHolder(
        private val binding: ListItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductsDataResponse.ProductsItem) {
            binding.productData = item
            // set data using DataBinding
            itemView.context?.let {
                Glide
                    .with(it)
                    .load(item.thumbnail)
                    .placeholder(R.drawable.ic_placeholder_image)
                    .into(binding.ivProduct)
            }
            itemView.setOnClickListener {
                toggleVisibility()
            }
            binding.ivArrowExpand.setOnClickListener {
                toggleVisibility()
            }
        }

        private fun toggleVisibility() {
            binding.apply {
                if (clProductDetails.isGone) {
                    clProductDetails.alpha = 0f
                    clProductDetails.visibility = View.VISIBLE
                    ivArrowExpand.rotation = 90f
                    clProductDetails.animate().alpha(1f).setDuration(300).start()
                } else {
                    ivArrowExpand.rotation = 270f
                    clProductDetails.animate().alpha(0f).setDuration(300).withEndAction {
                        clProductDetails.visibility = View.GONE
                    }.start()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListViewHolder {
        return ProductsListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_product,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ProductsListViewHolder, position: Int) {
        holder.bind(mData[position])
    }
}