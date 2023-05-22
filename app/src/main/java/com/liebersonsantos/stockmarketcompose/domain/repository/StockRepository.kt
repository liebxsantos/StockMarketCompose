package com.liebersonsantos.stockmarketcompose.domain.repository

import com.liebersonsantos.stockmarketcompose.domain.model.CompanyListing
import com.liebersonsantos.stockmarketcompose.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {
    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>
}