package com.example.hilt.utils

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["bind:isVisible"])
fun View.isVisible(visible: Boolean?) {
    visibility = if(visible.orFalse()) View.VISIBLE else View.GONE
}