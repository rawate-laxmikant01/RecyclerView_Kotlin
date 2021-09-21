package com.example.assignment_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var mList: ArrayList<ItemsViewModel>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        holder.cust_name.text = ItemsViewModel.name
        holder.cust_date.text = ItemsViewModel.date
        holder.cust_company.text = ItemsViewModel.company
        holder.cust_des.text = ItemsViewModel.description
        holder.cust_adress.text = ItemsViewModel.adress

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val cust_name: TextView = itemView.findViewById(R.id.name)
        val cust_date: TextView = itemView.findViewById(R.id.date)
        val cust_company: TextView = itemView.findViewById(R.id.company)
        val cust_des: TextView = itemView.findViewById(R.id.description)
        val cust_adress: TextView = itemView.findViewById(R.id.address)

    }

}


