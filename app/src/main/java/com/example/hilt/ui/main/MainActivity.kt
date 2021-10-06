package com.example.hilt.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.hilt.MovieAdapter
import com.example.hilt.R
import com.example.hilt.databinding.ActivityMainBinding
import com.example.hilt.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var assistedFactory: MainViewModelAssistedFactory

    override val viewModel: MainViewModel by viewModels {
        // This is just a test to pass custom params to ViewModel
        // params can come from NavArgs or intent Bundle
        Factory(assistedFactory, "100")
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun subscribeToViewModel(viewModel: MainViewModel) {
        viewModel.movieList().observe(this, {
            binding.recyclerView.adapter = MovieAdapter(it)
        })
    }
}