package com.liebersonsantos.stockmarketcompose.data.cvs

import java.io.InputStream

interface CSVParser <T> {
    suspend fun parser(stream: InputStream): List<T>
}