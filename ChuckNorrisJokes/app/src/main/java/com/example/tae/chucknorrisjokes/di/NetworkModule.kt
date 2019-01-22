package com.example.tae.chucknorrisjokes.di

import com.example.tae.chucknorrisjokes.network.APIService
import com.example.tae.chucknorrisjokes.network.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import javax.inject.Singleton

@Module
class NetworkModule{

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    @OkHttpWithLogging
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    @OkHttpWithoutLogging
    fun provideHttpClientWithoutLogging(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideRetrofit(retrofitBuilder: Retrofit.Builder,
                        @OkHttpWithoutLogging okHttpClient: OkHttpClient): Retrofit{
        return retrofitBuilder
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideAPIService(retrofit: Retrofit): APIService{
        return retrofit.create(APIService::class.java)
    }
}