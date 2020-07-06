package com.example.recyclerviewmvvm.ui.main

import Rows

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewmvvm.R
import kotlinx.android.synthetic.main.recyclerview_layout.view.*

class CountryInfoAdapter(private val rowsList: List<Rows>, private val mCtx: MainFragment
                         ) : RecyclerView.Adapter<CountryInfoAdapter.CountryInfoViewHolder>() {
    override fun getItemCount() = rowsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    CountryInfoViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_layout, parent, false)
    )
    override fun onBindViewHolder(holder: CountryInfoViewHolder, position: Int) {
        holder.tvTitle.text = rowsList.get(position).title;
        holder.tvdescription.text=rowsList.get(position).description;
        Glide.with(mCtx)
            .load(rowsList.get(position).imageHref)
            .into(holder.img);
    }
    inner class CountryInfoViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle = view.textViewTitle;
        val tvdescription=view.textViewDescription;
        val img=view.imageView;
    }
}