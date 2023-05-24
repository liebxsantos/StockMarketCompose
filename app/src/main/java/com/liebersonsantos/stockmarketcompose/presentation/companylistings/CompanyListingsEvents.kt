package com.liebersonsantos.stockmarketcompose.presentation.companylistings

sealed class CompanyListingsEvents {
    object Refresh: CompanyListingsEvents()
    data class OnSearchQueryChange(val query: String): CompanyListingsEvents()
}
