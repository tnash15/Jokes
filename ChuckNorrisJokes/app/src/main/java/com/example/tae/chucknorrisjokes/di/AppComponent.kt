package com.example.tae.chucknorrisjokes.di

import com.example.tae.chucknorrisjokes.network.APIService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent{
    fun apiService(): APIService
}