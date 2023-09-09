package com.porfirio.mvvmdm.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.porfirio.mvvmdm.R
import com.porfirio.mvvmdm.data.remote.model.AnimeDto
import com.porfirio.mvvmdm.databinding.ActivityMainBinding
import com.porfirio.mvvmdm.ui.adapter.AnimesAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var animes = mutableListOf<AnimeDto>()

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = AnimesAdapter(animes)

        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }

        binding.btnAdd.setOnClickListener {
            mainViewModel.updateAnimeRestApi()
        }

        mainViewModel.anime.observe(this, Observer { anime ->
            animes.add(anime)
            myAdapter.notifyItemInserted(animes.size-1)
        })
    }
}
