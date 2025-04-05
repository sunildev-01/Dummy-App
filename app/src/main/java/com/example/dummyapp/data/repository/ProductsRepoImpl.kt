package com.example.dummyapp.data.repository

import com.example.dummyapp.data.datasource.ProductsDataSource
import com.example.dummyapp.domain.repository.ProductRepo
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(
    private val dataSource: ProductsDataSource
) :
    ProductRepo {

    override suspend fun getProducts() = flow {
        val response = dataSource.getProductsData()
        if (response.isSuccessful) {
            emit(Response.success(response.body()))
        }
    }
}