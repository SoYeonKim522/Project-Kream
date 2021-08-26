package com.example.kream.kotlin.src.main.myPage.models

data class UserInfoResult(
    val email: String,
    val grade: String,
    val idx: Int,
    val introduction: String,
    val name: String,
    val nickName: String,
    val point: Int,
    val productLikeCount: Int,
    val productOwnCount: Int,
    val profileImage: String,
    val purchaseBiddingCount: Int,
    val purchaseCompletedCount: Int,
    val purchaseProceedingCount: Int,
    val saleBiddingCount: Int,
    val saleCompletedCount: Int,
    val saleProceedingCount: Int,
    val totalProductPurchasePrice: Int,
    val totalProductValue: Int,
    val totalValueIncreaseAmount: Int,
    val totalValueIncreaseRate: Double
)