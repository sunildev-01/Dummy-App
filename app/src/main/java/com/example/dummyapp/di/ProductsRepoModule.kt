package com.example.dummyapp.di

import com.example.dummyapp.data.repository.ProductsRepoImpl
import com.example.dummyapp.domain.repository.ProductRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductsRepoModule {

    @Singleton
    @Binds
    abstract fun provideProductsRepo(repoImpl: ProductsRepoImpl): ProductRepo

}