package com.example.assignment_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedicalSpecialtyAdapter(var list: ArrayList<MedicalSpecialtyResponseModel>) :
    RecyclerView.Adapter<MedicalSpecialtyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val MedicalSpecialtyResponseModel = list[position]

        holder.cust_disease.text = MedicalSpecialtyResponseModel.disease
        holder.cust_reason.text =  MedicalSpecialtyResponseModel.resone
        holder.cust_details.text =  MedicalSpecialtyResponseModel.details


    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val cust_disease: TextView = itemView.findViewById(R.id.tvLblSpeciality)
        val cust_reason: TextView = itemView.findViewById(R.id.tvLblIssues)
        val cust_details: TextView = itemView.findViewById(R.id.tvSymptoms)


    }

}
