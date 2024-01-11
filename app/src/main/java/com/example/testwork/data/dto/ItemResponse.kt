package com.example.testwork.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemResponse(
    @SerialName("result")
    val result: Result,
    @SerialName("retCode")
    val retCode: Int,
    @SerialName("retExtInfo")
    val retExtInfo: RetExtInfo,
    @SerialName("retMsg")
    val retMsg: String,
    @SerialName("time")
    val time: Long
)