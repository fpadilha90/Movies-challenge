package com.fpadilha90.movies.home.ui

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fpadilha90.movies.common.model.Show
import com.fpadilha90.movies.common.model.NetworkState
import com.fpadilha90.movies.home.R


class ShowsListAdapter(
    private val retryCallback: () -> Unit)
    : PagedListAdapter<Show, RecyclerView.ViewHolder>(SHOW_COMPARATOR) {
    private var expandedShow: ShowViewHolder? = null
    private var networkState: NetworkState? = null
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.item_show -> (holder as ShowViewHolder).bind(getItem(position)!!)
            R.layout.item_network_state -> (holder as NetworkStateItemViewHolder).bindTo(
                networkState)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_show -> ShowViewHolder.create(parent) {
                if (expandedShow == it) {
                    it.collapse()
                    expandedShow = null
                } else {
                    it.expand()
                    expandedShow?.collapse()
                    expandedShow = it
                }
            }
            R.layout.item_network_state -> NetworkStateItemViewHolder.create(parent, retryCallback)
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    private fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            R.layout.item_network_state
        } else {
            R.layout.item_show
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
        val SHOW_COMPARATOR = object : DiffUtil.ItemCallback<Show>() {
            override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Show, newItem: Show): Boolean =
                oldItem.id == newItem.id
        }
    }
}