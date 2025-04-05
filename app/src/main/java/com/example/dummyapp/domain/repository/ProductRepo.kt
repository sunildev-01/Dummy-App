package com.example.dummyapp.domain.repository

import com.example.dummyapp.data.model.ProductsDataResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ProductRepo {
    suspend fun getProducts(): Flow<Response<ProductsDataResponse>>
}