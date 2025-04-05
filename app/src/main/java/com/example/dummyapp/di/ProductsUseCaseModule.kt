package com.example.dummyapp.di

import com.example.dummyapp.domain.repository.ProductRepo
import com.example.dummyapp.domain.usecase.ProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ProductsUseCaseModule {

    @Provides
    fun provideProductsUseCase(repo: ProductRepo) = ProductUseCase(repo)

}