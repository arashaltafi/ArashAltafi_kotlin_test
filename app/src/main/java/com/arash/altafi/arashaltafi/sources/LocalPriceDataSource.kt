package com.arash.altafi.arashaltafi.sources

import com.arash.altafi.arashaltafi.models.ResponsePrice
import io.reactivex.Single

class LocalPriceDataSource : PriceDataSource {

    override fun getPrice(): Single<ResponsePrice> {
        TODO("SAVE LOCAL PRICE")
    }

}