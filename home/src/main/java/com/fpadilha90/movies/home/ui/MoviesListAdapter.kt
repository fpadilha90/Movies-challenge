package com.fpadilha90.movies.home.ui

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.example.paging.pagingwithnetwork.reddit.ui.MovieViewHolder
import com.fpadilha90.movies.common.model.Movie
import com.fpadilha90.movies.common.model.NetworkState
import com.fpadilha90.movies.home.R


class MoviesListAdapter(
    private val retryCallback: () -> Unit)
    : PagedListAdapter<Movie, RecyclerView.ViewHolder>(POST_COMPARATOR) {
    private var networkState: NetworkState? = null
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.item_movie -> (holder as MovieViewHolder).bind(getItem(position)!!)
            R.layout.item_network_state -> (holder as NetworkStateItemViewHolder).bindTo(
                networkState)
        }
    }

//    override fun onBindViewHolder(
//        holder: RecyclerView.ViewHolder,
//        position: Int,
//        payloads: MutableList<Any>) {
//        if (payloads.isNotEmpty()) {
//            val item = getItem(position)
//            (holder as MovieViewHolder).updateScore(item)
//        } else {
//            onBindViewHolder(holder, position)
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_movie -> MovieViewHolder.create(parent)
            R.layout.item_network_state -> NetworkStateItemViewHolder.create(parent, retryCallback)
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    private fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            R.layout.item_network_state
        } else {
            R.layout.item_movie
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasExtraRow()) 1 else 0
    }

    fun setNetworkState(newNetworkState: NetworkState) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }

    companion object {
//        private val PAYLOAD_SCORE = Any()
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.id == newItem.id

//            override fun getChangePayload(oldItem: Movie, newItem: Movie): Any? {
//                return if (sameExceptScore(oldItem, newItem)) {
//                    PAYLOAD_SCORE
//                } else {
//                    null
//                }
//            }
        }

//        private fun sameExceptScore(oldItem: Movie, newItem: Movie): Boolean {
//            // DON'T do this copy in a real app, it is just convenient here for the demo :)
//            // because reddit randomizes scores, we want to pass it as a payload to minimize
//            // UI updates between refreshes
//            return oldItem.copy(score = newItem.score) == newItem
//        }
    }
}
//class MoviesListAdapter(private val list: List<Movie>) : RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return MovieViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        val movie: Movie = list[position]
//        holder.bind(movie)
//    }
//
//    override fun getItemCount(): Int = list.size
//    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val background: ImageView
//        private val name: TextView
//        private val rate: TextView
//
//        init {
//            background = itemView.findViewById(R.id.background)
//            name = itemView.findViewById(R.id.name)
//            rate = itemView.findViewById(R.id.rate)
//        }
//
//        fun bind(movie: Movie) {
//            name.text = movie.name
//            rate.text = movie.voteAverage.toString()
//            //TODO: find a place to this url
//            background.loadFromUrl("https://image.tmdb.org/t/p/w500" + movie.backdropPath)
//        }
//    }
//}