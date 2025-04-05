package com.example.dummyapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummyapp.data.model.ProductsDataResponse
import com.example.dummyapp.domain.usecase.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val useCase: ProductUseCase) : ViewModel() {

    private val _getProductResponse = MutableSharedFlow<Response<ProductsDataResponse>>()
    val getProductResponse = _getProductResponse.asSharedFlow()

    fun getProductsDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getProductData().collect {
                withContext(Dispatchers.Main.immediate) {
                    if (it.isSuccessful) {
                        _getProductResponse.emit(it)
                    }
                }
            }
        }
    }
}