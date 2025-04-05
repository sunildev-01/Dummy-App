package com.example.dummyapp.data.datasource

import com.example.dummyapp.data.model.ProductsDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsDataSource {

    @GET("products")
    suspend fun getProductsData(): Response<ProductsDataResponse>

}