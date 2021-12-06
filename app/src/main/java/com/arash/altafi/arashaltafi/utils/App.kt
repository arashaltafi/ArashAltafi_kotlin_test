package com.arash.altafi.arashaltafi.utils

import android.app.Application
import com.arash.altafi.arashaltafi.adapters.MainAdapter
import com.arash.altafi.arashaltafi.api.ApiClient
import com.arash.altafi.arashaltafi.api.ApiService
import com.arash.altafi.arashaltafi.models.DataItem
import com.arash.altafi.arashaltafi.viewModels.MainViewModel
import com.arash.altafi.arashaltafi.repositories.PriceRepository
import com.arash.altafi.arashaltafi.repositories.PriceRepositoryImpl
import com.arash.altafi.arashaltafi.sources.LocalPriceDataSource
import com.arash.altafi.arashaltafi.sources.RemotePriceDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val myModule = module {

            //Api
            single<ApiService> { ApiClient.getApiClient() }

            //Repository
            factory<PriceRepository> { PriceRepositoryImpl(RemotePriceDataSource(get()) , LocalPriceDataSource()) }

            //Adapter
            factory { (price:List<DataItem>) -> MainAdapter(price) }

            //ViewModel
            viewModel { MainViewModel(get()) }

        }

        startKoin {
            androidContext(this@App)
            modules(myModule)
        }

    }
}