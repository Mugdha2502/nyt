package com.example.nyt.ui.main

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nyt.R
import com.example.nyt.adapter.PopularListAdapter
import com.example.nyt.data.Data
import com.example.nyt.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: PopularListAdapter
    lateinit var progressBar: ProgressBar

    lateinit var list: List<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchView: SearchView = findViewById(R.id.search_view)
        searchView.setOnQueryTextListener(this)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        progressBar = findViewById(R.id.progress_bar)

        viewModel.getMostPopular()
        viewModel.response.subscribe { result ->

//            if (result != null) {
                list = result.data

                setAdapter(list)

                progressBar.visibility = View.GONE
//            }
        }

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        progressBar.visibility = View.VISIBLE

        if (!query.isNullOrEmpty())
            setAdapter(list.filter {
                it.title!!.toLowerCase().contains(query.toLowerCase())
            })

        progressBar.visibility = View.GONE
        return false
    }

    private fun setAdapter(list: List<Data>) {
        recyclerViewAdapter = PopularListAdapter(list)
        recyclerView.adapter = recyclerViewAdapter
        recyclerViewAdapter.notifyDataSetChanged()
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (!newText.isNullOrBlank()) {
            progressBar.visibility = View.VISIBLE

            setAdapter(list.filter {
                it.title!!.toLowerCase().contains(newText.toLowerCase())
            })

            progressBar.visibility = View.GONE
        } else {
            recyclerView.adapter = PopularListAdapter(list)
            recyclerViewAdapter.notifyDataSetChanged()
        }
        return false
    }
}