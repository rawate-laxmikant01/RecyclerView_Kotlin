package com.example.assignment_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rv)
        val mlist = ArrayList<ItemsViewModel>()
        recyclerView.layoutManager = LinearLayoutManager(this)

        mlist.add(ItemsViewModel("Laxmikant","20-sep-2021","Felix","Android","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("Ram","20-sep-2021","Felix","Android","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("Sam","20-sep-2021","Felix","Android","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("Raj","20-sep-2021","Felix","Android","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("ram","20-sep-2021","Felix","Android","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("ram","20-sep-2021","Felix","Android","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("ram","20-sep-2021","Felix","Android","Viman nager ,Pune"))


        val adapter = CustomAdapter(mlist)
        recyclerView.adapter = adapter


    }
}