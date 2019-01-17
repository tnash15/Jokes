package com.example.tae.chucknorrisjokes.ui.home

import com.example.tae.chucknorrisjokes.model.ApiData
import com.example.tae.chucknorrisjokes.network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter (

    private val apiService: APIService,
    private val view: HomeContract. View) : HomeContract.Presenter
{
    override fun getDetails(icon_url:String, id:String, url: String, value:String)
    {
        apiService.getDetails().enqueue(object : Callback<List<ApiData>> {
            override fun onFailure(call: Call<ApiData>, throwable: Throwable) {
                view.showError("Please try again")
            }

            override fun onResponse(call: Call<ApiData>, response: Response<ApiData> {
                if (response.isSuccessful) {
                    view.showResults(response.body() ?: emptyList()) {
                    } else {
                        view.showError("An unknown error occurred")
                    }
                }
            }
        })
    }
}
