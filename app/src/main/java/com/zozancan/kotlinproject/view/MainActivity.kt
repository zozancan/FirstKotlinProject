package com.zozancan.kotlinproject.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.zozancan.kotlinproject.R
import com.zozancan.kotlinproject.adapter.ProductAdapter
import com.zozancan.kotlinproject.model.response.ProductListResponse
import com.zozancan.kotlinproject.model.service.IProductService
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    // val textView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit=Retrofit.Builder().baseUrl("https://s3-eu-west-1.amazonaws.com/developer-application-test/cart/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()

        val productService=retrofit.create(IProductService::class.java)

        val list=productService.urunListesiniGetir()

        list.enqueue(object :retrofit2.Callback<ProductListResponse>{
            override fun onFailure(call: retrofit2.Call<ProductListResponse>, t: Throwable) {



            }

            override fun onResponse(call: retrofit2.Call<ProductListResponse>, response: Response<ProductListResponse>) {

              if (!response.isSuccessful)
                  return

                response.body()?.products?.let {
                    val adapter = ProductAdapter( this@MainActivity, it)
                    rvList.adapter = adapter
                    rvList.layoutManager =
                        LinearLayoutManager(this@MainActivity,
                            LinearLayoutManager.VERTICAL, false)
                }
            }

        })
    }
}

