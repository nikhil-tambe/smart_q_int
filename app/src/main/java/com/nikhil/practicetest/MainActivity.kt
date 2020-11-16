package com.nikhil.practicetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = UserRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = MainRepo()

        val bool = repo.isItemAvailable("Dosa", System.currentTimeMillis())
        Log.d("Main", "onCreate: $bool")

        userRecyclerView.adapter = adapter
        adapter.submitList(repo.getUserList())

    }
}