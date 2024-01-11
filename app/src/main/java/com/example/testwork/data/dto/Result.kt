package com.example.testwork.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("list")
    val list: List<ListItem>,
    @SerialName("total")
    val total: Int
)