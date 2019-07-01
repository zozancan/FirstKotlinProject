package com.zozancan.kotlinproject.model.response

class ProductListResponse {

    var products: List<Product>? = null

    inner class Product {
        var product_id: String? = null
        var name: String? = null
        var price: Int? = null
        var image: String? = null

    }
}