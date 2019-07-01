package com.zozancan.kotlinproject.model.service

import com.zozancan.kotlinproject.model.response.ProductListResponse
import retrofit2.http.GET

interface IProductService {

    @GET("list")
    fun urunListesiniGetir(): retrofit2.Call<ProductListResponse>
}