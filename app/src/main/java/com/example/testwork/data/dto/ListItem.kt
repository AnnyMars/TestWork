package com.example.testwork.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListItem(
    @SerialName("dateTimestamp")
    val dateTimestamp: Long,
    @SerialName("description")
    val description: String,
    @SerialName("endDateTimestamp")
    val endDateTimestamp: Long,
    @SerialName("startDateTimestamp")
    val startDateTimestamp: Long,
    @SerialName("tags")
    val tags: List<String>,
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: Type,
    @SerialName("url")
    val url: String
)