package com.arash.altafi.arashaltafi.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.arashaltafi.R
import com.arash.altafi.arashaltafi.adapters.MainAdapter
import com.arash.altafi.arashaltafi.viewModels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        //Lottie
        mainViewModel.progressBarLiveData.observe(this) {
            if (it) {
                lottie_price.visibility = View.VISIBLE
                lottie_price.playAnimation()
            }
            else {
                lottie_price.visibility = View.GONE
            }
        }

        //RecyclerView
        mainViewModel.priceLiveData.observe(this) {
            val mainAdapter : MainAdapter by inject { parametersOf(it.sana.data) }
            rc_price.adapter = mainAdapter
            rc_price.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL , false)

            //Error Toast
            if (mainViewModel.errorLiveData.value != null) {
                Toast.makeText(this , mainViewModel.errorLiveData.value.toString() , Toast.LENGTH_SHORT).show()
            }
        }

    }

}