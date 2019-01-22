package com.example.tae.chucknorrisjokes.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.tae.chucknorrisjokes.App
import com.example.tae.chucknorrisjokes.R
import com.example.tae.chucknorrisjokes.di.DaggerHomeComponent
import com.example.tae.chucknorrisjokes.di.HomeModule
import com.example.tae.chucknorrisjokes.model.Response
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {

    private val ApiAdapter = ApiAdapter()

    @Inject
    lateinit var homePresenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ApiAdapter

        btnButton.setOnClickListener {
            homePresenter.getDetails(
                icon_url = String(), id = String(),
                url = String(), value = String()
            )
        }
    }

    override fun showResults(results: List<Response>) {
        ApiAdapter.setData(results)
    }


    override fun showError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}

