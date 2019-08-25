package com.fpadilha90.movies.home.ui

import android.animation.ValueAnimator
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fpadilha90.movies.common.extension.*
import com.fpadilha90.movies.common.model.Show
import com.fpadilha90.movies.home.R


/**
 * A RecyclerView ViewHolder that displays a show.
 */
class ShowViewHolder(view: View, expand: (viewHolder: ShowViewHolder) -> Unit) : RecyclerView.ViewHolder(view) {
    private var initialHeight: Int = 0
    private val name: TextView = view.findViewById(R.id.name)
    private val rate: TextView = view.findViewById(R.id.rate)
    private val background: ImageView = view.findViewById(R.id.background)
    private val curtain: View = view.findViewById(R.id.curtain)
    private val overview: TextView = view.findViewById(R.id.overview)
    private lateinit var show: Show

    init {
        view.setOnClickListener {
            expand(this)
        }
    }

    fun bind(show: Show) {
        this.show = show

        name.text = show.name
        rate.text = show.voteAverage.toString()
        overview.text = if (show.overview.isNotEmpty()) {
            show.overview
        } else {
            itemView.context.getString(R.string.empty_overview)
        }
        //TODO: find a place for this url
        show.backdropPath.let {
            background.loadFromUrl("https://image.tmdb.org/t/p/w500$it")
        }
    }

    fun collapse() {
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
        fun create(parent: ViewGroup, listener: (viewHolder: ShowViewHolder) -> Unit): ShowViewHolder {
            return ShowViewHolder(parent.inflate(R.layout.item_show), listener)
        }
    }
}