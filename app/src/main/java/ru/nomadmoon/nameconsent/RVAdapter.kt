package ru.nomadmoon.nameconsent

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class RVAdapter(val myDataset: Array<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mView.text=myDataset[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val but = Button(parent.context)
        return ViewHolder(but)
    }


    inner class ViewHolder(val mView: Button) : RecyclerView.ViewHolder(mView)

     override fun getItemCount(): Int {
        return myDataset.size
    }
}