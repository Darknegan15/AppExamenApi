package com.example.appexamenapi.data.repository

import com.example.appexamenapi.data.model.Product
import com.example.appexamenapi.data.remote.ProductsApi

class ProductsRepository(
    private val api: ProductsApi
) {
    suspend fun getProducts(page: Int = 1): List<Product> =
        api.getProducts(page).results
}