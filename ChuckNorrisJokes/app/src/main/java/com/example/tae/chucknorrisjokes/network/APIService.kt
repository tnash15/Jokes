package com.example.tae.chucknorrisjokes.network

import android.telecom.Call
import com.example.tae.chucknorrisjokes.model.ApiData
import com.example.tae.chucknorrisjokes.model.Response
import com.example.tae.chucknorrisjokes.network.END_POINT
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET(END_POINT)
    fun getDetails(): Call<List<ApiData>>
}