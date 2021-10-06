package com.example.hilt.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.hilt.BR

abstract class BaseActivity<B : ViewDataBinding, ModelT : ViewModel> : AppCompatActivity() {

    protected lateinit var binding: B
    abstract val viewModel: ModelT

    protected abstract fun getLayoutId(): Int

    protected abstract fun subscribeToViewModel(viewModel: ModelT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        subscribeToViewModel(viewModel)
    }
}