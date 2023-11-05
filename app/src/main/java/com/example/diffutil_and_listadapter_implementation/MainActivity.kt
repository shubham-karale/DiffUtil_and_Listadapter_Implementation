package com.example.diffutil_and_listadapter_implementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recylerView)

        val adapter = ProgrammingAdapter()

        val lan1 = ProgrammingItem(1, "K", "Kotlin")
        val lan2 = ProgrammingItem(2, "J", "Java")
        val lan3 = ProgrammingItem(3, "P", "Python")
        val lan4 = ProgrammingItem(4, "C", "C++")
        val lan5 = ProgrammingItem(5, "J", "Javascript")

        adapter.submitList(listOf(lan1, lan2, lan3, lan4, lan5))    // submitList() is a method of ListAdapter class

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val lan6 = ProgrammingItem(6, "G", "Go")
            val lan7 = ProgrammingItem(7, "R", "Ruby")
            val lan8 = ProgrammingItem(8, "S", "Swift")
            val lan9 = ProgrammingItem(9, "D", "Dart")
            val lan10 = ProgrammingItem(10, "P", "PHP")

            adapter.submitList(listOf(lan1, lan2, lan3, lan4, lan5, lan6, lan7, lan8, lan9, lan10))
        },4000)

    }
}