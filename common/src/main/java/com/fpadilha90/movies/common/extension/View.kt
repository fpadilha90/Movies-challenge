package com.fpadilha90.movies.common.extension

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.loadFromUrl(url: String, onResourceReady: () -> Unit = {}) =
    Glide.with(this.context.applicationContext)
        .load(url)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                p0: GlideException?,
                p1: Any?,
                p2: com.bumptech.glide.request.target.Target<Drawable>?,
                p3: Boolean
            ): Boolean {
                return true
            }

            override fun onResourceReady(
                p0: Drawable?,
                p1: Any?,
                p2: com.bumptech.glide.request.target.Target<Drawable>?,
                p3: DataSource?,
                p4: Boolean
            ): Boolean {
                onResourceReady()
                return false
            }
        })
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)

fun ImageView.loadImageRound(url: String) =
    Glide.with(this).load(url).apply(RequestOptions.circleCropTransform()).into(this)
