package com.example.tae.chucknorrisjokes.ui.home

import com.example.tae.chucknorrisjokes.MainActivity
import com.example.tae.chucknorrisjokes.model.ApiData
import com.example.tae.chucknorrisjokes.model.Response
import com.example.tae.chucknorrisjokes.network.APIService
import retrofit2.Call
import retrofit2.Callback

class HomePresenter (

    private val apiService: APIService,
    private val view: MainActivity
) : HomeContract.Presenter
{
    override fun getDetails(icon_url:String, id:String, url: String, value:String)
    {
        apiService.getDetails().enqueue(object : Callback<List<Response>> {

            override fun onFailure(call: Call<List<Response>>, t: Throwable) {
                view.showError("Please try again")
            }

            override fun onResponse(call: Call<List<Response>>, response: retrofit2.Response<List<Response>>) {

                if (response.isSuccessful) {
                    view.showResults(response.body() ?: emptyList())
                    }else {
                        view.showError("An unknown error occurred")
                }

            }
        })
    }
}
