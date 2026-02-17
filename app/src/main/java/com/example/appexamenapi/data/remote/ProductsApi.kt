package com.example.appexamenapi.data.remote

import com.example.appexamenapi.data.model.Product
import com.example.appexamenapi.data.model.PagedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {

    @GET("api/products")
    suspend fun getProducts(
        @Query("page") page: Int = 1
    ): PagedResponse<Product>
}