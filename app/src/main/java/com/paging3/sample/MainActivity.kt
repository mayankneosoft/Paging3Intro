package com.paging3.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.paging3.sample.databinding.ActivityMainBinding
import com.paging3.sample.paging_portion.QuotePagingAdapter
import com.paging3.sample.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewmodel: MainViewModel
    private lateinit var adapter: QuotePagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel= ViewModelProvider(this)[MainViewModel::class.java]
        adapter=QuotePagingAdapter()

        binding.rvList.layoutManager=LinearLayoutManager(this)
        binding.rvList.setHasFixedSize(true)
        binding.rvList.adapter=adapter

        viewmodel.list.observe(this, Observer {
            adapter.submitData(lifecycle,it)
        })






    }


}