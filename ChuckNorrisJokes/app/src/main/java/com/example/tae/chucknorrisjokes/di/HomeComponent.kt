package com.example.tae.chucknorrisjokes.di

import com.example.tae.chucknorrisjokes.ui.home.MainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent{
    fun inject(mainActivity: MainActivity)
}