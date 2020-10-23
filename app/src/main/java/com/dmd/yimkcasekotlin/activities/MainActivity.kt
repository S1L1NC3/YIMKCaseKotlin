package com.dmd.yimkcasekotlin.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmd.yimkcasekotlin.R
import com.dmd.yimkcasekotlin.adapters.NewsAdapter
import com.dmd.yimkcasekotlin.viewModels.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var newsViewModel : NewsViewModel
    private val recyclerViewAdapter = NewsAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())
                .get(NewsViewModel::class.java)
        newsViewModel.refreshData()

        newsRecyclerView.layoutManager= LinearLayoutManager( applicationContext)
        newsRecyclerView.adapter = recyclerViewAdapter
    }

    override fun onStart() {
        super.onStart()

        swipeRefreshLayout.setOnRefreshListener {
            newsRecyclerView.visibility=View.GONE
            dataError.visibility=View.GONE
            dataLoading.visibility=View.VISIBLE
            newsViewModel.refreshData()
            swipeRefreshLayout.isRefreshing=false
        }

        observeLiveData()
    }

    private fun observeLiveData(){
        newsViewModel.data.observe(this, Observer { data->
            data?.let {
                newsRecyclerView.visibility = View.VISIBLE
                recyclerViewAdapter.updateList(data)
            }

        })
        newsViewModel.dataError.observe(this, Observer { error ->
            error?.let {
                if(it) {
                    dataError.visibility = View.VISIBLE
                } else {
                    dataError.visibility = View.GONE
                }
            }

        })
        newsViewModel.dataLoading.observe(this, Observer { loading->
            loading?.let {
                if (it) {
                    dataLoading.visibility = View.VISIBLE
                    newsRecyclerView.visibility = View.GONE
                    dataError.visibility = View.GONE
                } else {
                    dataLoading.visibility = View.GONE
                }
            }

        })
    }
}