package com.arash.altafi.arashaltafi.sources

import com.arash.altafi.arashaltafi.api.ApiService
import com.arash.altafi.arashaltafi.models.ResponsePrice
import com.arash.altafi.arashaltafi.sources.PriceDataSource
import io.reactivex.Single

class RemotePriceDataSource(val apiService: ApiService) : PriceDataSource {

    override fun getPrice(): Single<ResponsePrice> = apiService.getPrice()

}