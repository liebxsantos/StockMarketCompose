package com.liebersonsantos.stockmarketcompose.presentation.companylistings

import com.liebersonsantos.stockmarketcompose.domain.model.CompanyListing

data class CompanyListingsState(
    val companies: List<CompanyListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
