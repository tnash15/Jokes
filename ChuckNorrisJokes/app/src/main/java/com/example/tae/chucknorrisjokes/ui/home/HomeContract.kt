package com.example.tae.chucknorrisjokes.ui.home

class HomeContract {

    interface View{
        fun showResults(results: List<Any>, function: () -> Unit)
        fun showError(message: String)
    }
    interface Presenter{
        fun getDetails(icon_url:String, id:String, url: String, value:String)
    }
}