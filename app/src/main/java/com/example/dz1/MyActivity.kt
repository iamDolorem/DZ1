package com.example.dz1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyActivity: AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    private val adapter = MyAdapter()

    companion object {
        const val countKey = "countKey"
    }

    private var count = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        fab = findViewById(R.id.fab)

        recyclerView.adapter = adapter

        fab.setOnClickListener{
            adapter.addItems(adapter.itemCount + 1)
        }

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(countKey)
            for (i in 1..count) {
                adapter.addItems(i)
            }
        } else {
            adapter.setItems(listOf(1,2,3,4,5))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(countKey, adapter.itemCount)
    }
}