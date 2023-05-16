package com.liebersonsantos.stockmarketcompose.data.mapper

import com.liebersonsantos.stockmarketcompose.data.local.CompanyListingEntity
import com.liebersonsantos.stockmarketcompose.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}