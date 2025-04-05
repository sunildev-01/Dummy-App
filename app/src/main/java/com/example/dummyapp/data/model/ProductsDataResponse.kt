package com.example.dummyapp.data.model

import com.google.gson.annotations.SerializedName

data class ProductsDataResponse(
    @SerializedName("total")
    val total: Int? = null,
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("skip")
    val skip: Int? = null,
    @SerializedName("products")
    val products: List<ProductsItem>? = null
) {
    data class ProductsItem(
        @SerializedName("images")
        val images: List<String?>? = null,
        @SerializedName("thumbnail")
        val thumbnail: String? = null,
        @SerializedName("minimumOrderQuantity")
        val minimumOrderQuantity: Int? = null,
        @SerializedName("rating")
        val rating: Any? = null,
        @SerializedName("returnPolicy")
        val returnPolicy: String? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("weight")
        val weight: Int? = null,
        @SerializedName("warrantyInformation")
        val warrantyInformation: String? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("tags")
        val tags: List<String?>? = null,
        @SerializedName("discountPercentage")
        val discountPercentage: Any? = null,
        @SerializedName("reviews")
        val reviews: List<ReviewsItem?>? = null,
        @SerializedName("price")
        val price: Double? = null,
        @SerializedName("meta")
        val meta: Meta? = null,
        @SerializedName("shippingInformation")
        val shippingInformation: String? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("availabilityStatus")
        val availabilityStatus: String? = null,
        @SerializedName("category")
        val category: String? = null,
        @SerializedName("stock")
        val stock: Int? = null,
        @SerializedName("sku")
        val sku: String? = null,
        @SerializedName("brand")
        val brand: String? = null,
        @SerializedName("dimensions")
        val dimensions: Dimensions? = null
    ) {
        data class ReviewsItem(
            @SerializedName("date")
            val date: String? = null,
            @SerializedName("reviewerName")
            val reviewerName: String? = null,
            @SerializedName("reviewerEmail")
            val reviewerEmail: String? = null,
            @SerializedName("rating")
            val rating: Int? = null,
            @SerializedName("comment")
            val comment: String? = null
        )

        data class Meta(
            @SerializedName("createdAt")
            val createdAt: String? = null,
            @SerializedName("qrCode")
            val qrCode: String? = null,
            @SerializedName("barcode")
            val barcode: String? = null,
            @SerializedName("updatedAt")
            val updatedAt: String? = null
        )

        data class Dimensions(
            @SerializedName("depth")
            val depth: Any? = null,
            @SerializedName("width")
            val width: Any? = null,
            @SerializedName("height")
            val height: Any? = null
        )
    }
}
