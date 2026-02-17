package com.example.appexamenapi.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appexamenapi.data.model.Product
import com.example.appexamenapi.data.remote.ProductsNetwork
import com.example.appexamenapi.data.repository.ProductsRepository
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    private val repository = ProductsRepository(ProductsNetwork.api)

    var state by mutableStateOf<UiState<List<Product>>>(UiState.Loading)
        private set

    init {
        loadProducts()
    }

    fun loadProducts(page: Int = 1) {
        viewModelScope.launch {
            state = UiState.Loading
            state = try {
                UiState.Success(repository.getProducts(page))
            } catch (e: Exception) {
                UiState.Error(e.message ?: "Error cargando productos")
            }
        }
    }
}