package com.arash.altafi.arashaltafi.repositories

import com.arash.altafi.arashaltafi.models.ResponsePrice
import com.arash.altafi.arashaltafi.sources.LocalPriceDataSource
import com.arash.altafi.arashaltafi.sources.PriceDataSource
import io.reactivex.Single

class PriceRepositoryImpl(val remotePrice: PriceDataSource, localPriceDataSource: LocalPriceDataSource) :
    PriceRepository {

    override fun getPrice(): Single<ResponsePrice> = remotePrice.getPrice()

}