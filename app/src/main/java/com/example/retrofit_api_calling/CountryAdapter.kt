package com.example.retrofit_api_calling

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide


    class CountryAdapter(list: List<CountryModel2>?, CountryClick: CountryClick) : RecyclerView.Adapter<CountryAdapter.countryHolder>() {
    lateinit var context: Context

        var CountryClick=CountryClick

        var list = list

    class countryHolder(itemView: View) : ViewHolder(itemView) {

        var img = itemView.findViewById<ImageView>(R.id.image)
        var country = itemView.findViewById<TextView>(R.id.txtcountry)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): countryHolder {

        context = parent.context
        return countryHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false))


    }


    override fun getItemCount(): Int {
        return list?.size!!
    }

    override fun onBindViewHolder(holder: countryHolder, position: Int) {

       // holder.country.text=list.get(position).flag
        Glide.with(context).load(list?.get(position)?.flag).into(holder.img)
        holder.country.text=list?.get(position)?.name



        holder.itemView.setOnClickListener {

            CountryClick.onTap(position)



        }
    }


}