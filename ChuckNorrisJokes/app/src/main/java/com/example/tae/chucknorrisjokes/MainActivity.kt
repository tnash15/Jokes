package com.example.tae.chucknorrisjokes

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.tae.chucknorrisjokes.model.ApiData
import com.example.tae.chucknorrisjokes.network.APIService
import com.example.tae.chucknorrisjokes.network.BASE_URL
import com.example.tae.chucknorrisjokes.ui.home.ApiAdapter
import com.example.tae.chucknorrisjokes.ui.home.HomeContract
import com.example.tae.chucknorrisjokes.ui.home.HomePresenter
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val ApiAdapter = ApiAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = retrofitBuilder
            .client(okHttpClient)
            .build()

        val apiService = retrofit.create(APIService::class.java)

        val homePresenter: HomeContract.Presenter = HomePresenter(apiService, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ApiAdapter

        btnButton.setOnClickListener {
            homePresenter.getDetails(
                icon_url = String(), id = String(),
                url = String(), value = String()
            )
        }
        override fun showResults(results: List<ApiData>) {
            ApiAdapter.setData(results)
        }


        override fun showError(message: String) {

        }
    }

}
