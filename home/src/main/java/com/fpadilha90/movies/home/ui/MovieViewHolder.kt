/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.example.paging.pagingwithnetwork.reddit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fpadilha90.movies.common.model.Movie
import android.animation.ValueAnimator
import com.fpadilha90.movies.common.extension.loadFromUrl
import com.fpadilha90.movies.home.R


/**
 * A RecyclerView ViewHolder that displays a reddit post.
 */
class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.name)
    private val rate: TextView = view.findViewById(R.id.rate)
    private val background: ImageView = view.findViewById(R.id.background)
    //    private val subtitle: TextView = view.findViewById(R.id.subtitle)
//    private val score: TextView = view.findViewById(R.id.score)
//    private val thumbnail : ImageView = view.findViewById(R.id.thumbnail)
    private lateinit var movie: Movie

    init {
        view.setOnClickListener {
            expand()
//            post?.url?.let { url ->
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                view.context.startActivity(intent)
//            }
        }
    }

    private fun expand() {
        val anim = ValueAnimator.ofInt(itemView.measuredHeight, 600)
        anim.addUpdateListener { valueAnimator ->
            val `val` = valueAnimator.animatedValue as Int
            val layoutParams = itemView.layoutParams
            layoutParams.height = `val`
            itemView.layoutParams = layoutParams
        }
        anim.duration = 200
        anim.start()
    }

    fun bind(movie: Movie) {
        this.movie = movie

        name.text = movie.name
        rate.text = movie.vote_average.toString()
        //TODO: find a place to this url
        background.loadFromUrl("https://image.tmdb.org/t/p/w500" + movie.backdrop_path)
//        title.text = post?.title ?: "loading"
//        subtitle.text = itemView.context.resources.getString(R.string.post_subtitle,
//                post?.author ?: "unknown")
//        score.text = "${post?.score ?: 0}"
//        if (post?.thumbnail?.startsWith("http") == true) {
//            thumbnail.visibility = View.VISIBLE
//            glide.load(post.thumbnail)
//                    .centerCrop()
//                    .placeholder(R.drawable.ic_insert_photo_black_48dp)
//                    .into(thumbnail)
//        } else {
//            thumbnail.visibility = View.GONE
//            glide.clear(thumbnail)
//        }
    }

    companion object {
        fun create(parent: ViewGroup): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
            return MovieViewHolder(view)
        }
    }
}