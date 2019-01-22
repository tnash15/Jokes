package com.example.tae.chucknorrisjokes

import android.app.Application
import com.example.tae.chucknorrisjokes.di.AppComponent
import com.example.tae.chucknorrisjokes.di.DaggerAppComponent
import com.example.tae.chucknorrisjokes.di.DaggerAppComponent.builder
import dagger.Component


class App : Application(){

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()

    }

    fun getComponent() = appComponent
}