package com.liebersonsantos.stockmarketcompose.data.repository

import com.liebersonsantos.stockmarketcompose.data.local.StockDatabase
import com.liebersonsantos.stockmarketcompose.data.mapper.toCompanyListing
import com.liebersonsantos.stockmarketcompose.data.remote.StockApi
import com.liebersonsantos.stockmarketcompose.domain.model.CompanyListing
import com.liebersonsantos.stockmarketcompose.domain.repository.StockRepository
import com.liebersonsantos.stockmarketcompose.util.Resource
import com.opencsv.CSVReader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(private val api: StockApi, private val db: StockDatabase): StockRepository {

    private val dao = db.dao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> = flow {
        emit(Resource.Loading(true))
        val localListing = dao.searchCompanyListing(query)
        emit(Resource.Success(
            data = localListing.map { it.toCompanyListing() }
        ))

        val isDbEmpty = localListing.isEmpty() && query.isBlank()
        val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
        if (shouldJustLoadFromCache) {
            emit(Resource.Loading(false))
            return@flow
        }

        val remoteListing = try {
            val response = api.getListing()

        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
        }



    }

}