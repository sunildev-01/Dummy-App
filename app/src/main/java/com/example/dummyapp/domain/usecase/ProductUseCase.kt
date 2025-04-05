package com.example.dummyapp.domain.usecase

import com.example.dummyapp.domain.repository.ProductRepo
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val repo: ProductRepo) {

    suspend fun getProductData() =
        repo.getProducts()

}