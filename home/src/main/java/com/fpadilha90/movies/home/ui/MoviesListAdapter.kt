package com.fpadilha90.movies.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fpadilha90.movies.common.extension.loadFromUrl
import com.fpadilha90.movies.common.model.Movie
import com.fpadilha90.movies.home.R

class MoviesListAdapter(private val list: List<Movie>) : RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val background: ImageView
        private val name: TextView
        private val rate: TextView

        init {
            background = itemView.findViewById(R.id.background)
            name = itemView.findViewById(R.id.name)
            rate = itemView.findViewById(R.id.rate)
        }

        fun bind(movie: Movie) {
            name.text = movie.name
            rate.text = movie.voteAverage.toString()
            background.loadFromUrl(movie.backdropPath)
        }
    }
}