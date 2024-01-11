package com.example.testwork.data.network

import com.example.testwork.Utils
import com.example.testwork.data.dto.ItemResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiRepository {
    suspend fun getResponse(): ItemResponse = ApiClient.client.get(Utils.BASE_URL).body()
}