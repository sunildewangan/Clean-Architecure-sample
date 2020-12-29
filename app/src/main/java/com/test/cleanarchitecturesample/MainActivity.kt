package com.test.cleanarchitecturesample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.test.cleanarchitecturesample.databinding.ActivityMainBinding
import com.test.cleanarchitecturesample.domain.HerosModel
import com.test.cleanarchitecturesample.domain.PopularHeroViewState
import com.test.cleanarchitecturesample.framework.MyApplication
import com.test.cleanarchitecturesample.presentation.main.MainAdapter
import com.test.cleanarchitecturesample.presentation.main.MainMoviesVMFactory
import com.test.cleanarchitecturesample.presentation.main.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var factory: MainMoviesVMFactory
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel
    private var heroList = ArrayList<HerosModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).mainComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        adapter = MainAdapter(heroList)
        binding.recyclerView.adapter = adapter

        viewModel.viewState.observe(this, Observer {
            if (it != null) handleViewState(it)
        })

        viewModel.getHeroList()
    }

    private fun handleViewState(state: PopularHeroViewState) {
        binding.progressbar.visibility = if (state.showLoading) View.VISIBLE else View.GONE
        state.movies?.let {
            heroList.addAll(it)
            adapter.notifyDataSetChanged() }
    }
}