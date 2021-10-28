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

        mlist.add(ItemsViewModel("Laxmikant Ganpatrao Rawate","20-sep-2021","Felix","Android","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("Ram","20-sep-2021 kjfieheiheohebuif ufduffeuf ","Felix","Android","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("Sam","20-sep-2021","Felix","Android","Viman nager ,Pune , sopan nager , 123456 , lane number 2 ,near edan gardan"))
        mlist.add(ItemsViewModel("Raj","20-sep-2021","Felix","Android","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("ram","20-sep-2021","Felix","Android nfueifh hifh9ei hjeiohi  iwh hihoei ifhi ","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("ram","20-sep-2021","Felix","Android","Viman nager ,Pune"))
        mlist.add(ItemsViewModel("ram rjeebeb ihi herih kei hih r bhwo oe ei iehoetoh ie iei jow iehi eh","20-sep-2021","Felix Is is company for software development","Android","Viman nager ,Pune"))


        val adapter = CustomAdapter(mlist)
        recyclerView.adapter = adapter

    }
}