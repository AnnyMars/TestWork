package com.example.testwork.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Type(
    @SerialName("key")
    val key: String,
    @SerialName("title")
    val title: String
)