package com.fpadilha90.movies.home.ui

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fpadilha90.movies.common.extension.*
import com.fpadilha90.movies.common.model.Movie
import com.fpadilha90.movies.home.R


/**
 * A RecyclerView ViewHolder that displays a movie.
 */
class MovieViewHolder(view: View, expand: (viewHolder: MovieViewHolder) -> Unit) : RecyclerView.ViewHolder(view) {
    private var initialHeight: Int = 0
    private val name: TextView = view.findViewById(R.id.name)
    private val rate: TextView = view.findViewById(R.id.rate)
    private val background: ImageView = view.findViewById(R.id.background)
    private val curtain: View = view.findViewById(R.id.curtain)
    private val overview: TextView = view.findViewById(R.id.overview)
    private lateinit var movie: Movie

    init {
        view.setOnClickListener {
            expand(this)
        }
    }

    fun bind(movie: Movie) {
        this.movie = movie

        name.text = movie.name
        rate.text = movie.vote_average.toString()
        overview.text = movie.overview
        //TODO: find a place to this url
        background.loadFromUrl("https://image.tmdb.org/t/p/w500" + movie.backdrop_path)
    }

    fun collapse() {
        //todo: dp values
        setIsRecyclable(true)
        val anim = ValueAnimator.ofInt(itemView.measuredHeight, initialHeight)
        anim.addUpdateListener {
            val `val` = it.animatedValue as Int
            val layoutParams = itemView.layoutParams
            layoutParams.height = `val`
            itemView.layoutParams = layoutParams
            curtain.gone()
            overview.gone()
        }
        anim.duration = 200
        anim.start()
    }

    fun expand() {
        if (initialHeight == 0) initialHeight = itemView.measuredHeight
        //todo: dp values
        setIsRecyclable(false)
        val anim = ValueAnimator.ofInt(itemView.measuredHeight, itemView.measuredHeight + 300)
        anim.addUpdateListener {
            val `val` = it.animatedValue as Int
            val layoutParams = itemView.layoutParams
            layoutParams.height = `val`
            itemView.layoutParams = layoutParams
            curtain.visible()
            overview.visible()
        }
        anim.duration = 200
        anim.start()
    }

    companion object {

        fun create(parent: ViewGroup, listener: (viewHolder: MovieViewHolder) -> Unit): MovieViewHolder {
            return MovieViewHolder(parent.inflate(R.layout.item_movie), listener)
        }
    }
}