package com.example.appexamenapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.material3.Surface

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appexamenapi.presentation.viewmodel.ProductsViewModel
import com.example.appexamenapi.screens.ProductsScreen
import com.example.appexamenapi.ui.theme.AppExamenApiTheme

//Main de la app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppExamenApiTheme {
                Surface {
                    val vm: ProductsViewModel = viewModel()
                    ProductsScreen(vm)
                }
            }
        }
    }
}
