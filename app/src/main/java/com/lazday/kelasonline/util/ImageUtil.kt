package com.lazday.kelasonline.util

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.lazday.kelasonline.R

fun loadImage(imageView: ImageView, urlString: String){
    Glide.with(imageView)
        .load(urlString)
        .placeholder(R.drawable.placeholder)
        .into(imageView)
}

fun loadAvatar(imageView: ImageView, urlString: String){
    Glide.with(imageView)
            .load(urlString)
            .placeholder(R.drawable.placeholder)
            .circleCrop()
            .into(imageView)
}

fun loadUri(imageView: ImageView, uri: Uri){
    Glide.with(imageView)
            .load(uri)
            .placeholder(R.drawable.placeholder)
            .circleCrop()
            .into(imageView)
}