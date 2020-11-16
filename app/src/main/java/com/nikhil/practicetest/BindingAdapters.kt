package com.nikhil.practicetest

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:printAge")
fun printAge(textView: TextView, i : Int) {
    textView.text = "$i years"
}