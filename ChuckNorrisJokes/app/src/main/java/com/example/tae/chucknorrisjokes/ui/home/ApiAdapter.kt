package com.example.tae.chucknorrisjokes.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tae.chucknorrisjokes.R
import com.example.tae.chucknorrisjokes.model.ApiData
import com.example.tae.chucknorrisjokes.model.Response
import kotlinx.android.synthetic.main.item_activity.view.*
import java.text.FieldPosition

class ApiAdapter : RecyclerView.Adapter<ApiAdapter.ApiViewHolder>(){

    private val data = arrayListOf<Response>()

    fun setData(items: List<Response>){
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activity, parent, false)
        return ApiViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: ApiViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }

    class ApiViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(data: Response){
            val tvIcon_url = view.findViewById<TextView>(R.id.tvIcon_url)
            tvIcon_url.text = data.icon_url

            val tvId = view.findViewById<TextView>(R.id.tvId)
            tvId.text = data.id

            val tvUrl = view.findViewById<TextView>(R.id.tvUrl)
            tvIcon_url.text = data.url

            val tvValue = view.findViewById<TextView>(R.id.tvValue)
            tvIcon_url.text = data.value
        }
    }
}

