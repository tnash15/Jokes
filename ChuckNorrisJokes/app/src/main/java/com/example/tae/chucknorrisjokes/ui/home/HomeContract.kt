package com.example.tae.chucknorrisjokes.ui.home

import com.example.tae.chucknorrisjokes.model.Response

class HomeContract {

    interface View{
        fun showResults(results: List<Response>)
        fun showError(message: String)
    }
    interface Presenter{
        fun getDetails(icon_url:String, id:String, url: String, value:String)
    }
}