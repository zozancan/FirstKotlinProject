package com.zozancan.kotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.zozancan.kotlinproject.R
import com.zozancan.kotlinproject.model.response.ProductListResponse
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter(var contex: Context, var list: List<ProductListResponse.Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductViewHolder {
        val view= LayoutInflater.from(contex).inflate(R.layout.item_product,p0,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product=list[position]
        holder.apply {
            name.text=product.name
            Picasso.get().load(product.image).into(imageview)
        }

    }

    inner class ProductViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name=view.tvName
        val imageview = view.ivImage

    }
}