package com.liebersonsantos.stockmarketcompose.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListing(
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    companion object {
        const val API_KEY = "LUQLM78S3RBR8P3H"
        const val BASE_URL = "https://alphavantage.co"
    }
}