package ru.nomadmoon.nameconsent

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout

class RVAdapter(val myDataset: ArrayList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mView.text=myDataset[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val but = Button(parent.context)
        but.setLayoutParams(FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200))
        return ViewHolder(but)
    }


    inner class ViewHolder(val mView: Button) : RecyclerView.ViewHolder(mView)

     override fun getItemCount(): Int {
        return myDataset.size
    }
}