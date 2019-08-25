package com.fpadilha90.movies.home.ui

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fpadilha90.movies.common.extension.invisible
import com.fpadilha90.movies.common.extension.loadFromUrl
import com.fpadilha90.movies.common.extension.visible
import com.fpadilha90.movies.common.model.Movie
import com.fpadilha90.movies.home.R


/**
 * A RecyclerView ViewHolder that displays a movie.
 */
class MovieViewHolder(view: View, expand: (viewHolder: MovieViewHolder) -> Unit) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.name)
    private val rate: TextView = view.findViewById(R.id.rate)
    private val shadow: View = view.findViewById(R.id.shadow)
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
        rate.text = movie.voteAverage.toString()
        overview.text = movie.overview
        //TODO: find a place to this url
        movie.backdropPath.let {
            background.loadFromUrl("https://image.tmdb.org/t/p/w500$it") {
                shadow.visible()
            }
        }
    }

    fun collapse() {
        //todo: dp values
        setIsRecyclable(true)
        val anim = ValueAnimator.ofInt(itemView.measuredHeight, 200)
        anim.addUpdateListener { valueAnimator ->
            val `val` = valueAnimator.animatedValue as Int
            val layoutParams = itemView.layoutParams
            layoutParams.height = `val`
            itemView.layoutParams = layoutParams
            curtain.invisible()
            overview.invisible()
        }
        anim.duration = 200
        anim.start()
    }
    fun expand() {
        //todo: dp values
        setIsRecyclable(false)
        val anim = ValueAnimator.ofInt(itemView.measuredHeight, 600)
        anim.addUpdateListener { valueAnimator ->
            val `val` = valueAnimator.animatedValue as Int
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
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
            return MovieViewHolder(view, listener)
        }
    }
}