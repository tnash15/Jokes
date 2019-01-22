package com.example.tae.chucknorrisjokes.di

import com.example.tae.chucknorrisjokes.network.APIService
import com.example.tae.chucknorrisjokes.ui.home.HomeContract
import com.example.tae.chucknorrisjokes.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val view: HomeContract.View){

    @HomeScope
    @Provides
    fun provideHomePresenter(apiService: APIService): HomeContract.Presenter{
        return HomePresenter(apiService, view)
    }
}