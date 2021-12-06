package com.arash.altafi.arashaltafi.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        var retrofit : Retrofit ?= null

        fun getApiClient() : ApiService {
//            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.accessban.com/v1/data/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
//            }
//            return retrofit!!
            return retrofit!!.create(ApiService::class.java)
        }

    }

}