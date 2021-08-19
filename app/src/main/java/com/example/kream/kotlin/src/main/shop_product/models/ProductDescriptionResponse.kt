package com.example.kream.kotlin.src.main.shop_product.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class ProductDescriptionResponse(
    @SerializedName("result") var result: ProdDescriptionResult

) : BaseResponse()

//data class ProdDescriptionList(
//    @SerializedName("resultList") var resultList: List<ProdDescriptionResult>
//)

data class ProdDescriptionResult(
    @SerializedName("brandName") val brandName: String,
    @SerializedName("buyPrice") val buyPrice: Int,
    @SerializedName("color") val color: String,
    @SerializedName("description") val description: String,
    @SerializedName("latestTransactedPrice") val latestTransactedPrice: Int,
    @SerializedName("liked") val liked: Int,
    @SerializedName("modelNo") val modelNo: String,
    @SerializedName("name") val name: String,
    @SerializedName("priceIncreaseAmount") val priceIncreaseAmount: Int,
    @SerializedName("priceIncreaseRate") val priceIncreaseRate: Double,
    @SerializedName("productImages") val productImages: List<ProductImageResult>,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("releasePrice") val releasePrice: Int,
    @SerializedName("sellPrice") val sellPrice: Int
)

data class ProdInfoData(
    @SerializedName("modelNo") val modelNo: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("color") val color: String,
    @SerializedName("releasePrice") val releasePrice: Int,

)